package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Crops(
val id:Int,
val cropId:String,
val cropName: String,
val cropLatin: String,
val seasonStart: String,
val seasonEnd: String,
val expectedYield: String,
val cropImgUrl: String,
val fieldId:String,
)