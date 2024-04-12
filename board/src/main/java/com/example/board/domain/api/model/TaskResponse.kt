package com.example.response

import com.example.database.models.board.TaskPriority
import com.example.database.models.board.TaskStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskResponse(
    @SerialName("idTask")
    val idTask: Int,
    @SerialName("idBoard")
    val idBoard: Int,
    @SerialName("title")
    var title: String,
    @SerialName("description")
    var description: String,
    @SerialName("assigned")
    val assigned: UserResponse,
    @SerialName("Status")
    val Status: TaskStatus,
    @SerialName("deadline")
    val deadline: String,
    @SerialName("Priority")
    val Priority: TaskPriority,
    @SerialName("created")
    val created: String,
) : java.io.Serializable

//оставить val и сделать через метод