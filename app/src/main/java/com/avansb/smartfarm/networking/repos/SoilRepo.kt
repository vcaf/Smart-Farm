package com.avansb.smartfarm.networking.repos

import com.avansb.smartfarm.model.SoilData
import com.avansb.smartfarm.networking.WebAccessKtor
import retrofit2.Response

class SoilRepo {
    suspend fun getSoilData(): Response<List<SoilData>> {
        return WebAccessKtor.soilApi.fetchSoilData()
    }
    suspend fun getSoilDate(id:Int): Response<SoilData> {
        return WebAccessKtor.soilApi.fetchSoilDate(id)
    }
    suspend fun getLatestSoilDate():Response<SoilData>{
        return WebAccessKtor.soilApi.fetchLatestSoilDate()
    }

}