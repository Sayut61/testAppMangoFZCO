package com.example.testappmangofzco.di

import com.example.testappmangofzco.data.SendNumberRepositoriesImpl
import com.example.testappmangofzco.data.dto.RemoteDataSourceImpl
import com.example.testappmangofzco.domain.SendNumberRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesSendNumberRepository(remoteDataSource: RemoteDataSourceImpl): SendNumberRepository {
        return SendNumberRepositoriesImpl(remoteDataSource)
    }
}