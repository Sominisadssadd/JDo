package com.example.board.data.datasources.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoardResultResponse<DT>(
    @SerialName("data")
    val data : DT?,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String
)