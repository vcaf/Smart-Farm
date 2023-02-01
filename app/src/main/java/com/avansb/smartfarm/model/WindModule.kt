package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindModule(
    val id: Int,
    val windId: String,
    val windDirec: Int,
    val windSpeed:Int,
    val windDate: String,
)
