package com.example.authentication.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authentication.data.datasources.RetrofitInstance
import com.example.authentication.domain.api.model.User
import com.example.authentication.domain.api.usecase.GetUserByLoginUseCase
import com.example.response.ResultResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthenticationLoginFragmentViewModel() : ViewModel() {

    //Change injections by dagger
    val apiService = RetrofitInstance.apiService
    private val getUserByLoginUseCase = GetUserByLoginUseCase(apiService)

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _data = MutableLiveData<Any>()
    val data: LiveData<Any>
        get() = _data

    private val _success = MutableLiveData<Int>()
    val success: LiveData<Int>
        get() = _success

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun successTrue(userId: Int) {
        _success.value = userId
    }

    fun setLoadingStatus(isLoading: Boolean) {
        _loading.value = isLoading
    }

    fun sendError(message: String) {
        _error.value = message
    }

    fun pudData(data: Any) {
        _data.value = data
    }

    fun getUserByLogin(userLogin: String): Flow<ResultResponse<User>> {
        return getUserByLoginUseCase(userLogin)
    }
}