package com.example.response

import com.example.database.models.board.Image
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(

    @SerialName("userId")
    val userId: Double,
    @SerialName("name")
    val name: String,
    @SerialName("serName")
    val serName: String,
    @SerialName("email")
    val email: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("password")
    val password: String,
    @SerialName("login")
    val login: String,
    @SerialName("roleid")
    val roleId: Int,
    @SerialName("image")
    val image: Image

)