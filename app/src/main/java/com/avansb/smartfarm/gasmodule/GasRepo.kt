package com.avansb.smartfarm.gasmodule

import com.avansb.smartfarm.model.GasModule
import com.avansb.smartfarm.networking.WebAccessKtor
import retrofit2.Response

class GasRepo {
    suspend fun getGas(): Response<List<GasModule>> {
        return WebAccessKtor.gasApi.fetchGas()
    }
    suspend fun getLatestGas():Response<GasModule>{
        return WebAccessKtor.gasApi.fetchLatestGas()
    }
}