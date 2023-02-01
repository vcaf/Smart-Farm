package com.avansb.smartfarm.gasmodule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.avansb.smartfarm.model.GasModule
import kotlinx.coroutines.launch
import retrofit2.Response

class GasViewModel(private val repo: GasRepo):ViewModel() {
    val gasResponse: MutableLiveData<Response<List<GasModule>>> = MutableLiveData()
    val latestGasResponse: MutableLiveData<Response<GasModule>> = MutableLiveData()

    fun getGas(){
        viewModelScope.launch {
            val response = repo.getGas()
            gasResponse.value = response
        }
    }
    fun getLatestGas(){
        viewModelScope.launch {
            val response = repo.getLatestGas()
            latestGasResponse.value = response
        }
    }

}
class GasViewModelFactory(private val repo: GasRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GasViewModel(repo) as T
    }
}