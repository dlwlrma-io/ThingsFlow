package io.dlwlrma.thingsflow.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import io.dlwlrma.thingsflow.R
import io.dlwlrma.thingsflow.base.BaseActivity
import io.dlwlrma.thingsflow.databinding.ActivityMainBinding
import io.dlwlrma.thingsflow.detail.DetailActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutRes: Int = R.layout.activity_main
    override var viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.showDetailPage.observe(this) { issue ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_ISSUE, issue)
            }
            startActivity(intent)
        }

        viewModel.showWebPage.observe(this) { url ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}