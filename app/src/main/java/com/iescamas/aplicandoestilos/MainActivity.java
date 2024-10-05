package com.iescamas.aplicandoestilos;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        RadioGroup rg_elecciones;
        CheckBox cb_estilo1, cb_estilo2;
        TextView txt_info;
        Switch sw_cambio1, sw_cambio2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_elecciones = findViewById(R.id.rg_elecciones);
        cb_estilo1 = findViewById(R.id.cb_estilo1);
        cb_estilo2 = findViewById(R.id.cb_estilo2);
        txt_info = findViewById(R.id.txt_Info);
        sw_cambio1 = findViewById(R.id.sw_eleccion1);
        sw_cambio2 = findViewById(R.id.sw_eleccion2);

    }
}