package com.example.board.presentation.boardmain

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BoardMainFragmentViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BoardMainFragmentViewModel::class.java)) {
            return BoardMainFragmentViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}