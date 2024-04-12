package com.example.board.presentation.taskscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.board.databinding.TaskAddFragmentBinding
import com.example.core.base.dialog.snackBarMessage
import com.example.core.base.fragment.BaseFragment
import com.example.core.extension.getCurrentBoardId
import com.example.core.extension.getCurrentUserId
import com.example.core.extension.getCurrentUserLogin
import com.example.database.models.board.Task
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class BoardTaskAddFragment :
    BaseFragment<TaskAddFragmentBinding, BoardAddFragmentViewModel>(BoardAddFragmentViewModel::class) {

    var selectedDeadline = EMPTY_FIELD
    override fun setUpViews() {
        binding.apply {

            //Если новый юзер зарегается то сразу полетит, т.к id юзера получается в профиле, потом
            //исправь
            binding.buttonAddTask.setOnClickListener {
                addTask()
            }

            calendarDeadLine.setOnDateChangeListener { view, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)


                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                selectedDeadline = sdf.format(selectedDate.time)
            }
        }
    }

    private fun addTask() {
        val title = binding.textViewTitle.text.toString()
        val description = binding.edTextDescription.text.toString()
        val idStatus = binding.statusSpinner.selectedItemPosition
        val idPriority = binding.prioritySpinner.selectedItemPosition


        val currentDate = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = sdf.format(currentDate.time)


        val task = Task(
            DEFAULT_AI_ID,
            getCurrentBoardId(requireContext()),
            title,
            description,
            getCurrentUserId(requireContext()),
            idStatus,
            selectedDeadline,
            idPriority,
            formattedDate.toString()
        )
        viewModel.createNewTask(task)
    }


    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): TaskAddFragmentBinding {
        return TaskAddFragmentBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observableEvents()
    }

    private fun observableEvents() {
        viewModel.apply {
            success.observe(viewLifecycleOwner) {
                snackBarMessage(it.toString())
            }
            error.observe(viewLifecycleOwner) {
                snackBarMessage(it)
            }
        }
    }

    companion object {
        fun newInstance(): BoardTaskAddFragment {
            return BoardTaskAddFragment()
        }

        private const val DEFAULT_AI_ID = 0
        private const val EMPTY_FIELD = ""
    }
}