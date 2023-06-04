package com.example.testappmangofzco.domain.usecases

import com.example.testappmangofzco.domain.SendNumberRepository
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

class SendPhoneUseCase @Inject constructor(
    private val  sendNumberRepository: SendNumberRepository
) {
    suspend fun sendNumberRepository(number: String): ResponseBody {
        return sendNumberRepository.sendPhoneNumber(number)
    }
}