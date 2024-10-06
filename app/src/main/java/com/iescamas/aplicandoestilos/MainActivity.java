package com.iescamas.aplicandoestilos;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

        RadioGroup rg_elecciones;
        RadioButton rb_eleccion1,rb_eleccion2,rb_eleccion3;
        CheckBox cb_estilo1, cb_estilo2;
        TextView txt_info;
        SwitchCompat sw_cambio1, sw_cambio2;
        View lyPrincipal;
        TextView lbl_info1,lbl_info2;

        final String eleccion1_str ="Se cambio el color del texto a rojo";
        final String eleccion2_str ="Se cambio el color del texto a verde";
        final String eleccion3_str ="Se cambio el color del texto a azul";
        final String cb_estilo1_str = "Se cambio el estilo del texto a negrita";
        final String cb_estilo2_str = "Se cambio el estilo del texto a cursiva";
        final String cb_estilo3_str = "Se cambio el estilo del texto a negrita y cursiva";
        final String cb_estilo4_str = "Se cambio el estilo del texto a por defecto";
        final String sw1_cambio1_str = "Se cambio a modo oscuro";
        final String sw1_cambio2_str = "Se cambio a modo dia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lyPrincipal = findViewById(R.id.LayoutPrincipal);
        rg_elecciones = findViewById(R.id.rg_elecciones);
        cb_estilo1 = findViewById(R.id.cb_estilo1);
        cb_estilo2 = findViewById(R.id.cb_estilo2);
        txt_info = findViewById(R.id.txt_Info);
        sw_cambio1 = findViewById(R.id.sw_eleccion1);
        sw_cambio2 = findViewById(R.id.sw_eleccion2);
        lbl_info1 = findViewById(R.id.lbl_info1);
        lbl_info2 = findViewById(R.id.lbl_info2);
        rb_eleccion1 = findViewById(R.id.rb_eleccion1);
        rb_eleccion2 = findViewById(R.id.rb_eleccion2);
        rb_eleccion3 = findViewById(R.id.rb_eleccion3);

        //Comprobamos la eleccion marcada a traves del grupo
        rg_elecciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Condicial mediante el id del boton que se encuentre seleccionado
                if (i == R.id.rb_eleccion1) {
                    txt_info.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.txt_info));
                    mostrarInfo(sw_cambio2.isChecked(), eleccion1_str);
                }
                if (i == R.id.rb_eleccion2) {
                    txt_info.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.txt_info2));
                    mostrarInfo(sw_cambio2.isChecked(), eleccion2_str);
                }
                if (i == R.id.rb_eleccion3) {
                    txt_info.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.txt_info3));
                    mostrarInfo(sw_cambio2.isChecked(), eleccion3_str);
                }
            }
        });

        //Cambiamos el estilo de la letra
        cb_estilo1.setOnClickListener(v->cambioDeEstilo(cb_estilo1,cb_estilo2));
        cb_estilo2.setOnClickListener(v->cambioDeEstilo(cb_estilo1,cb_estilo2));

        //Comprobamos el cambio de estado del switch de modo oscuro

        sw_cambio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){
                    lyPrincipal.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    lbl_info1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    lbl_info2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    cb_estilo1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    cb_estilo2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    sw_cambio1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    sw_cambio2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    rb_eleccion1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    rb_eleccion2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    rb_eleccion3.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    mostrarInfo(sw_cambio2.isChecked(), sw1_cambio1_str);

                }
                else{
                    lyPrincipal.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                    lbl_info1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    lbl_info2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    cb_estilo1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    cb_estilo2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    sw_cambio1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    sw_cambio2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    rb_eleccion1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    rb_eleccion2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    rb_eleccion3.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.black));
                    mostrarInfo(sw_cambio2.isChecked(), sw1_cambio2_str);
                }
            }
        });

        //Comprobamos el cambio de switch de información Log
        sw_cambio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sw_cambio2.setChecked(b);
            }
        });

    }

    //Metodo para cambiar el estilo de la frase
    private void cambioDeEstilo(View v1,View v2){

        CheckBox cb1 = (CheckBox) v1;
        CheckBox cb2 = (CheckBox) v2;

        if (cb1.isChecked() && cb2.isChecked()){
            txt_info.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
            mostrarInfo(sw_cambio2.isChecked(),cb_estilo3_str);

        }
        else if (cb1.isChecked() && !cb2.isChecked()){
            txt_info.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
            mostrarInfo(sw_cambio2.isChecked(),cb_estilo1_str);
        } else if (!cb1.isChecked() && cb2.isChecked()) {
            txt_info.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
            mostrarInfo(sw_cambio2.isChecked(),cb_estilo2_str);
        }
        else {
            txt_info.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
            mostrarInfo(sw_cambio2.isChecked(),cb_estilo4_str);
        }
    }

    private void mostrarInfo(Boolean activo,String mensaje){
        if(activo){
            Log.i("Información",mensaje);
        }
    }



}
