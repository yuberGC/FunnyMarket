package com.usa.funnymarket.productos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.usa.funnymarket.R;

public class MainActivityProductosHallowen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_productos_hallowen);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Funny Market");
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_market_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}