package com.example.message.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.core.base.fragment.BaseFragment
import com.example.message.databinding.MessageBaseFragmentBinding

class MessageBaseFragment : BaseFragment<MessageBaseFragmentBinding, MessageBaseFragmentViewModel>(
    MessageBaseFragmentViewModel::class,
    null
) {
    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MessageBaseFragmentBinding {
        return MessageBaseFragmentBinding.inflate(inflater, container, false)
    }

    companion object{
        fun newInstance() = MessageBaseFragment()
    }
}