package com.example.database.models.board

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("idImage")
    val idImage: Int,
    @SerialName("imageUrl")
    val imageUrl: String
)