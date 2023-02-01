package com.avansb.smartfarm.networking.services

import com.avansb.smartfarm.model.WindModule
import retrofit2.Response
import retrofit2.http.GET

interface WindService {
    @GET("windmodules")
    suspend fun fetchWindModules():Response<List<WindModule>>
    @GET("windmodule")
    suspend fun fetchLatestWindDate(): Response<WindModule>
}