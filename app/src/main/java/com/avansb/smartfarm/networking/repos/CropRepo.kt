package com.avansb.smartfarm.networking.repos

import com.avansb.smartfarm.model.Crops
import com.avansb.smartfarm.networking.WebAccessKtor
import retrofit2.Response

class CropRepo {
    suspend fun getCrops(): Response<List<Crops>>{
        return WebAccessKtor.cropApi.fetchCrops()
    }
    suspend fun getCrop(id: Int):Response<Crops> {
        return WebAccessKtor.cropApi.fetchCrop(id)
    }
    suspend fun getCropField(id:String):Response<Crops>{
        return WebAccessKtor.cropApi.fetchCropField(id)
    }
    suspend fun addCrop(crop: Crops): Response<Crops>{
        return WebAccessKtor.cropApi.addCrop(crop)
    }
    suspend fun deleteCrop(id: Int): Response<Void>{
        return WebAccessKtor.cropApi.deleteCrop(id)
    }
}

