package io.dlwlrma.thingsflow.service

import io.dlwlrma.thingsflow.service.model.Issue
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/repos/{org}/{repo}/issues")
    fun getIssueList(@Path("org") org: String, @Path("repo") repo: String): Single<List<Issue>>
}