package com.example.profile.presentation.base

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import com.example.core.base.fragment.BaseFragment
import com.example.core.extension.getUniqueValueFormString
import com.example.profile.databinding.ProfileBaseFragmentBinding
import com.example.profile.presentation.changeinfo.ChangeInfoFragment
import com.example.profile.presentation.mainprofile.MainProfileFragment
import com.example.profile.presentation.utils.file.FileDataExtractor
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.firebase.storage.FirebaseStorage
import ir.mahozad.android.PieChart
import java.util.UUID

class ProfileBaseFragment : BaseFragment<ProfileBaseFragmentBinding, ProfileBaseFragmentViewModel>(
    ProfileBaseFragmentViewModel::class,
    null
) {


    override fun setUpViews() {
        binding.apply {

        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ProfileBaseFragmentBinding {
        return ProfileBaseFragmentBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = ProfileBaseFragment()
    }
}