package com.example.cats_ApiApp.models

import com.google.gson.annotations.SerializedName

data class CatsModel(
    @SerializedName("name") val name: String?,
    @SerializedName("origin") val origin: String?,
    @SerializedName("image_link") val imageLink: String?,
    @SerializedName("length") val length: String?,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: String?
)

