package com.avansb.smartfarm.crops

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.avansb.smartfarm.R
import com.avansb.smartfarm.databinding.CropAddFragmentBinding
import com.avansb.smartfarm.model.Crops
import com.avansb.smartfarm.networking.repos.CropRepo
import com.avansb.smartfarm.utils.viewmodels.CropsViewModel
import com.avansb.smartfarm.utils.viewmodels.CropsViewModelFactory

class CropAddFragment: Fragment(R.layout.crop_add_fragment) {
    private var _binding: CropAddFragmentBinding? = null
    private val binding: CropAddFragmentBinding get() = _binding!!
    private lateinit var viewModel: CropsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CropAddFragmentBinding.bind(view)

        val repo = CropRepo()
        val viewModelFactory = CropsViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CropsViewModel::class.java)

        val btnAddCrop = binding.btnCrpAdd
        val tiCropName = binding.tietCrpNm
        val tiCropLatin = binding.tietCrpLtn
        val tiCropSnStrt = binding.tietCrpStrt
        val tiCropSnEnd = binding.tietCrpEnd
        val tiCropYield = binding.tietCrpXyld
        val tiCropField = binding.tietCrpFld
        val tiCropImg = binding.tietCrpImg


        btnAddCrop.setOnClickListener {
            try {
                val cropName = tiCropName.text.toString()
                tiCropName.text?.clear()
                val cropLatin = tiCropLatin.text.toString()
                tiCropLatin.text?.clear()
                val cropSnStrt = tiCropSnStrt.text.toString()
                tiCropSnStrt.text?.clear()
                val cropSnEnd = tiCropSnEnd.text.toString()
                tiCropSnEnd.text?.clear()
                val cropYield = tiCropYield.text.toString()
                tiCropYield.text?.clear()
                val cropImg = tiCropImg.text.toString()
                tiCropImg.text?.clear()
                val cropField = tiCropField.text.toString()
                tiCropField.text?.clear()

                val cropPost = Crops( +1, "",cropName,cropLatin,cropSnStrt,cropSnEnd,cropYield,cropImg,cropField)
                viewModel.addCrop(cropPost)
                viewModel.cropResponse.observe(viewLifecycleOwner,{
                        response->
                    if (response.isSuccessful){
                        Log.d("Crops",response.body().toString())
                        Log.d("Crops",response.code().toString())
                        Log.d("Crops",response.message().toString())
                    }
                })
            }catch(e:Exception){
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
        }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}