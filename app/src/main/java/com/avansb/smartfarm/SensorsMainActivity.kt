package com.avansb.smartfarm

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.avansb.smartfarm.soilmodule.SoilActivity
import com.avansb.smartfarm.gasmodule.GasActivity

class SensorsMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensors_main)
        val lyAirsensor =
            findViewById<LinearLayout>(R.id.layout_button_lucht_module_activity_sensor)
        val lyWindsensor =
            findViewById<LinearLayout>(R.id.layout_button_wind_module_activity_sensor)
        val lyGassensor = findViewById<LinearLayout>(R.id.layout_button_gas_module_activity_sensor)
        val lyBodemsensor =
            findViewById<LinearLayout>(R.id.layout_button_bodem_module_activity_sensor)
        val lyMainactivty = findViewById<LinearLayout>(R.id.layout_main_activity)

        lyAirsensor.setOnClickListener {
            val intent = Intent(this, AirSensorModuleActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
        lyWindsensor.setOnClickListener {
            val intent = Intent(this, windModule::class.java)
            // start your next activity
            startActivity(intent)
        }
        lyGassensor.setOnClickListener {
            val intent = Intent(this, GasActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        lyBodemsensor.setOnClickListener {
            val intent = Intent(this, SoilActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        lyMainactivty.setOnClickListener {
            val intent = Intent(this, akker_view::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}