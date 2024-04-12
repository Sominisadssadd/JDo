package com.example.database.models.board

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskPriority(
    @SerialName("idPriority")
    var idPriority: Int,
    @SerialName("priority")
    val priority: String
)