package io.dlwlrma.thingsflow.main.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.dlwlrma.thingsflow.service.model.Issue

@BindingAdapter("app:items")
fun bindItems(view: RecyclerView, items: List<Issue>?) {
    val adapter = view.adapter as? IssueAdapter
        ?: IssueAdapter().apply { view.adapter = this }

    items?.let {
        adapter.items = it
        adapter.notifyDataSetChanged()
    }
}

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}

@BindingAdapter("observer")
fun bindObserver(view: RecyclerView, observer: IssueAdapter.Observer) {
    val adapter = view.adapter as? IssueAdapter
        ?: IssueAdapter().apply { view.adapter = this }

    adapter.observer = observer
}