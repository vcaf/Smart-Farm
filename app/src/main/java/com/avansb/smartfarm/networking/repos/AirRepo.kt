package com.avansb.smartfarm.repos

import com.avansb.smartfarm.model.AirData
import com.avansb.smartfarm.model.AirModules
import com.avansb.smartfarm.networking.WebAccessKtor
import com.avansb.smartfarm.networking.WebAccessSpring
import retrofit2.Response

class AirRepo {
    suspend fun getPost(): Response<List<AirModules>>{
        return WebAccessSpring.apiAir.getAirSensorsData()
    }
    suspend fun getAirData(): Response<List<AirData>> {
        return WebAccessKtor.airApi.fetchAirData()
    }
    suspend fun getLatestAirData():Response<AirData>{
        return WebAccessKtor.airApi.fetchLatestAirData()
    }
}