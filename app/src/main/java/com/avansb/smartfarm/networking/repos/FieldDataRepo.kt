package com.avansb.smartfarm.networking.repos

import com.avansb.smartfarm.model.FieldData
import com.avansb.smartfarm.networking.WebAccessKtor
import retrofit2.Response

class FieldDataRepo {
    suspend fun getFieldData(): Response<List<FieldData>> {
        return WebAccessKtor.dataApi.fetchFieldData()
    }
}