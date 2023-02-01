package com.avansb.smartfarm.networking.repos

import com.avansb.smartfarm.model.WindModule
import com.avansb.smartfarm.networking.WebAccessKtor
import retrofit2.Response

class WindRepo {

    suspend fun getAllWindModules(): Response<List<WindModule>> {
        return WebAccessKtor.windApi.fetchWindModules()
    }

    suspend fun getLatestWindDate(): Response<WindModule> {
        return WebAccessKtor.windApi.fetchLatestWindDate()
    }
}