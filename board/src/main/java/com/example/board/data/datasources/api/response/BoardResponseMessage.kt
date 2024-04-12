package com.example.board.data.datasources.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoardResponseMessage(
    @SerialName("message")
    val message: String,
    @SerialName("success")
    val success: Boolean
)