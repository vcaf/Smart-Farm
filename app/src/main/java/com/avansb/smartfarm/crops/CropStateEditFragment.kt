package com.avansb.smartfarm.crops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.avansb.smartfarm.R
import com.avansb.smartfarm.networking.repos.CropStateRepo
import com.avansb.smartfarm.utils.viewmodels.CropStateViewModel

class CropStateEditFragment : Fragment() {
    lateinit var viewModel: CropStateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.crop_state_edit, container, false)
        val respository = CropStateRepo()
        val viewModelFactory = CropStateViewModel.CropStateViewModelFactory(respository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(CropStateViewModel::class.java)


        return view
    }
}