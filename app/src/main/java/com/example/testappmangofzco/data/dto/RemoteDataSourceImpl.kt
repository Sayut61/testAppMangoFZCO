package com.example.testappmangofzco.data.dto

import com.example.testappmangofzco.data.interceptors.ErrorInterceptor
import com.example.testappmangofzco.data.interceptors.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Path

class RemoteDataSourceImpl: RemoteDataSource {

    private val client = OkHttpClient()
        .newBuilder()
        .addInterceptor(HeaderInterceptor())
        .addInterceptor(ErrorInterceptor())
        .build()

    private var mangoApi = Retrofit.Builder()
        .baseUrl("https://plannerok.ru/docs#")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var serviceMangoApi = mangoApi.create(RestMangoApi::class.java)

    private interface RestMangoApi {
        @POST(value = "/api/v1/users/send-auth-code/{phone}")
        suspend fun sendAuthCode(@Path("phone", encoded = true) phone: String): Response
    }

    override suspend fun sendPhoneNumber(phone: String): Response {
       return serviceMangoApi.sendAuthCode(phone)
    }

}