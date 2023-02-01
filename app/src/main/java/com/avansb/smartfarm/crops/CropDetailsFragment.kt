package com.avansb.smartfarm.crops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.avansb.smartfarm.R
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CropDetailsFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.crop_details_fragment, container, false)
        val tv_crpNm = view.findViewById<TextView>(R.id.tv_crp_dtl_name)
        val tv_crpLtn = view.findViewById<TextView>(R.id.tv_crp_dtl_ltn)
        val tv_crpStrt = view.findViewById<TextView>(R.id.tv_crp_dtl_strt)
        val tv_crpEnd = view.findViewById<TextView>(R.id.tv_crp_dtl_end)
        val tv_crpXpc = view.findViewById<TextView>(R.id.tv_crp_dtl_xpc)
        val tv_crpFld = view.findViewById<TextView>(R.id.tv_crp_dtl_fld)
        val iv_crpImg = view.findViewById<ImageView>(R.id.iv_crpdtl_img)


        val id = arguments?.getInt("id")
        val cropId = arguments?.getString("cropid")
        val cropName = arguments?.getString("name")
        val cropLatin = arguments?.getString("latin")
        val cropStart = arguments?.getString("start")
        val cropEnd = arguments?.getString("end")
        val cropYield = arguments?.getString("yield")
        val cropUrl = arguments?.getString("url")
        val fieldId = arguments?.getString("field")

        tv_crpNm.text = cropName
        tv_crpLtn.text = cropLatin
        tv_crpStrt.text = cropStart
        tv_crpEnd.text = cropEnd
        tv_crpXpc.text = cropYield
        tv_crpFld.text = fieldId
        Glide.with(view)
            .load(cropUrl)
            .into(iv_crpImg)

        val btnCropstate = view.findViewById<Button>(R.id.btn_cropstate)

        btnCropstate.setOnClickListener {
            dismiss()
            val bundle = Bundle()
            bundle.putString("cropid", cropId)
            bundle.putString("name", cropName)
            val cropStateFragment = CropStateFragment()
            cropStateFragment.arguments = bundle
            cropStateFragment.show(parentFragmentManager,"cropStateFragment")

        }
        return view
    }

}


