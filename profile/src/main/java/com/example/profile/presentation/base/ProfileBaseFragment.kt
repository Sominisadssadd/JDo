package com.example.profile.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.core.base.BaseFragment
import com.example.profile.databinding.ProfileBaseFragmentBinding

class ProfileBaseFragment : BaseFragment<ProfileBaseFragmentBinding, ProfileBaseFragmentViewModel>(
    ProfileBaseFragmentViewModel::class,
    null
) {
    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ProfileBaseFragmentBinding {
        return ProfileBaseFragmentBinding.inflate(inflater, container, false)
    }

    companion object{
        fun newInstance() = ProfileBaseFragment()
    }
}