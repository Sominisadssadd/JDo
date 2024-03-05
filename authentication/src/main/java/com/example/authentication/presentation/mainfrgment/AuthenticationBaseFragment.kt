package com.example.authentication.presentation.mainfrgment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.authentication.R
import com.example.authentication.databinding.AuthenticationBaseLayoutBinding
import com.example.authentication.presentation.mainfrgment.state.AuthenticationScreenState
import com.example.authentication.presentation.utils.sharedPreferences.SharedPreferencesAuthentication
import com.example.core.base.fragment.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class AuthenticationBaseFragment :
    BaseFragment<AuthenticationBaseLayoutBinding, AuthenticationBaseFragmentViewModel>(
        AuthenticationBaseFragmentViewModel::class
    ) {

     lateinit var activityListener: () -> Unit

    val stateFragmentAdapter: AuthenticationBaseFragmentStateAdapter<List<AuthenticationScreenState>> by lazy {
        AuthenticationBaseFragmentStateAdapter(
            activityListener,
            requireActivity(), listOf(
                AuthenticationScreenState.AuthScreenLogin,
                AuthenticationScreenState.AuthScreenRegister
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setUpViews() {
        binding.apply {
            viewPagerBaseFragment.adapter = stateFragmentAdapter
            TabLayoutMediator(tabLayoutBaseFragment, viewPagerBaseFragment) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = getString(R.string.buttonLogin)
                        tab.setIcon(R.drawable.authentication_login_icon)
                    }

                    1 -> {
                        tab.text = getString(R.string.buttonRegister)
                        tab.setIcon(R.drawable.authentication_register_icon)
                    }
                }
            }.attach()
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AuthenticationBaseLayoutBinding {
        return AuthenticationBaseLayoutBinding.inflate(inflater, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    companion object {
        fun newInstance() = AuthenticationBaseFragment()

    }
}