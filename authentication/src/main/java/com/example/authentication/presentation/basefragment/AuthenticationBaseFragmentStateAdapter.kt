package com.example.authentication.presentation.basefragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.authentication.presentation.login.AuthenticationLoginFragment
import com.example.authentication.presentation.register.AuthenticationRegisterFragment
import com.example.authentication.presentation.utils.consts.LOGIN_SCREEN
import com.example.authentication.presentation.utils.consts.REGISTER_SCREEN
import com.example.authentication.presentation.utils.typers.FragmentType

class AuthenticationBaseFragmentStateAdapter<out T : List<FragmentType>>
    (
    activity: FragmentActivity,
    val listOfFragment: T
) : FragmentStateAdapter(activity) {

    override fun getItemCount() = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        val currentFragment = listOfFragment[position].getFragmentType()
        return when (currentFragment) {
            LOGIN_SCREEN -> {
                AuthenticationLoginFragment()
            }

            REGISTER_SCREEN -> {
                AuthenticationRegisterFragment()
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
