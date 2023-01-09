package io.dlwlrma.thingsflow

import io.dlwlrma.thingsflow.model.Issue
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/repos/{org}/{repo}/issues")
    fun getIssueList(@Path("org") org: String, @Path("repo") repo: String): Single<List<Issue>>
}