package com.tare.githubbrowser.di

import com.tare.githubbrowser.database.RepoDao
import com.tare.githubbrowser.network.Services
import com.tare.githubbrowser.ui.detail.DetailRepository
import com.tare.githubbrowser.ui.home.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(services: Services,repoDao: RepoDao): HomeRepository{
        return HomeRepository(services, repoDao)
    }

    @Singleton
    @Provides
    fun provideDetailRepository(services: Services, repoDao: RepoDao): DetailRepository{
        return DetailRepository(services,repoDao)
    }
}