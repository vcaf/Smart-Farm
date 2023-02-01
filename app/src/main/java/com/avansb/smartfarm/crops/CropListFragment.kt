package com.avansb.smartfarm.crops

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.R
import com.avansb.smartfarm.databinding.CropListFragmentBinding
import com.avansb.smartfarm.model.Crops
import com.avansb.smartfarm.networking.repos.CropRepo
import com.avansb.smartfarm.utils.adapters.CropAdapter
import com.avansb.smartfarm.utils.viewmodels.CropsViewModel
import com.avansb.smartfarm.utils.viewmodels.CropsViewModelFactory
import kotlinx.android.synthetic.main.crop_list_fragment.*

class CropListFragment : Fragment(R.layout.crop_list_fragment) {
    private var _binding: CropListFragmentBinding? = null
    private val binding: CropListFragmentBinding get() = _binding!!

    lateinit var cropAdapter: CropAdapter
    lateinit var viewModel: CropsViewModel
    lateinit var recyclerView: RecyclerView
    var cropList = ArrayList<Crops>()
    var position: Int = 0

    private fun initialise() {
        shimmer_crops.startShimmer()
        recyclerView = binding.rvCrops
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val repo = CropRepo()
        val viewModelFactory = CropsViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CropsViewModel::class.java)
        try {
            fetchData()
            cropAdapter = CropAdapter(requireContext(), cropList) { crop, position ->
                onItemClicked(
                    crop,
                    position
                )
            }
            recyclerView.adapter = cropAdapter

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CropListFragmentBinding.bind(view)
        initialise()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchData() {
        viewModel.getCrops()
        viewModel.cropsResponse.observe(viewLifecycleOwner, { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    cropList.clear()
                    cropList.addAll(it)
                    shimmer_crops.hideShimmer()
                }
                recyclerView.adapter?.notifyDataSetChanged()

            } else {
                Log.e("CropApi", "Error ${response.code()}")
                Toast.makeText(context, "Failed to retrieve crops", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun onItemClicked(crop: Crops, position: Int) {
        this.position = position
        val bundle = Bundle()
        bundle.putInt("id", crop.id)
        bundle.putString("cropid", crop.cropId)
        bundle.putString("name", crop.cropName)
        bundle.putString("latin", crop.cropLatin)
        bundle.putString("start", crop.seasonStart)
        bundle.putString("end", crop.seasonEnd)
        bundle.putString("yield", crop.expectedYield)
        bundle.putString("url", crop.cropImgUrl)
        bundle.putString("field",crop.fieldId)
        val cropDetailsFragment = CropDetailsFragment()
        cropDetailsFragment.arguments = bundle
        cropDetailsFragment.show(parentFragmentManager,"CropDetails")
    }
}