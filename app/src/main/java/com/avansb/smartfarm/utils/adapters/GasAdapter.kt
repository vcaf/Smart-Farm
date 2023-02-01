package com.avansb.smartfarm.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avansb.smartfarm.R
import com.avansb.smartfarm.model.GasModule

class GasAdapter(
    val context: Context,
    private val gasList: ArrayList<GasModule>,
    private val itemClickListener: (GasModule, Int) -> Unit
): RecyclerView.Adapter<GasAdapter.GasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GasViewHolder {
        return GasViewHolder(context, LayoutInflater.from(parent.context).inflate(R.layout.gas_module_card_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GasViewHolder, position: Int) {
        holder.bindView(gasList[position], position, itemClickListener)
    }

    override fun getItemCount() = gasList.size

    class GasViewHolder(val context: Context, view: View): RecyclerView.ViewHolder(view) {

        fun bindView(gas: GasModule, selectedPosition: Int, itemClickListener: (GasModule, Int) -> Unit) {
           val ppmWaarde = itemView.findViewById<TextView>(R.id.gasModulePPMwaarde)
           val moduleNaam = itemView.findViewById<TextView>(R.id.gasModuleNaam)
           val moduleDatum = itemView.findViewById<TextView>(R.id.gasModuleDatum)
            moduleNaam.text = gas.moduleNaam
            moduleDatum.text = gas.moduleTimestamp
            ppmWaarde.text = gas.moduleWaarde.toString()


            itemView.setOnClickListener{itemClickListener(gas, selectedPosition)}
        }
    }
}

