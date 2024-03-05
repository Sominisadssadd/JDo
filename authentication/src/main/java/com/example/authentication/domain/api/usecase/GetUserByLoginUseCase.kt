package com.example.authentication.domain.api.usecase

import com.example.authentication.data.datasources.api.ApiService
import com.example.authentication.domain.api.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserByLoginUseCase (private val apiService: ApiService) {
    operator fun invoke(userLogin: String) = flow {
        val response = apiService.getUserByLogin(userLogin)
        emit(response)
    }
}