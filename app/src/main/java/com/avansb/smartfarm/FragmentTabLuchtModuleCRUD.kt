package com.avansb.smartfarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentTabLuchtModuleCRUD : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.activity_fragment_tab_lucht_module_c_r_u_d, container, false)
        return inflate
    }
}