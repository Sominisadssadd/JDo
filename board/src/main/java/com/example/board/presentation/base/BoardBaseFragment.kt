package com.example.board.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.board.databinding.BoardBaseFragmentBinding
import com.example.core.base.fragment.BaseFragment

class BoardBaseFragment : BaseFragment<BoardBaseFragmentBinding, BoardBaseFragmentViewModel>(
    BoardBaseFragmentViewModel::class,
    null
) {

    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): BoardBaseFragmentBinding {
        return BoardBaseFragmentBinding.inflate(inflater, container, false)
    }

    companion object{
        fun newInstance() = BoardBaseFragment()
    }
}