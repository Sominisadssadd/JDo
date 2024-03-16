package com.example.authentication.domain.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(

    //ADD EMAIL FIELD

    @SerialName("userId")
    val userId: Double = DEFAULT_USER_ID_VALUE,
    @SerialName("name")
    val name: String = DEFAULT_USER_NAME,
    @SerialName("serName")
    val serName: String = DEFAULT_USER_SER_NAME,
    @SerialName("email")
    val email: String = DEFAULT_USER_EMAIL,
    @SerialName("phone")
    val phone: String,
    @SerialName("password")
    val password: String,
    @SerialName("login")
    val login: String,
    @SerialName("roleid")
    val roleid: Int = DEFAULT_USER_ROLE_ID_VALUE,
    @SerialName("imageId")
    val imageId: String = DEFAULT_USER_IMAGE_PATH

) {
    companion object {
        private const val DEFAULT_USER_ROLE_ID_VALUE = 1
        private const val DEFAULT_USER_ID_VALUE = 0.0
        private const val DEFAULT_USER_NAME = "Name"
        private const val DEFAULT_USER_SER_NAME = "SerName"
        private const val DEFAULT_USER_EMAIL = "email"
        private const val DEFAULT_USER_IMAGE_PATH = "empty"
    }
}