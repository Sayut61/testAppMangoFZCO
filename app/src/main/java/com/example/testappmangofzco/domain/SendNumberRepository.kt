package com.example.testappmangofzco.domain

import okhttp3.ResponseBody

interface SendNumberRepository {
    suspend fun sendPhoneNumber(number: String): ResponseBody
}