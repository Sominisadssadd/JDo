package com.example.database.models.board

import com.example.board.domain.api.model.User
import com.example.response.TaskResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoardInfo(
    @SerialName("tasks")
    val tasks: List<TaskResponse>,
    @SerialName("members")
    val members: List<User>
)