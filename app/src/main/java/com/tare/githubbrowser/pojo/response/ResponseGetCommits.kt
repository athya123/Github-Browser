package com.tare.githubbrowser.pojo.response


import com.google.gson.annotations.SerializedName

class ResponseGetCommits : ArrayList<ResponseGetCommits.ResponseGetCommitsItems>(){
    data class ResponseGetCommitsItems(
        @SerializedName("author")
        var author: Author = Author(),
        @SerializedName("comments_url")
        var commentsUrl: String = "",
        @SerializedName("commit")
        var commit: Commit = Commit(),
        @SerializedName("committer")
        var committer: Committer = Committer(),
        @SerializedName("html_url")
        var htmlUrl: String = "",
        @SerializedName("node_id")
        var nodeId: String = "",
        @SerializedName("parents")
        var parents: List<Parent> = listOf(),
        @SerializedName("sha")
        var sha: String = "",
        @SerializedName("url")
        var url: String = ""
    ) {
        data class Author(
            @SerializedName("avatar_url")
            var avatarUrl: String = "",
            @SerializedName("events_url")
            var eventsUrl: String = "",
            @SerializedName("followers_url")
            var followersUrl: String = "",
            @SerializedName("following_url")
            var followingUrl: String = "",
            @SerializedName("gists_url")
            var gistsUrl: String = "",
            @SerializedName("gravatar_id")
            var gravatarId: String = "",
            @SerializedName("html_url")
            var htmlUrl: String = "",
            @SerializedName("id")
            var id: Int = 0,
            @SerializedName("login")
            var login: String = "",
            @SerializedName("node_id")
            var nodeId: String = "",
            @SerializedName("organizations_url")
            var organizationsUrl: String = "",
            @SerializedName("received_events_url")
            var receivedEventsUrl: String = "",
            @SerializedName("repos_url")
            var reposUrl: String = "",
            @SerializedName("site_admin")
            var siteAdmin: Boolean = false,
            @SerializedName("starred_url")
            var starredUrl: String = "",
            @SerializedName("subscriptions_url")
            var subscriptionsUrl: String = "",
            @SerializedName("type")
            var type: String = "",
            @SerializedName("url")
            var url: String = ""
        )
    
        data class Commit(
            @SerializedName("author")
            var author: Author = Author(),
            @SerializedName("comment_count")
            var commentCount: Int = 0,
            @SerializedName("committer")
            var committer: Committer = Committer(),
            @SerializedName("message")
            var message: String = "",
            @SerializedName("tree")
            var tree: Tree = Tree(),
            @SerializedName("url")
            var url: String = "",
            @SerializedName("verification")
            var verification: Verification = Verification()
        ) {
            data class Author(
                @SerializedName("date")
                var date: String = "",
                @SerializedName("email")
                var email: String = "",
                @SerializedName("name")
                var name: String = ""
            )
    
            data class Committer(
                @SerializedName("date")
                var date: String = "",
                @SerializedName("email")
                var email: String = "",
                @SerializedName("name")
                var name: String = ""
            )
    
            data class Tree(
                @SerializedName("sha")
                var sha: String = "",
                @SerializedName("url")
                var url: String = ""
            )
    
            data class Verification(
                @SerializedName("payload")
                var payload: String = "",
                @SerializedName("reason")
                var reason: String = "",
                @SerializedName("signature")
                var signature: String = "",
                @SerializedName("verified")
                var verified: Boolean = false
            )
        }
    
        data class Committer(
            @SerializedName("avatar_url")
            var avatarUrl: String = "",
            @SerializedName("events_url")
            var eventsUrl: String = "",
            @SerializedName("followers_url")
            var followersUrl: String = "",
            @SerializedName("following_url")
            var followingUrl: String = "",
            @SerializedName("gists_url")
            var gistsUrl: String = "",
            @SerializedName("gravatar_id")
            var gravatarId: String = "",
            @SerializedName("html_url")
            var htmlUrl: String = "",
            @SerializedName("id")
            var id: Int = 0,
            @SerializedName("login")
            var login: String = "",
            @SerializedName("node_id")
            var nodeId: String = "",
            @SerializedName("organizations_url")
            var organizationsUrl: String = "",
            @SerializedName("received_events_url")
            var receivedEventsUrl: String = "",
            @SerializedName("repos_url")
            var reposUrl: String = "",
            @SerializedName("site_admin")
            var siteAdmin: Boolean = false,
            @SerializedName("starred_url")
            var starredUrl: String = "",
            @SerializedName("subscriptions_url")
            var subscriptionsUrl: String = "",
            @SerializedName("type")
            var type: String = "",
            @SerializedName("url")
            var url: String = ""
        )
    
        data class Parent(
            @SerializedName("html_url")
            var htmlUrl: String = "",
            @SerializedName("sha")
            var sha: String = "",
            @SerializedName("url")
            var url: String = ""
        )
    }
}