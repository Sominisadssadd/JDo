package com.example.authentication.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.authentication.databinding.AuthenticationLoginLayoutBinding
import com.example.authentication.presentation.utils.consts.LOGIN_SCREEN
import com.example.authentication.presentation.utils.typers.FragmentType
import com.example.core.base.BaseFragment

class AuthenticationLoginFragment :
    BaseFragment<AuthenticationLoginLayoutBinding, AuthenticationLoginFragmentViewModel>(
        AuthenticationLoginFragmentViewModel::class
    ) {
    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AuthenticationLoginLayoutBinding {
        return AuthenticationLoginLayoutBinding.inflate(inflater, container, false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    fun newInstance() = AuthenticationLoginFragment()
}