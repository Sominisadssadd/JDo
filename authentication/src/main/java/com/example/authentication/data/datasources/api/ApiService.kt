package com.example.authentication.data.datasources.api

import com.example.authentication.data.utils.GET_USER_BY_LOGIN
import com.example.authentication.data.utils.POST_USER_REGISTER
import com.example.authentication.domain.api.model.User
import com.example.response.MessageResponse
import com.example.response.ResultResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET(GET_USER_BY_LOGIN)
    suspend fun getUserByLogin(@Path("login") userLogin: String): ResultResponse<User>

    @POST(POST_USER_REGISTER)
    suspend fun registerNewUserAccount(@Body user: User): ResultResponse<User>

}