package com.example.profile.presentation.mainprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.base.fragment.BaseFragment
import com.example.profile.databinding.MainProfileFragmentBinding

class MainProfileFragment : BaseFragment<MainProfileFragmentBinding, MainProfileFragmentViewModel>(
    MainProfileFragmentViewModel::class
) {
    override fun setUpViews() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainProfileFragmentBinding {
        return MainProfileFragmentBinding.inflate(inflater, container, false)
    }

}