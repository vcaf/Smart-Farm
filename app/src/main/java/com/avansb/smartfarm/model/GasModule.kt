package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GasModule(
    val id: Int,
    val moduleNaam: String,
    val moduleWaarde:Int,
    val moduleTimestamp:String,
)
