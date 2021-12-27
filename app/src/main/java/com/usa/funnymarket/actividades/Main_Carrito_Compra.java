package com.usa.funnymarket.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.usa.funnymarket.R;

public class Main_Carrito_Compra extends AppCompatActivity {
    private int[] valores ={0,0,0};
    private Double precioArbol = 500000.0,precioCalabaza = 45000.0,precioVela = 15000.0,precioTotal = 0.0;
    private TextView tvTotalA,tvTotalC,tvCanA,tvCanC,tvTotal;
    private LinearLayout lyArbol,lyCala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_carrito_compra);

        tvTotalA = (TextView) findViewById(R.id.txtPrecioArbol);
        tvTotalC = (TextView) findViewById(R.id.txtPrecioCala);
        tvCanA   = (TextView) findViewById(R.id.txtCantidadArbol);
        tvCanC   = (TextView) findViewById(R.id.txtCantidadCala);
        tvTotal  = (TextView) findViewById(R.id.txtTotalCompra);
        lyArbol  = (LinearLayout) findViewById(R.id.ly_Arbol);
        lyCala   = (LinearLayout) findViewById(R.id.lyCalabaza);

        valores = getIntent().getIntArrayExtra("llave");
        if (valores[0]==0){
            lyArbol.setVisibility(View.INVISIBLE);
        }else{
            lyArbol.setVisibility(View.VISIBLE);
        }

        if(valores[1]==0){
            lyCala.setVisibility(View.INVISIBLE);
        }else{
            lyCala.setVisibility(View.VISIBLE);
        }
        calcular();



    }

    public void masArbol (View view){
        valores[0] += 1;
        tvCanA.setText(String.valueOf(valores[0]));
        calcular();
    }
    public void menosArbol (View view){
        if (valores[0]>0){
            valores[0] -= 1;
            tvCanA.setText(String.valueOf(valores[0]));
            calcular();
        }
    }
    public void masCala (View view){
        valores[1] += 1;
        tvCanA.setText(String.valueOf(valores[1]));
        calcular();
    }
    public void menosCala (View view){
        if (valores[1]>0){
            valores[1] -= 1;
            tvCanA.setText(String.valueOf(valores[1]));
            calcular();
        }
    }

    public void calcular (){
        precioTotal= precioArbol * valores[0] + precioCalabaza * valores[1];
        tvTotalA.setText(String.valueOf(precioArbol * valores[0]));
        tvTotalC.setText(String.valueOf(precioCalabaza * valores[1]));
        tvTotal.setText(String.valueOf(precioTotal));
        tvCanA.setText(String.valueOf(valores[0]));
        tvCanC.setText(String.valueOf(valores[1]));
    }


    public void compra(View view){
        Toast.makeText(getApplicationContext(),"se realizo una compra con un valor de: "
                +String.valueOf(precioTotal),Toast.LENGTH_SHORT).show();
    }

    //botones barra inferior
    public void btnHome(View view){
        Intent intent = new Intent(this,MainActivity.class);

        finish();
    }

    public void lyMaps_(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
        finish();
    }
    public void lySupport(View view){
        Toast.makeText(getApplicationContext(), "proximamente mas Soporte", Toast.LENGTH_SHORT).show();
    }
    public void lyProfile(View view){
        Toast.makeText(getApplicationContext(), "proximamente mas Perfil", Toast.LENGTH_SHORT).show();
    }
}