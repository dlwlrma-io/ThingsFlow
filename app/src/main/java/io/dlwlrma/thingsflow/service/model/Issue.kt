package io.dlwlrma.thingsflow.service.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Issue(
    @SerializedName(value = "active_lock_reason")
    val activeLockReason: Any,

    val assignee: Any,

    val assignees: List<Any>,

    @SerializedName(value = "author_association")
    val authorAssociation: String,

    val body: String,

    @SerializedName(value = "closed_at")
    val closedAt: Any,

    val comments: Int,

    @SerializedName(value = "comments_url")
    val commentsUrl: String,

    @SerializedName(value = "created_at")
    val createdAt: String,

    @SerializedName(value = "events_url")
    val eventsUrl: String,

    @SerializedName(value = "html_url")
    val htmlUrl: String,

    val id: Int,

    val labels: List<Any>,

    @SerializedName(value = "labels_url")
    val labelsUrl: String,

    val locked: Boolean,

    val milestone: Any,

    @SerializedName(value = "node_id")
    val nodeId: String,

    val number: Int,

    @SerializedName(value = "performed_via_github_app")
    val performedViaGithubApp: Any,

    val reactions: Reactions,

    @SerializedName(value = "repository_url")
    val repositoryUrl: String,

    val state: String,

    @SerializedName(value = "state_reason")
    val stateReason: Any,

    @SerializedName(value = "timeline_url")
    val timelineUrl: String,

    val title: String,

    @SerializedName(value = "updated_at")

    val updatedAt: String,

    val url: String,

    val user: User
) : Serializable