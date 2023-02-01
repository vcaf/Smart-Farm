package com.avansb.smartfarm.utils.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.Fields
import com.avansb.smartfarm.networking.repos.FieldRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class FieldViewModel(private val dataRepo: FieldRepo): ViewModel() {
    val dataResponse: MutableLiveData<Response<List<Fields>>> = MutableLiveData()

    fun getFieldData(){
        viewModelScope.launch {
            val response = dataRepo.getFields()
            dataResponse.value = response
        }
    }
}