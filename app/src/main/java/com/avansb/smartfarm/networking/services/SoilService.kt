package com.avansb.smartfarm.networking.services

import com.avansb.smartfarm.model.SoilData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SoilService {
    @GET("soilmodules")
    suspend fun fetchSoilData(): Response<List<SoilData>>

    @GET("soilmodule")
    suspend fun fetchSoilDate(
        @Query("id") id: Int
    ): Response<SoilData>
    @GET("soilmodule")
    suspend fun fetchLatestSoilDate(): Response<SoilData>
}