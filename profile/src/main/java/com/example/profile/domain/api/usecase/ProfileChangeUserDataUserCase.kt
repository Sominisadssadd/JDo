package com.example.profile.domain.api.usecase

import com.example.database.models.profile.ProfileUser
import com.example.profile.data.remote_data_source.api.response.ProfileResponseMessage
import com.example.profile.domain.api.ProfileApiRepository

class ProfileChangeUserDataUserCase(private val repository: ProfileApiRepository) {

    suspend operator fun invoke(user: ProfileUser): ProfileResponseMessage {
        return repository.changeUserData(user)
    }
}