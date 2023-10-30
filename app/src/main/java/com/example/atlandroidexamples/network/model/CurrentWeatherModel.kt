package com.example.atlandroidexamples.network.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherModel(
    val location: Location?,
    val current: Current?

)
data class Location(
    val name: String?,
    val region: String?,
    val country: String?,
    val localtime: String?,
)


data class Current(
    @SerializedName("temp_c")
    val temperature: Int?,

    val condition: Condition?
)

data class Condition(
    val text: String?,
    val icon: String?
)