package com.avansb.smartfarm.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.R
import com.avansb.smartfarm.model.SoilData

class SoilAdapter(
    val context: Context,
    private val soilList: ArrayList<SoilData>,
    private val itemClickListener: (SoilData, Int) -> Unit): RecyclerView.Adapter<SoilAdapter.SoilViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoilViewHolder {
        return SoilViewHolder(
            context,
            LayoutInflater.from(parent.context).inflate(R.layout.soilcard, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SoilViewHolder, position: Int) {
        holder.bindView(soilList[position],position,itemClickListener)
    }

    override fun getItemCount() = soilList.size

    class SoilViewHolder(val context: Context, view: View): RecyclerView.ViewHolder(view) {

        fun bindView(soilData: SoilData, selectedPosition: Int, itemClickListener: (SoilData, Int) -> Unit) {
            val soilTitle = itemView.findViewById<TextView>(R.id.crd_tv_soilmodule_ttl)
            val soilId = itemView.findViewById<TextView>(R.id.crd_tv_soilID)
            val soilDate = itemView.findViewById<TextView>(R.id.crd_tv_soilDate)
            val soilValue = itemView.findViewById<TextView>(R.id.crd_tv_soilValue)

            val soilTitleId = "Bv${soilData.id}"
            try {
                soilTitle.text = soilTitleId
                soilId.text = soilData.id.toString()
                soilDate.text = soilData.soilDate
                soilValue.text = soilData.soilValue.toString()

            }catch (e: Exception){
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show()
            }



            itemView.setOnClickListener{itemClickListener(soilData,selectedPosition)}
        }
    }
}


