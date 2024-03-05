package com.example.authentication.presentation.mainfrgment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.authentication.presentation.mainfrgment.state.AuthenticationScreenState
import com.example.authentication.presentation.login.AuthenticationLoginFragment
import com.example.authentication.presentation.register.AuthenticationRegisterFragment
import com.example.authentication.presentation.utils.consts.LOGIN_SCREEN
import com.example.authentication.presentation.utils.consts.REGISTER_SCREEN

class AuthenticationBaseFragmentStateAdapter<out T : List<AuthenticationScreenState>>
    (
    val listener: () -> Unit,
    activity: FragmentActivity,
    val listOfFragment: T
) : FragmentStateAdapter(activity) {
    override fun getItemCount() = PAGE_COUNT
    override fun createFragment(position: Int): Fragment {
        val currentFragment = listOfFragment[position]
        return when (currentFragment.getFragmentType()) {
            LOGIN_SCREEN -> {
                val fragment = currentFragment.createFragment() as AuthenticationLoginFragment
                fragment.apply {
                    loginClickListener = listener
                }
                fragment
            }
            REGISTER_SCREEN -> {
                val fragment = currentFragment.createFragment() as AuthenticationRegisterFragment
                fragment.registerClickListener = listener
                fragment
            }

            else -> {
                throw RuntimeException("Unknown fragment type")
            }
        }
    }

    companion object {
        private const val PAGE_COUNT = 2
    }
}
