package io.dlwlrma.thingsflow.detail

import androidx.lifecycle.MutableLiveData
import io.dlwlrma.thingsflow.base.ViewModel
import io.dlwlrma.thingsflow.service.model.Issue

class DetailViewModel(issue: Issue?) : ViewModel {
    val avatarUrl: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val contents: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        issue?.run {
            avatarUrl.value = user.avatarUrl
            name.value = user.login
            contents.value = body
        }
    }
}