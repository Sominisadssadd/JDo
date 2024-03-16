package com.example.profile.data.remote_data_source.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResultResponse<DT>(
    @SerialName("data")
    val data : DT?,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String
)