package com.example.atlandroidexamples.network.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int?,
    val name: String?,
    val email: String?,
    val phone: String?,
    val address: Address?

)

data class Address(
    val city: String?,
    val street: String?,
    val geo: Geo?
)

data class Geo(
    val lat: String?,
    val lng: String
)