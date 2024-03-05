package com.example.authentication.presentation.authenticationcheckingfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.authentication.databinding.AuthenticationCheckingLayoutBinding
import com.example.core.base.fragment.BaseFragment

class AuthenticationCheckingFragment :
    BaseFragment<AuthenticationCheckingLayoutBinding, AuthenticationCheckingFragmentViewModel>(
        AuthenticationCheckingFragmentViewModel::class
    ) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AuthenticationCheckingLayoutBinding {
        return AuthenticationCheckingLayoutBinding.inflate(inflater, container, false)
    }
}