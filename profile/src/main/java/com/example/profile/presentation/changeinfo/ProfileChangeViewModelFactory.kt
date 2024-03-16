package com.example.profile.presentation.changeinfo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProfileChangeViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChangeInfoFragmentViewModel::class.java)) {

            return ChangeInfoFragmentViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}