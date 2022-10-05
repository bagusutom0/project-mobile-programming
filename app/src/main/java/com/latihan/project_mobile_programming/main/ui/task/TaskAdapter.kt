package com.latihan.project_mobile_programming.main.ui.task

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.core.domain.model.Task
import com.latihan.project_mobile_programming.databinding.ItemTaskBinding

class TaskAdapter(
    private val context: Context
): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTaskBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.apply {
                rvTask.isChecked = task.isChecked
                tvTaskTitle.text = task.title
                tvTaskDate.text = task.date
                tvTaskAuthor.text = context.getString(R.string.task_author, task.author)
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

}