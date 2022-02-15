package com.tare.githubbrowser.pojo.response


import com.google.gson.annotations.SerializedName
import com.tare.githubbrowser.pojo.entities.License
import com.tare.githubbrowser.pojo.entities.Organization
import com.tare.githubbrowser.pojo.entities.Owner

data class ResponseGetRepo(
    @SerializedName("allow_forking")
    var allowForking: Boolean = false,
    @SerializedName("archive_url")
    var archiveUrl: String = "",
    @SerializedName("archived")
    var archived: Boolean = false,
    @SerializedName("assignees_url")
    var assigneesUrl: String = "",
    @SerializedName("blobs_url")
    var blobsUrl: String = "",
    @SerializedName("branches_url")
    var branchesUrl: String = "",
    @SerializedName("clone_url")
    var cloneUrl: String = "",
    @SerializedName("collaborators_url")
    var collaboratorsUrl: String = "",
    @SerializedName("comments_url")
    var commentsUrl: String = "",
    @SerializedName("commits_url")
    var commitsUrl: String = "",
    @SerializedName("compare_url")
    var compareUrl: String = "",
    @SerializedName("contents_url")
    var contentsUrl: String = "",
    @SerializedName("contributors_url")
    var contributorsUrl: String = "",
    @SerializedName("created_at")
    var createdAt: String = "",
    @SerializedName("default_branch")
    var defaultBranch: String = "",
    @SerializedName("deployments_url")
    var deploymentsUrl: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("disabled")
    var disabled: Boolean = false,
    @SerializedName("downloads_url")
    var downloadsUrl: String = "",
    @SerializedName("events_url")
    var eventsUrl: String = "",
    @SerializedName("fork")
    var fork: Boolean = false,
    @SerializedName("forks")
    var forks: Int = 0,
    @SerializedName("forks_count")
    var forksCount: Int = 0,
    @SerializedName("forks_url")
    var forksUrl: String = "",
    @SerializedName("full_name")
    var fullName: String = "",
    @SerializedName("git_commits_url")
    var gitCommitsUrl: String = "",
    @SerializedName("git_refs_url")
    var gitRefsUrl: String = "",
    @SerializedName("git_tags_url")
    var gitTagsUrl: String = "",
    @SerializedName("git_url")
    var gitUrl: String = "",
    @SerializedName("has_downloads")
    var hasDownloads: Boolean = false,
    @SerializedName("has_issues")
    var hasIssues: Boolean = false,
    @SerializedName("has_pages")
    var hasPages: Boolean = false,
    @SerializedName("has_projects")
    var hasProjects: Boolean = false,
    @SerializedName("has_wiki")
    var hasWiki: Boolean = false,
    @SerializedName("homepage")
    var homepage: String = "",
    @SerializedName("hooks_url")
    var hooksUrl: String = "",
    @SerializedName("html_url")
    var htmlUrl: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("is_template")
    var isTemplate: Boolean = false,
    @SerializedName("issue_comment_url")
    var issueCommentUrl: String = "",
    @SerializedName("issue_events_url")
    var issueEventsUrl: String = "",
    @SerializedName("issues_url")
    var issuesUrl: String = "",
    @SerializedName("keys_url")
    var keysUrl: String = "",
    @SerializedName("labels_url")
    var labelsUrl: String = "",
    @SerializedName("language")
    var language: String = "",
    @SerializedName("languages_url")
    var languagesUrl: String = "",
    @SerializedName("license")
    var license: License = License(),
    @SerializedName("merges_url")
    var mergesUrl: String = "",
    @SerializedName("milestones_url")
    var milestonesUrl: String = "",
    @SerializedName("mirror_url")
    var mirrorUrl: Any? = null,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("network_count")
    var networkCount: Int = 0,
    @SerializedName("node_id")
    var nodeId: String = "",
    @SerializedName("notifications_url")
    var notificationsUrl: String = "",
    @SerializedName("open_issues")
    var openIssues: Int = 0,
    @SerializedName("open_issues_count")
    var openIssuesCount: Int = 0,
    @SerializedName("organization")
    var organization: Organization = Organization(),
    @SerializedName("owner")
    var owner: Owner = Owner(),
    @SerializedName("private")
    var `private`: Boolean = false,
    @SerializedName("pulls_url")
    var pullsUrl: String = "",
    @SerializedName("pushed_at")
    var pushedAt: String = "",
    @SerializedName("releases_url")
    var releasesUrl: String = "",
    @SerializedName("size")
    var size: Int = 0,
    @SerializedName("ssh_url")
    var sshUrl: String = "",
    @SerializedName("stargazers_count")
    var stargazersCount: Int = 0,
    @SerializedName("stargazers_url")
    var stargazersUrl: String = "",
    @SerializedName("statuses_url")
    var statusesUrl: String = "",
    @SerializedName("subscribers_count")
    var subscribersCount: Int = 0,
    @SerializedName("subscribers_url")
    var subscribersUrl: String = "",
    @SerializedName("subscription_url")
    var subscriptionUrl: String = "",
    @SerializedName("svn_url")
    var svnUrl: String = "",
    @SerializedName("tags_url")
    var tagsUrl: String = "",
    @SerializedName("teams_url")
    var teamsUrl: String = "",
    @SerializedName("temp_clone_token")
    var tempCloneToken: Any? = null,
    @SerializedName("topics")
    var topics: List<String> = listOf(),
    @SerializedName("trees_url")
    var treesUrl: String = "",
    @SerializedName("updated_at")
    var updatedAt: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("visibility")
    var visibility: String = "",
    @SerializedName("watchers")
    var watchers: Int = 0,
    @SerializedName("watchers_count")
    var watchersCount: Int = 0
)