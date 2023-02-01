package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SoilData(
    val id: Int,
    val soilValue: Int,
    val soilDate: String,
    val soilId: String,
)
