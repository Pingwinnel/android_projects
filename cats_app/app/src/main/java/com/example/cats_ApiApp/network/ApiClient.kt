package com.example.cats_ApiApp.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    var gson = GsonBuilder()
        .setLenient()
        .create()
    private val okHttpClient=OkHttpClient.Builder()
        .addInterceptor{chain->
            val request=chain.request()

            val newRequest=request.newBuilder()
                .addHeader("X-Api-Key", value="hhCMpDRCk79f72MYWENpvg==d9R0zB2SZsSzepkQ")
                .build()

            chain.proceed(newRequest)
        }
        .build()
    private val retrofit:Retrofit=Retrofit.Builder()
        .baseUrl("https://api-ninjas.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val instance= retrofit.create(CatsService::class.java)

}