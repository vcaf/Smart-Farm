//package com.avansb.smartfarm
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class HomeActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        System.out.println("AAAG")
//        Toast.makeText(this@HomeActivity, "Home page.", Toast.LENGTH_SHORT).show()
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//    }
//}



package com.avansb.smartfarm

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.avansb.smartfarm.crops.CropsActivity
import com.avansb.smartfarm.gasmodule.GasRepo
import com.avansb.smartfarm.gasmodule.GasViewModel
import com.avansb.smartfarm.gasmodule.GasViewModelFactory
import com.avansb.smartfarm.machinelearning.*
import com.avansb.smartfarm.networking.repos.SoilRepo
import com.avansb.smartfarm.networking.repos.WindRepo
import com.avansb.smartfarm.repos.AirRepo
import com.avansb.smartfarm.utils.viewmodels.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var soilViewModel: SoilModulesViewModel
    lateinit var gasViewModel: GasViewModel
    lateinit var windViewModel: WindViewModel
    lateinit var airViewModel: AirViewModel
    lateinit var iD3String: ID3String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        shimmer_home.startShimmer()
        shimmer_home.hideShimmer()
        val ib_crops = findViewById<TextView>(R.id.ib_crops)
        val ib_user = findViewById<ImageButton>(R.id.IB_user_home)

        val layoutSensors = findViewById<TextView>(R.id.ib_sensors)

        layoutSensors.setOnClickListener {
            Toast.makeText(this@HomeActivity, "Sensors.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SensorsMainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        ib_user.setOnClickListener {
            Toast.makeText(this@HomeActivity, "User.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SettingUserActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        ib_crops.setOnClickListener {
            val intent = Intent(this, CropsActivity::class.java)
            startActivity(intent)
        }

        val airRepo = AirRepo()
        val airViewModelFactory = AirViewModel.AirViewModelFactory(airRepo)
        airViewModel =
            ViewModelProvider(this, airViewModelFactory).get(AirViewModel::class.java)

        val soilRepo = SoilRepo()
        val soilViewModelFactory = SoilModuleViewModelFactory(soilRepo)
        soilViewModel =
            ViewModelProvider(this, soilViewModelFactory).get(SoilModulesViewModel::class.java)

        val gasRepo = GasRepo()
        val gasViewModelFactory = GasViewModelFactory(gasRepo)
        gasViewModel =
            ViewModelProvider(this, gasViewModelFactory).get(GasViewModel::class.java)

        val windRepo = WindRepo()
        val windViewModelFactory = WindViewModelFactory(windRepo)
        windViewModel =
            ViewModelProvider(this, windViewModelFactory).get(WindViewModel::class.java)

//        loadAir()
//        loadSoil()
//        loadWind()
//        loadGas()

        iD3String = ID3().id3datacast(id3model())
        val gewas = "Consumptie aardapelen"

        id3tree(iD3String, gewas)
    }


    private fun loadAir() {

        airViewModel.getLatestAirData()
        airViewModel.myLatestResponse.observe(this, { response ->
            if (response.isSuccessful) {
                val airTemp = response.body()?.airTemp
                TV_temperature_degrees_Activity_home.text = airTemp.toString()
                id3model().temperatuur = airTemp!!
                val airHumid = response.body()?.airHumid
                TV_humidity_percent_Activity_home.text = airHumid.toString()
            }
        })

    }

    private fun loadSoil() {

        soilViewModel.getLatestSoilDate()
        soilViewModel.myHomeResponse.observe(this, { response ->
            if (response.isSuccessful) {
                val sv = response.body()?.soilValue
                id3model().grond = sv!!
                TV_soil_percent_Activity_home.text = sv.toString()
                shimmer_home.hideShimmer()
            }
        })
    }

    private fun loadGas() {

        gasViewModel.getLatestGas()
        gasViewModel.latestGasResponse.observe(this, { response ->
            if (response.isSuccessful) {
                val gasmodule = response.body()?.moduleWaarde
                id3model().gassen = gasmodule!!
                shimmer_home.hideShimmer()
            }
        })

    }

    private fun loadWind() {

        windViewModel.getLatestWindDate()
        windViewModel.myHomeResponse.observe(this, { response ->
            if (response.isSuccessful) {
                val wnd = response.body()?.windSpeed
                TV_wind_speed_Activity_home.text = wnd.toString()
                id3model().wind = wnd!!
                shimmer_home.hideShimmer()
            }
        })
    }

    private fun id3model(): ID3Model {
        val air = 20
        val soil = 69
        val wind = 25
        val gas = 400

        return ID3Model(air, soil, wind, gas)
    }


    private fun id3tree(iD3String: ID3String, gewas: String) {
        ll_bad_condition.isVisible = false
        ll_normal_condition.isVisible = false
        ll_good_condition.isVisible = false
        tv_bad_conditon_Activity_home.text = gewas
        tv_normal_conditon_Activity_home.text = gewas
        tv_good_conditon_Activity_home.text = gewas

        when (iD3String.temperatuur) {
            "cold" -> {
                when (iD3String.grond) {
                    "dry" -> {
                        ll_bad_condition.isVisible = true

                    }
                    "normal" -> {
                        ll_normal_condition.isVisible = true


                    }
                    "wet" -> {
                        ll_bad_condition.isVisible = true

                    }
                }
            }
            "normal" -> {
                when (iD3String.grond) {
                    "dry" -> {
                        when (iD3String.gassen) {
                            "normal" -> {
                                ll_good_condition.isVisible = true

                            }
                            "high" -> {
                                ll_normal_condition.isVisible = true

                            }
                        }
                    }
                    "normal" -> {
                        ll_good_condition.isVisible = true

                    }
                    "wet" -> {
                        ll_normal_condition.isVisible = true

                    }
                }
            }
            "warm" -> {
                when (iD3String.grond) {
                    "dry" -> {
                        ll_normal_condition.isVisible = true

                    }
                    "normal" -> {
                        when (iD3String.wind) {
                            "soft" -> {
                                ll_good_condition.isVisible = true

                            }
                            "hard" -> {
                                ll_normal_condition.isVisible = true

                            }
                        }
                    }
                    "high" -> {
                        ll_bad_condition.isVisible = true

                    }
                }
            }
        }
    }
}


