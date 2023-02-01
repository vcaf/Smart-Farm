package com.avansb.smartfarm.utils.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.R
import com.avansb.smartfarm.model.AirModules

class AirModuleAdapter(var lModulesList: List<AirModules>): RecyclerView.Adapter<AirModuleAdapter.MyViewHolder>()  {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var id: TextView = view.findViewById(R.id.TV_ModId_item_row)
        var humidity: TextView = view.findViewById(R.id.TV_humidity_percent_module_item_row)
        var temperature: TextView = view.findViewById(R.id.TV_temperature_celcius_module_item_row)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val luchtMod = lModulesList[position]
        holder.id.text = luchtMod.air_id
        holder.humidity.text = luchtMod.air_humid.toString()
        holder.temperature.text = luchtMod.air_temp.toString()
    }
    override fun getItemCount(): Int {
        return lModulesList.size
    }
}