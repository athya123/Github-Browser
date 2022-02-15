package com.tare.githubbrowser.pojo.entities


import com.google.gson.annotations.SerializedName

data class ResponseGetOpenIssuesItem(
    @SerializedName("active_lock_reason")
    var activeLockReason: String? = null,
    @SerializedName("assignee")
    var assignee: Assignee? = null,
    @SerializedName("assignees")
    var assignees: List<Assignee> = listOf(),
    @SerializedName("author_association")
    var authorAssociation: String = "",
    @SerializedName("body")
    var body: String = "",
    @SerializedName("closed_at")
    var closedAt: Any? = null,
    @SerializedName("comments")
    var comments: Int = 0,
    @SerializedName("comments_url")
    var commentsUrl: String = "",
    @SerializedName("created_at")
    var createdAt: String = "",
    @SerializedName("draft")
    var draft: Boolean = false,
    @SerializedName("events_url")
    var eventsUrl: String = "",
    @SerializedName("html_url")
    var htmlUrl: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("labels")
    var labels: List<Label> = listOf(),
    @SerializedName("labels_url")
    var labelsUrl: String = "",
    @SerializedName("locked")
    var locked: Boolean = false,
    @SerializedName("milestone")
    var milestone: Milestone? = null,
    @SerializedName("node_id")
    var nodeId: String = "",
    @SerializedName("number")
    var number: Int = 0,
    @SerializedName("performed_via_github_app")
    var performedViaGithubApp: Any? = null,
    @SerializedName("pull_request")
    var pullRequest: PullRequest = PullRequest(),
    @SerializedName("reactions")
    var reactions: Reactions = Reactions(),
    @SerializedName("repository_url")
    var repositoryUrl: String = "",
    @SerializedName("state")
    var state: String = "",
    @SerializedName("timeline_url")
    var timelineUrl: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("updated_at")
    var updatedAt: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("user")
    var user: User = User()
)