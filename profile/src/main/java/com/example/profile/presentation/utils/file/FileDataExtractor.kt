package com.example.profile.presentation.utils.file

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.provider.MediaStore
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.flow

class FileDataExtractor(
    private val fragment: Fragment,
    private val resultListener: (Boolean) -> Unit
) {

    init {
        checkUserPermissions()
    }

    private fun checkUserPermissions() {
        if (ContextCompat.checkSelfPermission(
                fragment.requireActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            resultListener.invoke(false)
        } else {
            resultListener.invoke(true)
        }
    }


    private val PICK_IMAGE_REQUEST = 1

    fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        fragment.startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    fun handleActivityResult(requestCode: Int, resultCode: Int, data: Intent?,dataGetter:(String)->Unit) {
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            val selectedImageUri = data?.data.toString()
            dataGetter.invoke(selectedImageUri)
        }
    }




}