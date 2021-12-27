package com.usa.funnymarket.operacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.usa.funnymarket.R;
import com.usa.funnymarket.base_datos.DB_Sucursal;

public class Agregar_Sucursal extends AppCompatActivity {

    EditText et_nombre,et_telefono,et_direccion,et_latitud,et_longitud;
    String GeoPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_sucursal);

        et_nombre = findViewById(R.id.ET_Nombre);
        et_direccion=findViewById(R.id.ET_Direccion);
        et_telefono =findViewById(R.id.ET_telefono);
        et_latitud = findViewById(R.id.ET_Latitud);
        et_longitud= findViewById(R.id.ET_Longitud);
    }

    public void Guardar_Sucursal(View view){
        if(et_nombre.getText().toString().equals("") || et_direccion.getText().toString().equals("")||
            et_telefono.getText().toString().equals("")||et_latitud.getText().toString().equals("")||
            et_longitud.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Todos los campos son obligatorios"
                    ,Toast.LENGTH_SHORT).show();
        }else {
            DB_Sucursal bd_sucursal = new DB_Sucursal(Agregar_Sucursal.this);
            Long id = bd_sucursal.insert_sucursal(
                    et_nombre.getText().toString(),
                    et_telefono.getText().toString(),
                    et_direccion.getText().toString(),
                    et_latitud.getText().toString(),
                    et_longitud.getText().toString());
                    limpiar_campos();
            if (id > 0) {
                Toast.makeText(getApplicationContext(), "Se guardo sucursal con exito"
                        , Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Error al Guardar", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void limpiar_campos(){
        et_nombre.setText("");
        et_direccion.setText("");
        et_telefono.setText("");
        et_latitud.setText("");
        et_longitud.setText("");
    }
}