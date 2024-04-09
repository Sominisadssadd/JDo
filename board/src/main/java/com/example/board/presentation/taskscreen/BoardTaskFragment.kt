package com.example.board.presentation.taskscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.board.databinding.TaskBoardFragmentBinding
import com.example.core.base.fragment.BaseFragment

class BoardTaskFragment(context: Context) :
    BaseFragment<TaskBoardFragmentBinding, BoardTaskFragmentViewModel>(
        BoardTaskFragmentViewModel::class,
        BoardTaskFragmentViewModelFactory(context)
    ) {
    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): TaskBoardFragmentBinding {
        return TaskBoardFragmentBinding.inflate(inflater, container, false)
    }

    companion object{
        fun newInstance(context: Context) : BoardTaskFragment{
            return BoardTaskFragment(context)
        }
    }


}