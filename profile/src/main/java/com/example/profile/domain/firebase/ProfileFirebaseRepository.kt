package com.example.profile.domain.firebase

import com.example.profile.domain.firebase.model.ResultResponse

interface ProfileFirebaseRepository {

    fun loadImageAndGetUrl(uri: String, completion: (ResultResponse) -> Unit)

}