package com.example.profile.data.remote_data_source.firebase

import android.widget.Toast
import androidx.core.net.toUri
import com.example.core.extension.getUniqueValueFormString
import com.example.profile.domain.firebase.ProfileFirebaseRepository
import com.example.profile.domain.firebase.model.ResultResponse
import com.google.firebase.storage.FirebaseStorage

class ProfileFirebaseRepositoryImpl : ProfileFirebaseRepository {
    override fun loadImageAndGetUrl(uri: String, completion: (ResultResponse) -> Unit) {
        var imageUrl: String = EMPTY
        val storageRef = FirebaseStorage.getInstance().reference
        val imagesRef = storageRef.child("image/{${uri.getUniqueValueFormString()}}")

        val uploadTask = imagesRef.putFile(uri.toUri())
        uploadTask.addOnSuccessListener { uploadTask ->
            imagesRef.downloadUrl.addOnSuccessListener { uri ->
                imageUrl = uri.toString()
                completion(ResultResponse(data = imageUrl, success = true))
            }.addOnFailureListener {
                completion(ResultResponse(data = imageUrl, success = false))
            }
        }
    }

    companion object {
        private const val EMPTY = ""
    }
}