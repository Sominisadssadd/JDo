package com.example.profile.domain.firebase.usecase

import com.example.profile.domain.firebase.ProfileFirebaseRepository
import com.example.profile.domain.firebase.model.ResultResponse

class ProfileUseCaseLoadImageInFirebaseStorage(private val repository: ProfileFirebaseRepository) {

    operator fun invoke(uri: String, onCompletion: (ResultResponse) -> Unit) {
        return repository.loadImageAndGetUrl(uri) {
            onCompletion.invoke(it)
        }
    }

}