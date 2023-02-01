package com.avansb.smartfarm.networking.services

import com.avansb.smartfarm.model.Crops
import retrofit2.Response
import retrofit2.http.*

interface CropService {
        @GET("crops")
        suspend fun fetchCrops(): Response<List<Crops>>
        @GET("crop/{id}")
        suspend fun fetchCrop(@Path("id")id: Int): Response<Crops>
        @GET("cropfield/{id}")
        suspend fun fetchCropField(@Path("id")id:String):Response<Crops>
        @POST("crop")
        suspend fun addCrop(@Body newCrop: Crops): Response<Crops>
        @DELETE("crop/{id}")
        suspend fun deleteCrop(@Path("id") id: Int): Response<Void>
}

