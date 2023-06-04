package com.example.testappmangofzco.di

import com.example.testappmangofzco.data.SendNumberRepositoriesImpl
import com.example.testappmangofzco.data.dto.RemoteDataSource
import com.example.testappmangofzco.domain.SendNumberRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource) : SendNumberRepository {
        return  SendNumberRepositoriesImpl(remoteDataSource)
    }
}