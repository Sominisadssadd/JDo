package com.example.profile.data.remote_data_source.api

import android.content.Context
import com.example.core.extension.getCurrentUserLogin
import com.example.database.models.profile.ProfileUser
import com.example.profile.data.remote_data_source.api.response.ProfileResponseMessage
import com.example.profile.data.remote_data_source.api.response.ProfileResultResponse
import com.example.profile.domain.api.ProfileApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfileApiRepositoryImpl(private val context: Context) : ProfileApiRepository {


    val apiService = ProfileRetrofitInstance.apiService
    override suspend fun changeUserData(user: ProfileUser): ProfileResponseMessage {
        return apiService.changeUserData(user)
    }

    override suspend fun getUserDataByLogin(): ProfileResultResponse<ProfileUser> {
        val loginUser = getCurrentUserLogin(context = context)
        val userData = apiService.getUserDataByLogin(loginUser)
        return userData
    }
}