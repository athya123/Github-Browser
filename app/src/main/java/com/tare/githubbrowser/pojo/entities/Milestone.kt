package com.tare.githubbrowser.pojo.entities


import com.google.gson.annotations.SerializedName

data class Milestone(
    @SerializedName("closed_at")
    var closedAt: Any? = null,
    @SerializedName("closed_issues")
    var closedIssues: Int = 0,
    @SerializedName("created_at")
    var createdAt: String = "",
    @SerializedName("creator")
    var creator: Creator = Creator(),
    @SerializedName("description")
    var description: String = "",
    @SerializedName("due_on")
    var dueOn: Any? = null,
    @SerializedName("html_url")
    var htmlUrl: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("labels_url")
    var labelsUrl: String = "",
    @SerializedName("node_id")
    var nodeId: String = "",
    @SerializedName("number")
    var number: Int = 0,
    @SerializedName("open_issues")
    var openIssues: Int = 0,
    @SerializedName("state")
    var state: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("updated_at")
    var updatedAt: String = "",
    @SerializedName("url")
    var url: String = ""
)