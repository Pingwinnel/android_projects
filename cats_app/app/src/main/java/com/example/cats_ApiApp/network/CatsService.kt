package com.example.cats_ApiApp.network

import com.example.cats_ApiApp.models.CatsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatsService {
    @GET("cats?name=a")
    fun FetchCats(@Header("X-Api-Key") apiKey: String?): Call<List<CatsModel>>

    @GET("cats")
    fun getCatbyName(@Query("name") name: String?,
                     @Header("X-Api-Key") apiKey: String?):Call<List<CatsModel>>

    @GET("cats")
    fun getCatByOrigin(@Query("origin") origin:String?,
                       @Header("X-Api-Key") apiKey: String?):Call<List<CatsModel>>

    @GET("cats")
    fun getCatByMaxLife(@Query("max_life_expectancy") maxLifeExpectancy:String?,
                        @Header("X-Api-Key") apiKey: String?):Call<List<CatsModel>>



}


