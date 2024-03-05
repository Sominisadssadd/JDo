package com.example.authentication.domain.api.usecase

import com.example.authentication.data.datasources.api.ApiService
import com.example.authentication.domain.api.model.User
import kotlinx.coroutines.flow.flow

class RegisterUserUseCase(private val apiService: ApiService) {

    operator fun invoke(user: User) = flow {
        val response = apiService.registerNewUserAccount(user)
        emit(response)
    }
}