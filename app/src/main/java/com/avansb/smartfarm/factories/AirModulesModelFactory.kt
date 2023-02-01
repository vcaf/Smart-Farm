package com.avansb.smartfarm.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avansb.smartfarm.repos.AirRepo
import com.avansb.smartfarm.viewmodels.AirModulesViewModel

class AirModulesModelFactory (private val repository: AirRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AirModulesViewModel(repository) as T
    }
}