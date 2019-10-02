package com.example.filebrowserapplication.model.network

import com.example.filebrowserapplication.model.UserInfo
import com.example.filebrowserapplication.model.UserInformation
import com.google.gson.Gson
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserInfoService {

    @GET("/users")
    fun getUserInfo(): Observable<ArrayList<UserInformation>>

    companion object{

        fun create(): UserInfoService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()

            return retrofit.create(UserInfoService::class.java)
        }
    }
}