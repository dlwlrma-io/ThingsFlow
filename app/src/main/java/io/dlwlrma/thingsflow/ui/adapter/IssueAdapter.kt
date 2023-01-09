package io.dlwlrma.thingsflow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import io.dlwlrma.thingsflow.databinding.ImageItemBinding
import io.dlwlrma.thingsflow.databinding.IssueItemBinding
import io.dlwlrma.thingsflow.service.model.Issue

class IssueAdapter : RecyclerView.Adapter<ViewHolder>() {
    companion object {
        private const val VIEW_TYPE_TEXT = 0
        private const val VIEW_TYPE_IMAGE = 1
    }

    var items = emptyList<Issue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == VIEW_TYPE_IMAGE) {
            val binding = ImageItemBinding.inflate(inflater, parent, false)
            ImageViewHolder(binding)
        } else {
            val binding = IssueItemBinding.inflate(inflater, parent, false)
            IssueViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ImageViewHolder) {
            holder.bind("https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png")
        } else if (holder is IssueViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = if (position == 5) {
        VIEW_TYPE_IMAGE
    } else {
        VIEW_TYPE_TEXT
    }

    inner class IssueViewHolder(private val binding: IssueItemBinding) : ViewHolder(binding.root) {
        fun bind(item: Issue) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    inner class ImageViewHolder(private val binding: ImageItemBinding) : ViewHolder(binding.root) {
        fun bind(imageUrl: String) {
            binding.imageUrl = imageUrl
            binding.executePendingBindings()
        }
    }
}