package com.avansb.smartfarm.utils.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.Crops
import com.avansb.smartfarm.networking.repos.CropRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class CropsViewModel(private val repo: CropRepo): ViewModel() {
    val cropsResponse: MutableLiveData<Response<List<Crops>>> = MutableLiveData()
    val cropResponse: MutableLiveData<Response<Crops>> = MutableLiveData()
    val cropFieldResponse:MutableLiveData<Response<Crops>> = MutableLiveData()

    fun getCrops(){
        viewModelScope.launch {
            val response = repo.getCrops()
            cropsResponse.value = response
        }
    }
    fun getCrop(id: Int){
        viewModelScope.launch {
            val response = repo.getCrop(id)
            cropResponse.value = response
        }
    }
    fun getCropField(id:String){
        viewModelScope.launch {
            val response = repo.getCropField(id)
            cropFieldResponse.value = response

        }
    }
    fun addCrop(crops: Crops){
        viewModelScope.launch {
            val response = repo.addCrop(crops)
            cropResponse.value = response

        }
    }

    fun deleteCrop(){
        viewModelScope.launch {

        }
    }
}
class CropsViewModelFactory(private val repo: CropRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CropsViewModel(repo) as T
    }
}