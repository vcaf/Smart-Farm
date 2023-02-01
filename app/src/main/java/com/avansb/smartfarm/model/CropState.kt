package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CropState(
    val id:Int,
    val cropStateId:String,
    val cropId: String,
    val minSoilMoisture: Int,
    val maxSoilMoisture: Int,
    val minTemperature: Int,
    val maxTemperature: Int,
    val minHumidity: Int,
    val maxHumidity: Int,
    val maxWindspeed: Int,
    val windDirection:Int
)