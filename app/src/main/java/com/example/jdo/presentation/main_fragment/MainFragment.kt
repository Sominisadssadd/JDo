package com.example.jdo.presentation.main_fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.board.presentation.base.BoardBaseFragment
import com.example.challendge.presentation.base.ChallengeBaseFragment
import com.example.core.base.BaseFragment
import com.example.jdo.R
import com.example.jdo.databinding.MainFragmentBinding
import com.example.jdo.presentation.state.MainScreenState
import com.example.message.presentation.base.MessageBaseFragment
import com.example.profile.presentation.base.ProfileBaseFragment

class MainFragment :
    BaseFragment<MainFragmentBinding, MainFragmentViewModel>(MainFragmentViewModel::class) {
    override fun setUpViews() {
        setupNavigation()
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainFragmentBinding {
        return MainFragmentBinding.inflate(inflater, container, false)
    }

    private fun setupNavigation() {
        binding.mainBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                MainScreenState.BoardScreen().boardId -> {
                    val fragmentBoard = BoardBaseFragment.newInstance()
                    startDestination(fragmentBoard)
                    true
                }

                MainScreenState.MessageScreen().messagedId -> {
                    val fragmentMessage = MessageBaseFragment.newInstance()
                    startDestination(fragmentMessage)
                    true
                }

                MainScreenState.ChallengeScreen().challengeId -> {
                    val fragmentChallenge = ChallengeBaseFragment.newInstance()
                    startDestination(fragmentChallenge)
                    true
                }

                MainScreenState.ProfileScreen().profileId -> {
                    val fragmentProfile = ProfileBaseFragment.newInstance()
                    startDestination(fragmentProfile)
                    true
                }

                else -> {
                    throw RuntimeException("Unknown bottomNav Item")
                }
            }
        }
    }

    @SuppressLint("CommitTransaction")
    private fun startDestination(fragment: Fragment) {
        val containerId = binding.mainFragmentContainer.id
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}