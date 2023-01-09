package io.dlwlrma.thingsflow.detail

import android.os.Bundle
import io.dlwlrma.thingsflow.R
import io.dlwlrma.thingsflow.base.BaseActivity
import io.dlwlrma.thingsflow.databinding.ActivityDetailBinding
import io.dlwlrma.thingsflow.service.model.Issue


class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val layoutRes: Int = R.layout.activity_detail
    override lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val issue = intent.getSerializableExtra("EXTRA_ISSUE") as Issue?
        viewModel = DetailViewModel(issue)

        super.onCreate(savedInstanceState)
    }

    companion object {
        const val EXTRA_ISSUE = "EXTRA_ISSUE"
    }
}