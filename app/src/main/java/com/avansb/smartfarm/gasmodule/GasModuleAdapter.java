package com.avansb.smartfarm.gasmodule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avansb.smartfarm.R;

import java.util.ArrayList;

public class GasModuleAdapter extends RecyclerView.Adapter <GasModuleAdapter.GasModuleViewHolder> {

    public static ArrayList<GasModuleModel> mGasModuleModels;

    public static class GasModuleViewHolder extends RecyclerView.ViewHolder {

        public TextView ppmWaarde, moduleNaam, moduleDatum;

        public GasModuleViewHolder(@NonNull View cardView) {
            super(cardView);
            ppmWaarde = cardView.findViewById(R.id.gasModulePPMwaarde);
            moduleNaam = cardView.findViewById(R.id.gasModuleNaam);
            moduleDatum = cardView.findViewById(R.id.gasModuleDatum);
        }
    }

    public GasModuleAdapter(ArrayList<GasModuleModel> gasModuleLijst) {
        mGasModuleModels = gasModuleLijst;
    }

    @NonNull
    @Override
    public GasModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gas_module_card_view, parent, false);
        GasModuleViewHolder gmvh = new GasModuleViewHolder(v);
        return gmvh;
    }

    @Override
    public void onBindViewHolder(@NonNull GasModuleViewHolder holder, int position) {
        GasModuleModel row = mGasModuleModels.get(position);

        holder.ppmWaarde.setText(row.ppmWaarde);
        holder.moduleNaam.setText(row.moduleNaam);
        holder.moduleDatum.setText(row.moduleDatum);
    }

    @Override
    public int getItemCount() {
        return mGasModuleModels.size();
    }

}