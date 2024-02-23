package com.example.authentication.presentation.mainfrgment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.authentication.databinding.AuthenticationBaseLayoutBinding
import com.example.authentication.presentation.mainfrgment.state.AuthenticationScreenState
import com.example.core.base.BaseFragment

class AuthenticationBaseFragment :
    BaseFragment<AuthenticationBaseLayoutBinding, AuthenticationBaseFragmentViewModel>(
        AuthenticationBaseFragmentViewModel::class
    ) {

    val stateFragmentAdapter: AuthenticationBaseFragmentStateAdapter<List<AuthenticationScreenState>> by lazy {
        AuthenticationBaseFragmentStateAdapter(
            requireActivity(), listOf(
                AuthenticationScreenState.AuthScreenLogin,
                AuthenticationScreenState.AuthScreenRegister
            )
        )
    }

    override fun setUpViews() {
        binding.apply {
            viewPagerBaseFragment.adapter = stateFragmentAdapter
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AuthenticationBaseLayoutBinding {
        return AuthenticationBaseLayoutBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val b = AuthenticationBaseFragmentStateAdapter(
            requireActivity(), listOf(
                AuthenticationScreenState.AuthScreenLogin,
                AuthenticationScreenState.AuthScreenRegister
            )
        )
    }


}