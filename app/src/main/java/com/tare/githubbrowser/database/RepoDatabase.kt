package com.tare.githubbrowser.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tare.githubbrowser.pojo.entities.Repository

@Database(entities = [Repository::class], version = 4)
abstract class RepoDatabase: RoomDatabase() {
    abstract fun repoDao(): RepoDao
}