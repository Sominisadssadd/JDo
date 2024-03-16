package com.example.database.models.profile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ProfileImage(
    @SerialName("idImage")
    private val idImage: Int,
    @SerialName("imageUrl")
    private var imageUrl: String

) {
    fun changeImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }
    fun getImageUrl() = imageUrl
}