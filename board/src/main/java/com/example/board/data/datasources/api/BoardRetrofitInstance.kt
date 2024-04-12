package com.example.board.data.datasources.api

import com.example.core.base.retrofit.BaseInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BoardRetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:8080"
    private fun getRetrofit(): Retrofit {

        val client = BaseInterceptor.bodyLoginClient()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val apiService: BoardApiService = getRetrofit().create(BoardApiService::class.java)
}