package com.tare.githubbrowser.pojo.entities


import com.google.gson.annotations.SerializedName

data class Commit(
    @SerializedName("sha")
    var sha: String = "",
    @SerializedName("url")
    var url: String = ""
)