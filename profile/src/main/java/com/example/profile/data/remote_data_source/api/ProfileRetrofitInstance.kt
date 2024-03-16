package com.example.profile.data.remote_data_source.api

import com.example.core.base.retrofit.BaseInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProfileRetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:8080"
    private fun getRetrofit(): Retrofit {

        val client = BaseInterceptor.bodyLoginClient()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val apiService: ProfileApiService = getRetrofit().create(ProfileApiService::class.java)
}