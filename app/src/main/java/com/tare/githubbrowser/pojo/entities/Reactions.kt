package com.tare.githubbrowser.pojo.entities


import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("confused")
    var confused: Int = 0,
    @SerializedName("eyes")
    var eyes: Int = 0,
    @SerializedName("heart")
    var heart: Int = 0,
    @SerializedName("hooray")
    var hooray: Int = 0,
    @SerializedName("laugh")
    var laugh: Int = 0,
    @SerializedName("rocket")
    var rocket: Int = 0,
    @SerializedName("total_count")
    var totalCount: Int = 0,
    @SerializedName("url")
    var url: String = "",
    @SerializedName("+1")
    var x1: Int = 0,
    @SerializedName("-1")
    var x_1: Int = 0
)