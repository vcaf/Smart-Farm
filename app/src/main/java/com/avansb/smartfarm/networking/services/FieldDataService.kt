package com.avansb.smartfarm.networking.services

import com.avansb.smartfarm.model.FieldData
import retrofit2.Response
import retrofit2.http.GET

interface FieldDataService {
    @GET("fdata")
    suspend fun fetchFieldData(): Response<List<FieldData>>
}