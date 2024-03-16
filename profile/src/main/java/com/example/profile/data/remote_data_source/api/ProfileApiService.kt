package com.example.profile.data.remote_data_source.api

import com.example.database.models.profile.ProfileUser
import com.example.profile.data.remote_data_source.api.response.ProfileResponseMessage
import com.example.profile.data.remote_data_source.api.response.ProfileResultResponse
import com.example.profile.data.utils.REQUEST_GET_USER_DATA
import com.example.profile.data.utils.REQUEST_UPDATE_IMAGE
import com.example.profile.data.utils.REQUEST_UPDATE_USER_DATA
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProfileApiService {

    @PUT(REQUEST_UPDATE_USER_DATA)
    suspend fun changeUserData(@Body user: ProfileUser): ProfileResponseMessage
    @GET(REQUEST_GET_USER_DATA)
    suspend fun getUserDataByLogin(@Path("login") login: String): ProfileResultResponse<ProfileUser>
}