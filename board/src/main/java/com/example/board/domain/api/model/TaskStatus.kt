package com.example.database.models.board

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskStatus(
    @SerialName("idStatus")
    var idStatus: Int,
    @SerialName("status")
    val status: String
)