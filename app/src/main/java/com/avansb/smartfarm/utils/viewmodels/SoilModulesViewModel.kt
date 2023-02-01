package com.avansb.smartfarm.utils.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.SoilData
import com.avansb.smartfarm.networking.repos.SoilRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class SoilModulesViewModel(private val repo: SoilRepo) : ViewModel() {
    val myResponse: MutableLiveData<Response<List<SoilData>>> = MutableLiveData()
    val myHomeResponse: MutableLiveData<Response<SoilData>> = MutableLiveData()
    fun getSoilData() {
        viewModelScope.launch {
            val response = repo.getSoilData()
            myResponse.value = response
        }
    }

    fun getLatestSoilDate() {
        viewModelScope.launch {
            val response = repo.getLatestSoilDate()
            myHomeResponse.value = response
        }
    }
}

class SoilModuleViewModelFactory(private val repo: SoilRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SoilModulesViewModel(repo) as T
    }
}