package com.example.authentication.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.authentication.databinding.AuthenticationRegisterLayoutBinding
import com.example.authentication.presentation.utils.consts.REGISTER_SCREEN
import com.example.authentication.presentation.utils.typers.FragmentType
import com.example.core.base.BaseFragment

class AuthenticationRegisterFragment :
    BaseFragment<AuthenticationRegisterLayoutBinding, AuthenticationRegisterFragmentViewModel>(
        AuthenticationRegisterFragmentViewModel::class
    ) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setUpViews() {
        TODO("Not yet implemented")
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AuthenticationRegisterLayoutBinding {
        return AuthenticationRegisterLayoutBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    fun newInstance() = AuthenticationRegisterFragment()

}