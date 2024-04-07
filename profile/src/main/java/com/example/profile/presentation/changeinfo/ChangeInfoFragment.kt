package com.example.profile.presentation.changeinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navArgument
import com.bumptech.glide.Glide
import com.example.core.base.dialog.snackBarErrorMessage
import com.example.core.base.dialog.snackBarMessage
import com.example.core.base.fragment.BaseFragment
import com.example.database.models.profile.ProfileUser
import com.example.profile.R
import com.example.profile.databinding.ProfileChangeInfoFragmentBinding
import com.example.profile.presentation.utils.file.FileDataExtractor

class ChangeInfoFragment(context: Context) :
    BaseFragment<ProfileChangeInfoFragmentBinding, ChangeInfoFragmentViewModel>(
        ChangeInfoFragmentViewModel::class,
        ProfileChangeViewModelFactory(context)
    ) {

    private lateinit var listener: (Boolean) -> Unit
    private lateinit var fileExtractor: FileDataExtractor
    override fun setUpViews() {
        binding.apply {
            imageViewChangePhoto.setOnClickListener {
                getImage()
            }
            buttonSaveChanges.setOnClickListener {
                changeUserInfo()
            }
            progressBarChangeInfoFragment.visibility = View.INVISIBLE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener = {
            if (!it) {
                binding.imageViewChangePhoto.isEnabled = false
            }
        }
        fileExtractor = FileDataExtractor(this, listener)
        observableEvents()
        viewModel.getUserData()
    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        fileExtractor.handleActivityResult(requestCode, resultCode, data) {
            viewModel.loadImageIntoFirebase(it)
        }
    }

    private fun observableEvents() {
        //СДЕЛАТЬ BASE TRANSACTION FRAGMENT, и потом в каждом модуле сделать своим transaction фрагменты
        viewModel.apply {
            success.observe(viewLifecycleOwner) {
                val message = getString(R.string.snack_bar_message_success)
                snackBarMessage(message)
            }
            dataUser.observe(viewLifecycleOwner) {
                setCurrentUser(it)
                setupFields(it)
            }
            error.observe(viewLifecycleOwner) {
                snackBarErrorMessage(it)
            }
            loading.observe(viewLifecycleOwner) {
                binding.apply {
                    if (it) {
                        progressBarChangeInfoFragment.visibility = View.VISIBLE
                    } else {
                        progressBarChangeInfoFragment.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }


    private fun setupFields(user: ProfileUser) {
        binding.apply {
            with(user) {
                edTextEmail.setText(email)
                edTextName.setText(name)
                edTextPhone.setText(phone)
                edTextSerName.setText(serName)

                val imageUrl = imageId.getImageUrl()
                Glide.with(binding.root)
                    .load(imageUrl)
                    .into(imageViewAvatarChangeInfoFragment)
            }
        }
    }

    private fun getImage() {
        fileExtractor.pickImageFromGallery()
    }

    private fun changeUserInfo() {
        binding.apply {
            val nameText = edTextName.text.toString()
            val serName = edTextSerName.text.toString()
            val phone = edTextPhone.text.toString()
            val email = edTextEmail.text.toString()
            viewModel.changeUserDataForEachField(
                name = nameText,
                serName = serName,
                phone = phone,
                email = email
            )
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ProfileChangeInfoFragmentBinding {
        return ProfileChangeInfoFragmentBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(context: Context): ChangeInfoFragment {
            return ChangeInfoFragment(context)
        }
    }

}