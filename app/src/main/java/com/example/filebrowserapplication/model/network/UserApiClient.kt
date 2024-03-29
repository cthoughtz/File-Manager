package com.example.filebrowserapplication.model.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserApiClient {

    val BASE_URL ="https://jsonplaceholder.typicode.com"
    val userInfoService: UserInfoService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        userInfoService = retrofit.create(UserInfoService::class.java)
    }

    fun getUserInfoClient(): UserInfoService = userInfoService
}