package com.example.profile.domain.api

import com.example.database.models.profile.ProfileUser
import com.example.profile.data.remote_data_source.api.response.ProfileResponseMessage
import com.example.profile.data.remote_data_source.api.response.ProfileResultResponse
import com.example.profile.data.utils.REQUEST_GET_USER_DATA
import com.example.profile.data.utils.REQUEST_UPDATE_USER_DATA
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ProfileApiRepository {


    suspend fun changeUserData(user: ProfileUser): ProfileResponseMessage

    suspend fun  getUserDataByLogin(): ProfileResultResponse<ProfileUser>

}