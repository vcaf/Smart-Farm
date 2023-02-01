package com.avansb.smartfarm.utils.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.FieldData
import com.avansb.smartfarm.networking.repos.FieldDataRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class FieldDataViewModel(private val dataRepo: FieldDataRepo):ViewModel() {
    val dataResponse: MutableLiveData<Response<List<FieldData>>> = MutableLiveData()

    fun getFieldData(){
        viewModelScope.launch {
            val response = dataRepo.getFieldData()
            dataResponse.value = response
        }
    }
}