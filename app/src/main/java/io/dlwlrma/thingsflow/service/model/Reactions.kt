package io.dlwlrma.thingsflow.service.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Reactions(
    @SerializedName(value = "+1")
    val positive: Int,

    @SerializedName(value = "-1")
    val negative: Int,

    val confused: Int,

    val eyes: Int,

    val heart: Int,

    val hooray: Int,

    val laugh: Int,

    val rocket: Int,

    @SerializedName(value = "total_count")
    val totalCount: Int,

    val url: String
) : Serializable