package com.avansb.smartfarm.networking.services

import com.avansb.smartfarm.model.AirData
import com.avansb.smartfarm.model.AirModules
import retrofit2.Response
import retrofit2.http.GET

interface AirService {
    @GET("module/lucht")
    suspend fun getAirSensorsData(): Response<List<AirModules>>

    @GET("airmodules")
    suspend fun fetchAirData(): Response<List<AirData>>
    @GET("airmodule")
    suspend fun fetchLatestAirData():Response<AirData>
}