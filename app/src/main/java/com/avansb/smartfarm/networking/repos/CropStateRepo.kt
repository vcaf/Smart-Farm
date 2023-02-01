package com.avansb.smartfarm.networking.repos

import com.avansb.smartfarm.model.CropState
import com.avansb.smartfarm.networking.WebAccessKtor
import retrofit2.Response

class CropStateRepo {
    suspend fun getCropStates(): Response<List<CropState>> {
        return WebAccessKtor.cropStateApi.fetchCropStates()
    }
    suspend fun getCropState(id: String): Response<List<CropState>> {
        return WebAccessKtor.cropStateApi.fetchCropState(id)
    }
    suspend fun addCropState(cropstate: CropState): Response<CropState> {
        return WebAccessKtor.cropStateApi.addCropState(cropstate)
    }
    suspend fun updateCropState(id: Int, newCropState: CropState): Response<CropState> {
        return WebAccessKtor.cropStateApi.updateCropState(id, newCropState)
    }
    suspend fun deleteCropState(id: Int): Response<Void> {
        return WebAccessKtor.cropStateApi.deleteCropState(id)
    }
}
