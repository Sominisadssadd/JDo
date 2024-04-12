package com.example.database.models.board

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member(
    @SerialName("idMember")
    val idMember: Int,
    @SerialName("idBoard")
    val idBoard: Int,
    @SerialName("idUser")
    val idUser: Int
)