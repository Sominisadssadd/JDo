package com.example.authentication.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authentication.data.datasources.api.RetrofitInstance
import com.example.authentication.domain.api.model.User
import com.example.authentication.domain.api.usecase.RegisterUserUseCase
import com.example.response.ResultResponse
import kotlinx.coroutines.flow.Flow

class AuthenticationRegisterFragmentViewModel : ViewModel() {

    private val apiService = RetrofitInstance.apiService

    private val registerUserUseCase = RegisterUserUseCase(apiService)

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _success = MutableLiveData<Unit>()
    val success: LiveData<Unit>
        get() = _success

    private val _result = MutableLiveData<ResultResponse<User>>()
    val result: LiveData<ResultResponse<User>>
        get() = _result
    fun setData(resultData: ResultResponse<User>) {
        _result.value = resultData
    }
    fun setSuccess() {
        _success.value = Unit
    }
    fun setError(message: String) {
        _error.value = message
    }
    fun setLoadingStatus(isLoading: Boolean) {
        _loading.value = isLoading
    }
    fun registerUser(user: User): Flow<ResultResponse<User>> {
        return registerUserUseCase(user)
    }
}