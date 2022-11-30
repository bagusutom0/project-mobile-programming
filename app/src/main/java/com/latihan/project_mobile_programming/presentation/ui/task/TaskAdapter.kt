package com.latihan.project_mobile_programming.presentation.ui.task

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.core.domain.model.Todo
import com.latihan.project_mobile_programming.databinding.ItemTaskBinding

class TaskAdapter(
    private val context: Context
): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTaskBinding):
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(todo: Todo) {
            binding.apply {
                rbTask.isChecked = todo.isChecked
                rbTask.setOnClickListener{
                    onRBClickListener?.invoke(todo.todo, todo.isChecked)
                }
                if (rbTask.isChecked) {
                    cvTask.background.setTint(R.color.primary_main)
                }

                tvTaskTitle.text = todo.todo
                tvTaskDate.text = todo.deadline
                tvTaskAuthor.text = context.getString(R.string.task_author, todo.author)
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.todo == newItem.todo
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
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

    private var onRBClickListener: ((String, Boolean) -> Unit)? = null

    fun setOnRBClickListener(listener: (String, Boolean) -> Unit) {
        onRBClickListener = listener
    }

}