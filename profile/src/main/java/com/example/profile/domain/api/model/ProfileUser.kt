package com.example.database.models.profile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt


@Serializable
data class ProfileUser(

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
    val roleid: ProfileRole,
    @SerialName("imageId")
    val imageId: ProfileImage

) {
    fun passwordHashed() = BCrypt.hashpw(password, BCrypt.gensalt())
}