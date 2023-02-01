package com.avansb.smartfarm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.AirModules
import com.avansb.smartfarm.repos.AirRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class AirModulesViewModel (private val repository: AirRepo): ViewModel() {

    val myResponse: MutableLiveData<Response<List<AirModules>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

}