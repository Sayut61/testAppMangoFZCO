package com.example.testappmangofzco.data

import com.example.testappmangofzco.data.dto.RemoteDataSource
import com.example.testappmangofzco.domain.Repository
import javax.inject.Inject

class RepositoriesImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): Repository {
    override suspend fun sendPhoneNumber(number: String) {
        remoteDataSource.sendPhoneNumber(number)
    }

}