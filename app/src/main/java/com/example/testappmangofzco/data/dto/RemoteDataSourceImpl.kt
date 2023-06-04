package com.example.testappmangofzco.data.dto

import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor() : RemoteDataSource {

    private val client = OkHttpClient()
        .newBuilder()
        .build()

    private var mangoApi = Retrofit.Builder()
        .baseUrl("https://plannerok.ru/docs")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var serviceMangoApi = mangoApi.create(RestMangoApi::class.java)

    private interface RestMangoApi {
        @FormUrlEncoded
        @POST(value = "/api/v1/users/send-auth-code")
        suspend fun sendAuthCode(@Field("phone") phone: String): Response
    }

    override suspend fun sendPhoneNumber(phone: String): Response {
        return serviceMangoApi.sendAuthCode(phone)
    }

}