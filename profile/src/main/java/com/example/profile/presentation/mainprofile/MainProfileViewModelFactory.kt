package com.example.profile.presentation.mainprofile

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainProfileViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainProfileFragmentViewModel::class.java)) {
            return MainProfileFragmentViewModel(context) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}