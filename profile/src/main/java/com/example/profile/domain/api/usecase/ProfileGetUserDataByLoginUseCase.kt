package com.example.profile.domain.api.usecase

import com.example.profile.domain.api.ProfileApiRepository
import kotlinx.coroutines.flow.flow

class ProfileGetUserDataByLoginUseCase(private val repository: ProfileApiRepository) {
    operator fun invoke() = flow{
        val userData = repository.getUserDataByLogin()
        emit(userData)
    }
}