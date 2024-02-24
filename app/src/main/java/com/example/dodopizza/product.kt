package com.example.dodopizza

data class Product(
        var img: Int,
        var name: String,
        var description: String,
        var price: String
) {
    // No need for separate getter and setter functions in Kotlin
}
