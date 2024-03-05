package com.example.authentication.presentation.mainfrgment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthenticationBaseFragmentViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun setLoadingStatus(status: Boolean) {
        _loading.value = status
    }

}