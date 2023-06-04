package com.example.testappmangofzco.data.dto

import okhttp3.Response
import okhttp3.ResponseBody

interface RemoteDataSource {
    suspend fun sendPhoneNumber(phone: String): ResponseBody
}