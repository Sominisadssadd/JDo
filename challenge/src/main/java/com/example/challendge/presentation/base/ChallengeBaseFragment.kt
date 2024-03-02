package com.example.challendge.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.challendge.databinding.ChallengeBaseFragmentBinding
import com.example.core.base.BaseFragment

class ChallengeBaseFragment :
    BaseFragment<ChallengeBaseFragmentBinding, ChallengeBaseFragmentViewModel>(
        ChallengeBaseFragmentViewModel::class,
        null
    ) {
    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ChallengeBaseFragmentBinding {
        return ChallengeBaseFragmentBinding.inflate(inflater, container, false)
    }

    companion object{
        fun newInstance() = ChallengeBaseFragment()
    }
}