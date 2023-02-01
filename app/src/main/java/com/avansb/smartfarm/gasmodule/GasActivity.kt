package com.avansb.smartfarm.gasmodule

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.R
import com.avansb.smartfarm.model.GasModule
import com.avansb.smartfarm.utils.adapters.GasAdapter

class GasActivity : AppCompatActivity() {

    lateinit var gasAdapter: GasAdapter
    lateinit var viewModel: GasViewModel
    lateinit var recyclerView: RecyclerView
    var gasList = ArrayList<GasModule>()
    var position: Int = 0

    private fun initialise() {
        recyclerView = findViewById(R.id.gasModuleRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val repo = GasRepo()
        val viewModelFactory = GasViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GasViewModel::class.java)
        try {
            fetchData()
            gasAdapter = GasAdapter(this, gasList) { gas, position ->
                onItemClicked(
                    gas,
                    position
                )
            }
            recyclerView.adapter = gasAdapter

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun fetchData() {
        viewModel.getGas()
        viewModel.gasResponse.observe(this, { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    gasList.clear()
                    gasList.addAll(it)
                }
                recyclerView.adapter?.notifyDataSetChanged()
            } else {
                Log.e("GasApi", "Error ${response.code()}")
                Toast.makeText(this, "Failed to retrieve crops", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gas_module)
        initialise()
    }

    private fun onItemClicked(gas: GasModule, position: Int) {

    }
}