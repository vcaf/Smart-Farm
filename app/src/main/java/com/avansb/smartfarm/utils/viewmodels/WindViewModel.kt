package com.avansb.smartfarm.utils.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.WindModule
import com.avansb.smartfarm.networking.repos.WindRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class WindViewModel(private val repo: WindRepo) : ViewModel() {
    val myResponse: MutableLiveData<Response<List<WindModule>>> = MutableLiveData()
    val myHomeResponse: MutableLiveData<Response<WindModule>> = MutableLiveData()

    fun getWindModules() {
        viewModelScope.launch {
            val response = repo.getAllWindModules()
            myResponse.value = response
        }
    }

    fun getLatestWindDate() {
        viewModelScope.launch {
            val response = repo.getLatestWindDate()
            myHomeResponse.value = response
        }
    }
}

class WindViewModelFactory(private val repo: WindRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WindViewModel(repo) as T
    }
}