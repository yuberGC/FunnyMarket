package com.usa.funnymarket.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.style.BulletSpan;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.usa.funnymarket.Adaptadores.Adaptador_Sucursal;
import com.usa.funnymarket.R;
import com.usa.funnymarket.base_datos.DB_Sucursal;
import com.usa.funnymarket.entidades.Entidad_Sucursal;
import com.usa.funnymarket.modelo.MySingleton;
import com.usa.funnymarket.servicios_web.Servicios_Web;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private String nombre_mapa;
    private Double latitud = 0.0;
    private Double longitud = 0.0;
    private GoogleMap mMap;
    Entidad_Sucursal sucursal;
    Integer id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                Toast.makeText(getApplicationContext(),id,Toast.LENGTH_SHORT).show();
            }else{
                id = extras.getInt("ID");
                nombre_mapa = extras.getString("nombre");
                latitud = Double.parseDouble(extras.getString("latitud"));
                longitud = Double.parseDouble(extras.getString("longitud"));
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }


    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng LocationMap = new LatLng( latitud , longitud );
        mMap.addMarker(new MarkerOptions()
                .position(LocationMap)
                .title(nombre_mapa));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LocationMap, 23));


    }
}