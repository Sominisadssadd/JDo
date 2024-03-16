package com.example.profile.data.remote_data_source.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponseMessage(
    @SerialName("message")
    val message: String,
    @SerialName("success")
    val success: Boolean
)