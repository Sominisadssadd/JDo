package com.example.profile.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.base.fragment.BaseFragment
import com.example.profile.databinding.ProfileSettingsFragmentBinding

class SettingsProfileFragment :
    BaseFragment<ProfileSettingsFragmentBinding, SettingsProfileFragmentViewModel>(
        SettingsProfileFragmentViewModel::class
    ) {
    override fun setUpViews() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ProfileSettingsFragmentBinding {
        return ProfileSettingsFragmentBinding.inflate(inflater, container, false)
    }
}