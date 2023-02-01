package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AirData(
    val id:Int,
    val airId:String,
    val airTemp:Int,
    val airHumid:Int,
)

