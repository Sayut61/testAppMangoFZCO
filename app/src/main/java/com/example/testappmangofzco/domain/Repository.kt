package com.example.testappmangofzco.domain

interface Repository {
    suspend fun sendPhoneNumber(number: String)
}