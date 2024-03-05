package com.example.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MessageResponse (
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: Boolean
)