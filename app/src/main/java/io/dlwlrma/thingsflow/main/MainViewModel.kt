package io.dlwlrma.thingsflow.main

import androidx.lifecycle.MutableLiveData
import io.dlwlrma.thingsflow.base.ViewModel
import io.dlwlrma.thingsflow.main.adapter.IssueAdapter
import io.dlwlrma.thingsflow.service.GitHubService
import io.dlwlrma.thingsflow.service.model.Issue
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainViewModel : ViewModel {
    private val disposables: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private val gitHubService: GitHubService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create()
    }

    val title: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val items: MutableLiveData<List<Issue>> by lazy {
        MutableLiveData<List<Issue>>()
    }

    val showDetailPage: MutableLiveData<Issue> by lazy {
        MutableLiveData<Issue>()
    }

    val showWebPage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val observer = object : IssueAdapter.Observer {
        override fun onTextClick(item: Issue) {
            showDetailPage.value = item
        }

        override fun onImageClick() {
            showWebPage.value = "https://thingsflow.com/ko/home"
        }
    }

    init {
        val org = "google"
        val repo = "dagger"
        val disposable = gitHubService.getIssueList(org, repo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                title.value = "$org / $repo"
                items.value = result
            }

        disposables.add(disposable)
    }

    fun onTitleClick() {}
}