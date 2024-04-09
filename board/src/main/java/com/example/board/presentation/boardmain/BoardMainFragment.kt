package com.example.board.presentation.boardmain

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.board.databinding.MainBoardFragmentBinding
import com.example.board.presentation.taskscreen.BoardTaskFragment
import com.example.core.base.fragment.BaseFragment

class BoardMainFragment(context: Context) :
    BaseFragment<MainBoardFragmentBinding, BoardMainFragmentViewModel>(
        BoardMainFragmentViewModel::class,
        BoardMainFragmentViewModelFactory(context)
    ) {

    var callbackFragment: ((Fragment) -> Unit)? = null
    override fun setUpViews() {
        binding.apply {
            buttonToTaskScreen.setOnClickListener {
                val fragment = BoardTaskFragment.newInstance(requireContext())
                callbackFragment?.invoke(fragment)
            }
        }
    }


    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainBoardFragmentBinding {
        return MainBoardFragmentBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(context: Context): BoardMainFragment {
            return BoardMainFragment(context)
        }
    }

}