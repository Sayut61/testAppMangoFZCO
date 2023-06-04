package com.example.testappmangofzco.data

import com.example.testappmangofzco.data.dto.RemoteDataSource
import com.example.testappmangofzco.domain.SendNumberRepository
import okhttp3.ResponseBody
import javax.inject.Inject

class SendNumberRepositoriesImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : SendNumberRepository {
    override suspend fun sendPhoneNumber(number: String): ResponseBody {
        return remoteDataSource.sendPhoneNumber(number)
    }
}