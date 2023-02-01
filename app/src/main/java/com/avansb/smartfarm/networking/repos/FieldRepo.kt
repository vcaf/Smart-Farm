package com.avansb.smartfarm.networking.repos

import com.avansb.smartfarm.model.Fields
import com.avansb.smartfarm.networking.WebAccessKtor
import retrofit2.Response

class FieldRepo {
    suspend fun getFields(): Response<List<Fields>> {
        return WebAccessKtor.fieldApi.fetchFields()
    }
}