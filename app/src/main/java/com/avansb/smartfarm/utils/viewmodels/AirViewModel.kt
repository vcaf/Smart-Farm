package com.avansb.smartfarm.utils.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.AirData
import com.avansb.smartfarm.repos.AirRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class AirViewModel(private val airRepo: AirRepo) : ViewModel() {
    val myResponse: MutableLiveData<Response<List<AirData>>> = MutableLiveData()
    val myLatestResponse: MutableLiveData<Response<AirData>> = MutableLiveData()

    fun getAirData() {
        viewModelScope.launch {
            val response = airRepo.getAirData()
            myResponse.value = response
        }
    }
    fun getLatestAirData(){
        viewModelScope.launch {
            val response = airRepo.getLatestAirData()
            myLatestResponse.value = response
        }
    }
    class AirViewModelFactory(private val repo: AirRepo) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AirViewModel(repo) as T
        }
    }
}