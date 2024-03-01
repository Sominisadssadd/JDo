package com.example.authentication.presentation.mainfrgment.state

import androidx.fragment.app.Fragment
import com.example.authentication.presentation.login.AuthenticationLoginFragment
import com.example.authentication.presentation.register.AuthenticationRegisterFragment
import com.example.authentication.presentation.utils.consts.LOGIN_SCREEN
import com.example.authentication.presentation.utils.consts.REGISTER_SCREEN
import com.example.authentication.presentation.utils.typers.FragmentType

sealed class AuthenticationScreenState() : FragmentType {

    abstract fun createFragment(): Fragment

    data object AuthScreenLogin : AuthenticationScreenState() {
        override fun createFragment() = AuthenticationLoginFragment().newInstance()

        override fun getFragmentType() = LOGIN_SCREEN
    }

    data object AuthScreenRegister : AuthenticationScreenState() {
        override fun createFragment() = AuthenticationRegisterFragment().newInstance()

        override fun getFragmentType() = REGISTER_SCREEN
    }

}