package com.avansb.smartfarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.factories.AirModulesModelFactory
import com.avansb.smartfarm.model.AirModules
import com.avansb.smartfarm.repos.AirRepo
import com.avansb.smartfarm.utils.adapters.AirModuleAdapter
import com.avansb.smartfarm.viewmodels.AirModulesViewModel

class FragmentTabLuchtModuleTemHum : Fragment() {
    private val luchtModeleList = ArrayList<AirModules>()
    private lateinit var luchtModulesAdapter: AirModuleAdapter
    private lateinit var viewModel: AirModulesViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.activity_fragment_tab_lucht_module_tem_hum, container, false)
        recyclerView = inflate.findViewById(R.id.recyclerView_FragmentTabLuchtModuleTemHum)
        initialise()

        return inflate
    }


    private fun initialise(){
        luchtModulesAdapter = AirModuleAdapter(luchtModeleList)
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView?.layoutManager = layoutManager

        val repository = AirRepo()
        val viewModelFactory = AirModulesModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AirModulesViewModel::class.java)
        try {
            fetchData()
            luchtModulesAdapter = AirModuleAdapter(luchtModeleList)
            recyclerView.adapter = luchtModulesAdapter

        }catch (e: Exception) {
            e.printStackTrace()
        }

    }


    private fun fetchData(){
        viewModel.getPost()
        viewModel.myResponse.observe(getViewLifecycleOwner(), { response ->
            if (response.isSuccessful) {
                response.body()?.let { luchtModeleList.addAll(it) }
                recyclerView.adapter?.notifyDataSetChanged()
            }else{
                Toast.makeText(activity, "Failed to retrieve air modules",Toast.LENGTH_SHORT).show()
            }
        })
    }
}