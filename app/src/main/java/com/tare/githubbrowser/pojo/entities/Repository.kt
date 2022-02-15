package com.tare.githubbrowser.pojo.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Repository(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var name: String,
    var description: String?,
    var url: String,
    var owner: String
) {
}