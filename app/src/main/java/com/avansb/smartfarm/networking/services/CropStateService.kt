package com.avansb.smartfarm.networking.services

import com.avansb.smartfarm.model.CropState
import retrofit2.Response
import retrofit2.http.*

interface CropStateService {
    @GET("cropstates")
    suspend fun fetchCropStates(): Response<List<CropState>>
    @GET("cropstates")
    suspend fun fetchCropState(@Query("id")id: String): Response<List<CropState>>
    @POST("cropstate")
    suspend fun addCropState(@Body newCropState: CropState): Response<CropState>
    @PUT("cropstate/{id}")
    suspend fun updateCropState(@Path("id") id: Int, @Body newCropState: CropState): Response<CropState>
    @DELETE("cropstate{id}")
    suspend fun deleteCropState(@Path("id") id: Int): Response<Void>
}