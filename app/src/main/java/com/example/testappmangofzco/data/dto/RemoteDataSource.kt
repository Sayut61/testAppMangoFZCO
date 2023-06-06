package com.example.testappmangofzco.data.dto

import okhttp3.Response

interface RemoteDataSource {
    suspend fun sendPhoneNumber(phone: String): Response
}