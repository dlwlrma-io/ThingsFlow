package io.dlwlrma.thingsflow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.dlwlrma.thingsflow.databinding.IssueItemBinding
import io.dlwlrma.thingsflow.service.model.Issue

class IssueAdapter : RecyclerView.Adapter<IssueAdapter.IssueViewHolder>() {
    var items = emptyList<Issue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = IssueItemBinding.inflate(inflater, parent, false)
        return IssueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class IssueViewHolder(
        private val binding: IssueItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Issue) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}