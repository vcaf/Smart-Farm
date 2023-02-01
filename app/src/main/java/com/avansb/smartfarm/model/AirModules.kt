package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class AirModules(
    val air_id: String?,
    val id: Int?,
    val air_temp: Int?,
    val air_humid: Int?
)

