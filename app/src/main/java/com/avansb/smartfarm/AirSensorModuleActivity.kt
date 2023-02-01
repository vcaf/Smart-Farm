package com.avansb.smartfarm

import com.avansb.smartfarm.utils.adapters.MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class AirSensorModuleActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_sensor_module)
        tabLayout = findViewById(R.id.tabLayout_AirSensorModuleActivity)
        viewPager = findViewById(R.id.viewPager_AirSensorModuleActivity)
        tabLayout.addTab(tabLayout.newTab().setText("Overview"))
        tabLayout.addTab(tabLayout.newTab().setText("Data"))
        tabLayout.addTab(tabLayout.newTab().setText("Modules"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager,
            tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}