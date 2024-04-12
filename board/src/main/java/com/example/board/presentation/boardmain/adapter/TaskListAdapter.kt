package com.example.board.presentation.boardmain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.board.R
import com.example.board.databinding.TaskItemBinding
import com.example.response.TaskResponse

class TaskListAdapter : ListAdapter<TaskResponse, TaskListAdapter.TaskViewHolder>(TaskDiffUtils()) {


    var clickListener: ((TaskResponse) -> Unit)? = null

    inner class TaskViewHolder(val binding: TaskItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TaskItemBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        val context = holder.itemView.context
        with(holder.binding) {
            val cardBackground = when (item.Priority.idPriority) {
                PRIORITY_LOW -> {
                    context.getColor(R.color.color_priority_low)
                }

                PRIORITY_MID -> {
                    context.getColor(R.color.color_priority_mid)
                }

                else -> {
                    context.getColor(R.color.color_priority_high)
                }
            }
            cardTask.setBackgroundColor(cardBackground)

            textViewTitle.text = item.title
            textViewStatus.text = "Статус: ${item.Status.status}"
            textViewPriority.text = "Приоритет: ${item.Priority.priority}"
            Glide.with(holder.binding.root)
                .load(item.assigned.image.imageUrl)
                .into(imageViewAssigned)
            textViewAssigned.text = "${item.assigned.name} ${item.assigned.serName}"
            holder.itemView.setOnClickListener {
                clickListener?.invoke(item)
            }
        }
    }

    companion object {
        private const val PRIORITY_LOW = 1
        private const val PRIORITY_MID = 2
        private const val PRIORITY_HIGH = 3
    }


}