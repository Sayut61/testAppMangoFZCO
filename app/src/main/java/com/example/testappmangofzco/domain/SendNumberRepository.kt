package com.example.testappmangofzco.domain

import okhttp3.Response

interface SendNumberRepository {
    suspend fun sendPhoneNumber(number: String): Response
}