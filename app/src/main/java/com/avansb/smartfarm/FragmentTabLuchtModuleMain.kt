package com.avansb.smartfarm

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.avansb.smartfarm.factories.AirModulesModelFactory
import com.avansb.smartfarm.model.AirModules
import com.avansb.smartfarm.repos.AirRepo
import com.avansb.smartfarm.viewmodels.AirModulesViewModel

class FragmentTabLuchtModuleMain : Fragment() {
    private val luchtModeleList = ArrayList<AirModules>()
    private lateinit var viewModel: AirModulesViewModel
    lateinit var tvHumidity: TextView
    lateinit var tvTemp: TextView
    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.activity_fragment_tab_lucht_module_main, container, false)

        tvTemp= inflate.findViewById(R.id.TV_temperature_celcius_module_FragmentTabLuchtModuleMain) as TextView
        tvHumidity= inflate.findViewById(R.id.TV_humidity_percent_module_Activity_home) as TextView
        initialise()

        return inflate

    }
    private fun initialise(){

        val repository = AirRepo()
        val viewModelFactory = AirModulesModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AirModulesViewModel::class.java)
        try {
            fetchData()

        }catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun fetchData(){
        viewModel.getPost()
        viewModel.myResponse.observe(getViewLifecycleOwner(), { response ->
            if (response.isSuccessful) {
                response.body()?.let { luchtModeleList.addAll(it) }
                var arraySize = luchtModeleList.size
                var lastNum = arraySize-1

                tvTemp.text= luchtModeleList[lastNum].air_temp.toString()
                tvHumidity.text= luchtModeleList[lastNum].air_humid.toString()

            }else{
                Toast.makeText(activity, "Failed to retrieve air modules",Toast.LENGTH_SHORT).show()
            }
        })
    }
}