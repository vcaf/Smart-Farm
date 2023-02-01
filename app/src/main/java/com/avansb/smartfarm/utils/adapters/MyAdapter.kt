package com.avansb.smartfarm.utils.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.avansb.smartfarm.FragmentTabLuchtModuleCRUD
import com.avansb.smartfarm.FragmentTabLuchtModuleMain
import com.avansb.smartfarm.FragmentTabLuchtModuleTemHum

@Suppress("DEPRECATION")
internal class MyAdapter(
        var context: Context,
        fm: FragmentManager,
        var totalTabs: Int
) :
        FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentTabLuchtModuleMain()
            }
            1 -> {
                FragmentTabLuchtModuleTemHum()
            }
            2 -> {
                FragmentTabLuchtModuleCRUD()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}