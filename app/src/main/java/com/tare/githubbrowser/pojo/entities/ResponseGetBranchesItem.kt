package com.tare.githubbrowser.pojo.entities


import com.google.gson.annotations.SerializedName

data class ResponseGetBranchesItem(
    @SerializedName("commit")
    var commit: Commit = Commit(),
    @SerializedName("name")
    var name: String = "",
    @SerializedName("protected")
    var `protected`: Boolean = false
)