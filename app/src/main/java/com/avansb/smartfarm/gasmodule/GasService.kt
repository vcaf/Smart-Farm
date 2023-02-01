package com.avansb.smartfarm.gasmodule

import com.avansb.smartfarm.model.GasModule
import retrofit2.Response
import retrofit2.http.GET

interface GasService {
    @GET("gas")
    suspend fun fetchGas(): Response<List<GasModule>>
    @GET("lastgas")
    suspend fun fetchLatestGas():Response<GasModule>
}
