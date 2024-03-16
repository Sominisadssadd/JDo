package com.example.core.base.dialog

import android.app.Activity
import android.view.View
import androidx.core.view.KeyEventDispatcher.Component
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
fun Fragment.snackBarMessage(message: String){
    val view = this.requireView()
    Snackbar.make(view,message,Snackbar.LENGTH_LONG).show()
}