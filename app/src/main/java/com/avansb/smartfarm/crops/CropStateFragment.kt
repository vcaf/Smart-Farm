package com.avansb.smartfarm.crops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.avansb.smartfarm.R
import com.avansb.smartfarm.networking.repos.CropStateRepo
import com.avansb.smartfarm.utils.viewmodels.CropStateViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CropStateFragment : BottomSheetDialogFragment() {
    lateinit var viewModel: CropStateViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.crop_state_fragment, container, false)


        val cancelButton = view.findViewById<Button>(R.id.btn_crpst_cncl)
        val editButton = view.findViewById<Button>(R.id.btn_crpst_edit)
        val cropStateName = view.findViewById<TextView>(R.id.tv_crpst_title)
        val minSoil = view.findViewById<TextView>(R.id.tv_min_soil_value)
        val maxSoil = view.findViewById<TextView>(R.id.tv_max_soil_value)
        val minTemp = view.findViewById<TextView>(R.id.tv_min_temp_value)
        val maxTemp = view.findViewById<TextView>(R.id.tv_max_temp_value)
        val minHumid = view.findViewById<TextView>(R.id.tv_min_humid_value)
        val maxHumid = view.findViewById<TextView>(R.id.tv_max_humid_value)
        val maxWind = view.findViewById<TextView>(R.id.tv_max_wind_value)
        val windDirection = view.findViewById<TextView>(R.id.tv_wind_direction)

        val cropName = arguments?.getString("name")
        val cropId = arguments?.getString("cropid")



        cropStateName.text = cropName
        val respository = CropStateRepo()
        val viewModelFactory = CropStateViewModel.CropStateViewModelFactory(respository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(CropStateViewModel::class.java)
        if (cropId != null) {
            viewModel.getCropState(cropId)
            viewModel.cropStateResponse.observe(this, { response ->
                if (response.isSuccessful) {
                    response.body()?.forEach {
                        minSoil.text = it.minSoilMoisture.toString()
                        maxSoil.text = it.maxSoilMoisture.toString()
                        minTemp.text = it.minTemperature.toString()
                        maxTemp.text = it.maxTemperature.toString()
                        minHumid.text = it.minHumidity.toString()
                        maxHumid.text = it.maxHumidity.toString()
                        maxWind.text = it.maxWindspeed.toString()
                        windDirection.text = it.windDirection.toString()
                    }
                } else {
                    println(response.errorBody())
                }
            })
        }

        cancelButton.setOnClickListener {
            dismiss()
        }
        editButton.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.action_cropListFragment_to_cropStateEditFragment)
        }
        return view
    }

}