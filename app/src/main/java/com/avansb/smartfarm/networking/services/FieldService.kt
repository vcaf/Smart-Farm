package com.avansb.smartfarm.networking.services

import com.avansb.smartfarm.model.Fields
import retrofit2.Response
import retrofit2.http.GET

interface FieldService {
    @GET("fields")
    suspend fun fetchFields(): Response<List<Fields>>
}