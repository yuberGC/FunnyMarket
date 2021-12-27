package com.usa.funnymarket.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.usa.funnymarket.Adaptadores.Adaptador_Sucursal;
import com.usa.funnymarket.R;
import com.usa.funnymarket.base_datos.DB_Sucursal;
import com.usa.funnymarket.entidades.Entidad_Sucursal;
import com.usa.funnymarket.modelo.MySingleton;
import com.usa.funnymarket.servicios_web.Servicios_Web;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main_Ubicaciones extends AppCompatActivity {
    int[] valores ={0,0,0};
    ArrayList<Entidad_Sucursal> sucursales =new ArrayList<>();
    RecyclerView rvSucursales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ubicaciones);
        rvSucursales = (RecyclerView) findViewById(R.id.RW_Lista_Sucursales);
        rvSucursales.setLayoutManager(new LinearLayoutManager(this));

        getSucursalesApex();

    }

    public void getSucursalesApex (){
        String url = Servicios_Web.Get_productos;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Entidad_Sucursal sucursal =null;
                            JSONArray arraySucursales = response.getJSONArray("items");
                            JSONObject objeto = null;
                            for (int i=0;i<arraySucursales.length();i++){
                                objeto =arraySucursales.getJSONObject(i);
                                int id = objeto.getInt("id");
                                String nombre =objeto.getString(("nombre"));
                                String direccion =objeto.getString(("direccion"));
                                String telefono =objeto.getString(("telefono"));
                                String latitud =objeto.getString(("latitud"));
                                String longitud =objeto.getString(("longitud"));

                                sucursal = new Entidad_Sucursal(id,nombre,direccion,telefono,latitud,longitud);
                                sucursales.add(sucursal);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Adaptador_Sucursal adapter =new Adaptador_Sucursal(sucursales);
                        rvSucursales.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }


    //botones barra inferior
    public void btnCarrito(View view){
        Intent intent = new Intent(this,Main_Carrito_Compra.class);
        intent.putExtra("llave",valores);
        startActivity(intent);
        finish();
    }
    public void lyProfile(View view){
        Toast.makeText(getApplicationContext(), "proximamente mas Perfil", Toast.LENGTH_SHORT).show();
    }
    public void lyHome(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("llave",valores);
        finish();
    }
    public void lySupport(View view){
        Toast.makeText(getApplicationContext(), "proximamente mas Soporte", Toast.LENGTH_SHORT).show();
    }
}