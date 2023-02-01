package com.avansb.smartfarm.gasmodule;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avansb.smartfarm.R;

import java.util.ArrayList;

public class GasModuleActivity extends AppCompatActivity {

    public static ArrayList<GasModuleModel> gasModuleLijst = new ArrayList<>();

    private RecyclerView gasRecyclerView;
    private GasModuleAdapter gasModuleAdapter;
    private RecyclerView.LayoutManager gasModuleLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_module);


        gasRecyclerView = findViewById(R.id.gasModuleRecyclerView);
        gasRecyclerView.setHasFixedSize(true);

        gasModuleLayoutManager = new LinearLayoutManager(this);
        gasModuleAdapter = new GasModuleAdapter(gasModuleLijst);

        gasRecyclerView.setLayoutManager(gasModuleLayoutManager);
        gasRecyclerView.setAdapter(gasModuleAdapter);

    }
}