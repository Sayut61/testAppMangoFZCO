package com.example.testappmangofzco.di

import com.example.testappmangofzco.data.RepositoriesImpl
import com.example.testappmangofzco.data.dto.RemoteDataSource
import com.example.testappmangofzco.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource) : Repository {
        return  RepositoriesImpl(remoteDataSource)
    }
}