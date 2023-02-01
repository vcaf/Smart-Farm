package com.avansb.smartfarm.soilmodule

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.R
import com.avansb.smartfarm.model.SoilData
import com.avansb.smartfarm.networking.repos.SoilRepo
import com.avansb.smartfarm.utils.adapters.SoilAdapter
import com.avansb.smartfarm.utils.viewmodels.SoilModuleViewModelFactory
import com.avansb.smartfarm.utils.viewmodels.SoilModulesViewModel

class SoilActivity : AppCompatActivity() {
    lateinit var soilAdapter: SoilAdapter
    lateinit var viewModel: SoilModulesViewModel
    lateinit var recyclerView: RecyclerView
    var soilList = ArrayList<SoilData>()
    var position: Int = 0

    private fun initialise() {
        recyclerView = findViewById(R.id.rv_soil)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val repo = SoilRepo()
        val viewModelFactory = SoilModuleViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SoilModulesViewModel::class.java)
        fetchData()
        soilAdapter = SoilAdapter(this, soilList) { soilModule, position ->
            onItemClicked(
                soilModule,
                position
            )
        }
        recyclerView.adapter = soilAdapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.soil_activity)
        initialise()


    }

    private fun fetchData() {
        viewModel.getSoilData()
        viewModel.myResponse.observe(this, { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    soilList.clear()
                    soilList.addAll(it)
                }
                recyclerView.adapter?.notifyDataSetChanged()
            } else {
                Log.e("SoilApi", "Error ${response.code()}")
                Toast.makeText(this, "Failed to retrieve crops", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun onItemClicked(soilModule: SoilData, position: Int) {

    }


}