package com.example.profile.presentation.mainprofile

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.models.profile.ProfileUser
import com.example.profile.R
import com.example.profile.data.remote_data_source.api.ProfileApiRepositoryImpl
import com.example.profile.domain.api.usecase.ProfileGetUserDataByLoginUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class MainProfileFragmentViewModel(private val context: Context) : ViewModel() {


    private val repositoryImpl = ProfileApiRepositoryImpl(context)
    private val profileGetUserDataByLoginUseCase = ProfileGetUserDataByLoginUseCase(repositoryImpl)



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

     fun getUserInfo() {
        profileGetUserDataByLoginUseCase()
            .onStart {
                setLoadingStatus(true)
            }
            .map {
                it.data ?: error("Cant fetch data")
            }
            .onEach {
                pudDataUser(it)
            }
            .catch {
                sendError(context.getString(R.string.error_connection_erorr))
                setLoadingStatus(false)
            }
            .onCompletion {
                setLoadingStatus(false)
                successTrue()
            }
            .launchIn(viewModelScope)
    }


}