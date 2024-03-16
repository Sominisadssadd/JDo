package com.example.profile.presentation.changeinfo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.models.profile.ProfileUser
import com.example.profile.R
import com.example.profile.data.remote_data_source.api.ProfileApiRepositoryImpl
import com.example.profile.data.remote_data_source.firebase.ProfileFirebaseRepositoryImpl
import com.example.profile.domain.api.usecase.ProfileChangeUserDataUserCase
import com.example.profile.domain.api.usecase.ProfileGetUserDataByLoginUseCase
import com.example.profile.domain.firebase.usecase.ProfileUseCaseLoadImageInFirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ChangeInfoFragmentViewModel(private val context: Context) : ViewModel() {

    val fireBaseRepository = ProfileFirebaseRepositoryImpl()
    val apiRepository = ProfileApiRepositoryImpl(context)

    val profileLoadImage = ProfileUseCaseLoadImageInFirebaseStorage(fireBaseRepository)
    val profileGetUserDataLogin = ProfileGetUserDataByLoginUseCase(apiRepository)
    val profileChangeUserData = ProfileChangeUserDataUserCase(apiRepository)


    private lateinit var _currentUser: ProfileUser
    fun setCurrentUser(user: ProfileUser) {
        _currentUser = user
    }

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _dataUser = MutableLiveData<ProfileUser>()
    val dataUser: LiveData<ProfileUser>
        get() = _dataUser

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean>
        get() = _success

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun successTrue() {
        _success.value = true
    }

    fun setLoadingStatus(isLoading: Boolean) {
        _loading.value = isLoading
    }

    fun sendError(message: String) {
        _error.value = message
    }

    fun pudDataUser(user: ProfileUser) {
        _dataUser.value = user
    }

    private fun changeUserData(
        user: ProfileUser
    ) {
        viewModelScope.launch {
            try {
                val result = profileChangeUserData(user)
                if (result.success) {
                    successTrue()
                } else {
                    sendError("Чё то не обновилось")
                }
            } catch (e: Exception) {
                sendError("Проблема с изменением данных пользователя")
            }
        }.invokeOnCompletion {
            setLoadingStatus(false)
        }
    }

    fun changeUserDataForEachField(
        name: String = _currentUser.name,
        serName: String = _currentUser.serName,
        email: String = _currentUser.email,
        phone: String = _currentUser.phone,
        password: String = _currentUser.password,
    ) {
        setLoadingStatus(true)

        if (!checkInputDataIsCorrect(name, serName, phone, email)) {
            setLoadingStatus(false)
            return
        }

        val user = ProfileUser(
            userId = _currentUser.userId,
            name = name,
            serName = serName,
            email = email,
            phone = phone,
            password = password,
            login = _currentUser.login,
            roleid = _currentUser.roleid,
            imageId = _currentUser.imageId
        )
        changeUserData(user)
        getUserData()
    }

    private fun checkInputDataIsCorrect(
        name: String,
        serName: String,
        phone: String,
        email: String
    ): Boolean {

        if (name.isEmpty()) {
            val error = context.getString(R.string.error_wrong_name_lenght)
            sendError(error)
            return false
        }
        if (serName.isEmpty()) {
            val error = context.getString(R.string.error_wrong_serName_lenght)
            sendError(error)
            return false
        }
        if (email.isNotEmpty()) {
            val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")
            if (!email.matches(emailRegex)) {
                val error = context.getString(R.string.error_wrong_email)
                sendError(error)
                return false
            }
        }
        if (phone.isNotEmpty()) {
            val phoneRegex = Regex("^\\d{11}\$")
            if (!phoneRegex.matches(phone)) {
                val error = context.getString(R.string.error_wrong_phone)
                sendError(error)
                return false
            }
        }
        return true
    }

    fun getUserData() {
        setLoadingStatus(true)
        profileGetUserDataLogin()
            .onEach {
                val user = it.data
                if (user == null) {
                    sendError("User == null")
                } else {
                    pudDataUser(user)
                }
            }
            .catch {
                sendError("Данные пользователя не вышло получить")
            }
            .launchIn(viewModelScope)
            .invokeOnCompletion { setLoadingStatus(false) }
    }

    fun loadImageIntoFirebase(uri: String) {
        val error = context.getString(R.string.imageUrlIsEmpty)
        setLoadingStatus(true)
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    suspendCoroutine { continuation ->
                        profileLoadImage(uri) {
                            continuation.resume(it)
                        }
                    }
                }
                if (!result.success) {
                    sendError("Не успешно")
                    return@launch
                }
                _currentUser.imageId.changeImageUrl(result.data!!)
                changeUserData(_currentUser)

            } catch (e: Exception) {
                sendError(error)
            }
        }.invokeOnCompletion {
            setLoadingStatus(false)
        }
    }

    companion object {
        private const val EMPTY_VALUE = ""
    }

}