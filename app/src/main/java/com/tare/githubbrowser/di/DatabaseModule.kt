package com.tare.githubbrowser.di

import android.content.Context
import androidx.room.Room
import com.tare.githubbrowser.database.RepoDao
import com.tare.githubbrowser.database.RepoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRepoDatabase(@ApplicationContext context: Context): RepoDatabase {
        return Room.databaseBuilder(
            context,
            RepoDatabase::class.java,
            "Repository"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRepoDao(repoDatabase: RepoDatabase): RepoDao {
        return repoDatabase.repoDao()
    }
}