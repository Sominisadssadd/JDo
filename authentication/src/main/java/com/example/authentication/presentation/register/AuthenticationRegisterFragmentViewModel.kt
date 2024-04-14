package com.example.authentication.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.authentication.data.datasources.RetrofitInstance
import com.example.authentication.domain.api.model.User
import com.example.authentication.domain.api.usecase.GetUserByLoginUseCase
import com.example.authentication.domain.api.usecase.RegisterUserUseCase
import com.example.response.ResultResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

class AuthenticationRegisterFragmentViewModel : ViewModel() {

    private val apiService = RetrofitInstance.apiService

    private val registerUserUseCase = RegisterUserUseCase(apiService)
    private val useCaseGetUserData = GetUserByLoginUseCase(apiService)

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _success = MutableLiveData<Int>()
    val success: LiveData<Int>
        get() = _success

    private val _result = MutableLiveData<ResultResponse<User>>()
    val result: LiveData<ResultResponse<User>>
        get() = _result

    fun setData(resultData: ResultResponse<User>) {
        _result.value = resultData
    }

    fun setSuccess(userId: Int) {
        _success.value = userId
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