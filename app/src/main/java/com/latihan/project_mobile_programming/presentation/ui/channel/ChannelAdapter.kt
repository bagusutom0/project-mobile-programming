package com.latihan.project_mobile_programming.presentation.ui.channel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.core.domain.model.Channel
import com.latihan.project_mobile_programming.databinding.ItemChannelBinding

class ChannelAdapter(
    private val context: Context
) : RecyclerView.Adapter<ChannelAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemChannelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(channel: Channel) {
            binding.apply {
                tvTitleTaskList.text = channel.channel
                tvChannelAuthor.text = context.getString(R.string.task_author, channel.author)
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Channel>() {
        override fun areItemsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem.channel == newItem.channel
        }

        override fun areContentsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChannelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(differ.currentList[position].channel)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}