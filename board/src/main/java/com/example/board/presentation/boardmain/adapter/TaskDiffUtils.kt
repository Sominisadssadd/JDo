package com.example.board.presentation.boardmain.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.response.TaskResponse

class TaskDiffUtils : DiffUtil.ItemCallback<TaskResponse>() {
    override fun areItemsTheSame(oldItem: TaskResponse, newItem: TaskResponse) =
        oldItem.idTask == newItem.idTask

    override fun areContentsTheSame(oldItem: TaskResponse, newItem: TaskResponse) =
        oldItem == newItem


}