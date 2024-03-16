package com.example.core.base.dialog

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.core.base.fragment.BaseFragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackBarErrorMessage(message: String){
    val view = this.requireView()
    Snackbar.make(view,message,Snackbar.LENGTH_LONG).show()
}

