package com.avansb.smartfarm.utils.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.CropState
import com.avansb.smartfarm.networking.repos.CropStateRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class CropStateViewModel(private val repo: CropStateRepo): ViewModel() {
    val cropStatesResponse: MutableLiveData<Response<List<CropState>>> = MutableLiveData()
    val cropStateResponse: MutableLiveData<Response<List<CropState>>> = MutableLiveData()
    val cropStatePostResponse:MutableLiveData<Response<CropState>> = MutableLiveData()

    fun getCropStates() {
        viewModelScope.launch {
            val response = repo.getCropStates()
            cropStatesResponse.value = response
        }
    }

    fun getCropState(id: String) {
        viewModelScope.launch {
            val response = repo.getCropState(id)
            cropStateResponse.value = response
        }
        fun addCropState(cropState: CropState) {
            viewModelScope.launch {
                val response = repo.addCropState(cropState)
                cropStatePostResponse.value = response

            }
        }

        fun updateCropState() {
            viewModelScope.launch {

            }
        }

        fun deleteCropState() {
            viewModelScope.launch {

            }
        }
    }

    class CropStateViewModelFactory(private val repo: CropStateRepo) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CropStateViewModel(repo) as T
        }
    }
}