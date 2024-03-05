package com.example.core.base.dialog

import android.app.AlertDialog
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.R

fun Fragment.dialogLoadingInfo(customView: Int): AlertDialog {
    return AlertDialog.Builder(requireContext())
        .setView(customView)
        .create()

}