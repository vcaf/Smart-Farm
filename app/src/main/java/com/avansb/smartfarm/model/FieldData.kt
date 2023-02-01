package com.avansb.smartfarm.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FieldData(
    val fieldDataId:String,
    val fieldId:String,
    val cropId:String,
    val sensorValue: Int,
    val moduleId: String,
    val fieldDataDatetime: String,
)