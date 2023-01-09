package io.dlwlrma.thingsflow.ui

import io.dlwlrma.thingsflow.R
import io.dlwlrma.thingsflow.base.BaseActivity
import io.dlwlrma.thingsflow.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutRes: Int = R.layout.activity_main
    override var viewModel: MainViewModel = MainViewModel()
}