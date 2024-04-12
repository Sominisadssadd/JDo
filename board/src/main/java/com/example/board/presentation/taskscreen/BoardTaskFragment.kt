package com.example.board.presentation.taskscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.board.databinding.TaskBoardFragmentBinding
import com.example.core.base.fragment.BaseFragment
import com.example.database.models.board.Task
import com.example.response.TaskResponse

class BoardTaskFragment :
    BaseFragment<TaskBoardFragmentBinding, BoardTaskFragmentViewModel>(
        BoardTaskFragmentViewModel::class
    ) {
    override fun setUpViews() {
        binding.apply {
            setupFields(this)
        }
    }

    private fun setupFields(binding: TaskBoardFragmentBinding) {
        val task = arguments?.getSerializable(KEY_TASK) as TaskResponse
        binding.apply {
            Glide.with(requireContext())
                .load(task.assigned.image.imageUrl)
                .into(imageViewAssigned)
            textViewTitle.setText(task.title)
            textViewName.text = task.assigned.name
            textViewSerName.text = task.assigned.serName
            edTextDescription.setText(task.description)
            textViewDeadLine.text = "Дата сдачи: ${task.deadline}"

            statusSpinner.setSelection(task.Status.idStatus - POSITION_INCREASE)
            prioritySpinner.setSelection(task.Priority.idPriority - POSITION_INCREASE)

            buttonDeleteTask.setOnClickListener {
                viewModel.deleteTask(task.idTask)
            }
            buttonUpdateTask.setOnClickListener {
                val status = statusSpinner.selectedItemPosition + POSITION_INCREASE
                val priority = prioritySpinner.selectedItemPosition + POSITION_INCREASE
                val description = edTextDescription.text.toString()
                val title = textViewTitle.text.toString()

                task.Status.idStatus = status
                task.Priority.idPriority = priority
                task.description = description
                task.title = title

                val task = Task(
                    task.idTask,
                    task.idBoard,
                    task.title,
                    task.description,
                    task.assigned.userId.toInt(),
                    task.Status.idStatus,
                    task.deadline,
                    task.Priority.idPriority,
                    task.created
                )
                viewModel.updateTask(task)
            }
        }

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): TaskBoardFragmentBinding {
        return TaskBoardFragmentBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(task: TaskResponse): BoardTaskFragment {
            return BoardTaskFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_TASK, task)
                }
            }
        }

        private const val KEY_TASK = "task"
        private const val POSITION_INCREASE = 1
    }


}