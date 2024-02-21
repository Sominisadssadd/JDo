package com.example.authentication.presentation.basefragment.state

import androidx.fragment.app.Fragment
import com.example.authentication.presentation.login.AuthenticationLoginFragment
import com.example.authentication.presentation.register.AuthenticationRegisterFragment

sealed class AuthenticationScreenState {

    abstract fun createFragment(): Fragment

    data object AuthScreenLogin : AuthenticationScreenState() {
        override fun createFragment() = AuthenticationLoginFragment()
    }

    data object AuthScreenRegister : AuthenticationScreenState() {
        override fun createFragment() = AuthenticationRegisterFragment()
    }

}