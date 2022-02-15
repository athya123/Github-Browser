package com.tare.githubbrowser.pojo.entities


import com.google.gson.annotations.SerializedName

data class PullRequest(
    @SerializedName("diff_url")
    var diffUrl: String = "",
    @SerializedName("html_url")
    var htmlUrl: String = "",
    @SerializedName("merged_at")
    var mergedAt: Any? = null,
    @SerializedName("patch_url")
    var patchUrl: String = "",
    @SerializedName("url")
    var url: String = ""
)