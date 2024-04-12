package com.example.database.models.board

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Board(
    @SerialName("idBoard")
    val idBoard: Int,
    @SerialName("boardName")
    val boardName: String,
    @SerialName("idOwner")
    val idOwner: Int,
    @SerialName("description")
    val description: String
)