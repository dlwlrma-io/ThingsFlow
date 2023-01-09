package io.dlwlrma.thingsflow

import io.dlwlrma.thingsflow.base.BaseActivity
import io.dlwlrma.thingsflow.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutRes: Int = R.layout.activity_main
    override var viewModel: MainViewModel = MainViewModel()
}