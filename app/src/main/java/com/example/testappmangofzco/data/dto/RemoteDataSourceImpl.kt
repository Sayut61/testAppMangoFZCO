package com.example.testappmangofzco.data.dto

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor() : RemoteDataSource {

    private val client = OkHttpClient()
        .newBuilder()
        .build()

    private var mangoApi = Retrofit.Builder()
        .baseUrl("https://plannerok.ru/docs#")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var serviceMangoApi = mangoApi.create(RestMangoApi::class.java)

    private interface RestMangoApi {
        @POST(value = "/api/v1/users/send-auth-code/{phone}")
        suspend fun sendAuthCode(@Path("phone", encoded = true) phone: String): ResponseBody
    }

    override suspend fun sendPhoneNumber(phone: String): ResponseBody {
        return serviceMangoApi.sendAuthCode(phone)
    }

}