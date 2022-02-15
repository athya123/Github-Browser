package com.tare.githubbrowser.pojo.entities


import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("color")
    var color: String = "",
    @SerializedName("default")
    var default: Boolean = false,
    @SerializedName("description")
    var description: Any? = null,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("node_id")
    var nodeId: String = "",
    @SerializedName("url")
    var url: String = ""
)