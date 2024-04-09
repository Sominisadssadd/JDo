package com.example.board.presentation.taskscreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BoardTaskFragmentViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BoardTaskFragmentViewModel::class.java)){
            return BoardTaskFragmentViewModel(context) as T
        }
        throw IllegalArgumentException("unknown View Model")
    }
}