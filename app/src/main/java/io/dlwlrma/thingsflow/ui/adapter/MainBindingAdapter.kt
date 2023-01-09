package io.dlwlrma.thingsflow

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.dlwlrma.thingsflow.service.model.Issue
import io.dlwlrma.thingsflow.ui.adapter.IssueAdapter

@BindingAdapter("app:items")
fun bindItems(view: RecyclerView, items: List<Issue>?) {
    val adapter = view.adapter as? IssueAdapter
        ?: IssueAdapter().apply { view.adapter = this }

    items?.let {
        adapter.items = it
        adapter.notifyDataSetChanged()
    }
}