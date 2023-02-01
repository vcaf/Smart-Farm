package com.avansb.smartfarm.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.R
import com.avansb.smartfarm.model.Crops
import com.bumptech.glide.Glide

class CropAdapter(
    val context: Context,
    private val cropList: ArrayList<Crops>,
    private val itemClickListener: (Crops, Int) -> Unit): RecyclerView.Adapter<CropAdapter.CropViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CropViewHolder {
        return CropViewHolder(context, LayoutInflater.from(parent.context).inflate(R.layout.cropcard,parent,false))
    }

    override fun onBindViewHolder(holder: CropViewHolder, position: Int) {
    holder.bindView(cropList[position],position,itemClickListener)
    }

    override fun getItemCount() = cropList.size

    class CropViewHolder(val context: Context, view: View):RecyclerView.ViewHolder(view) {

        fun bindView(crop: Crops, selectedPosition: Int, itemClickListener: (Crops, Int) -> Unit) {
            val cropImg = itemView.findViewById<ImageView>(R.id.crd_img_crop)
            val cropNm = itemView.findViewById<TextView>(R.id.crd_tv_cropname)
            val cropLtn = itemView.findViewById<TextView>(R.id.crd_tv_croplatin)
            val cropImgUrl = crop.cropImgUrl

            try {
                cropNm.text = crop.cropName
                cropLtn.text = crop.cropLatin
                Glide.with(itemView)
                        .load(cropImgUrl)
                        .placeholder(R.drawable.fruit)
                        .fitCenter()
                        .into(cropImg)

            }catch (e: Exception){

            }
                itemView.setOnClickListener{itemClickListener(crop,selectedPosition)}
        }
    }
}


