package io.dlwlrma.thingsflow.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.dlwlrma.thingsflow.BR

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract var viewModel: VM

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.run {
            this.lifecycleOwner = this@BaseActivity
            this.setVariable(BR.viewModel, viewModel)
        }
    }
}