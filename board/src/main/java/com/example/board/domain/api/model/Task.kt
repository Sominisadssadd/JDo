package com.example.database.models.board

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Task(
    @SerialName("idTask")
    val idTask: Int,
    @SerialName("idBoard")
    val idBoard: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("assigned")
    val assigned: Int,
    @SerialName("idStatus")
    val idStatus: Int,
    @SerialName("deadline")
    val deadline: String,
    @SerialName("idPriority")
    val idPriority: Int,
    @SerialName("created")
    val created: String,
)