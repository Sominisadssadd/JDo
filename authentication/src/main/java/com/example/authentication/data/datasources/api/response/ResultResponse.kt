package com.example.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse<DT>(
    @SerialName("data")
    val data: DT?,
    @SerialName("message")
    val message: String,
    @SerialName("success")
    val success: Boolean
)