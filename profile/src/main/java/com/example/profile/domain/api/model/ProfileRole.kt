package com.example.database.models.profile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileRole(
    @SerialName("idRole")
    val idRole: Int,
    @SerialName("role")
    val role: String
)