package com.usa.funnymarket.actividades;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.usa.funnymarket.R;
import com.usa.funnymarket.base_datos.Base_Datos;
import com.usa.funnymarket.operacion.Agregar_Sucursal;
import com.usa.funnymarket.productos.MainActivityProductosFiesta;
import com.usa.funnymarket.productos.MainActivityProductosHallowen;
import com.usa.funnymarket.productos.MainActivityProductosNavidad;


public class MainActivity extends AppCompatActivity {
    private TextView TVArbol,TvCalabaza,FArbol,FCala;
    private Integer cuenta1,cuenta2,cuenta3;
    private int[] valores ={0,0,0};
    private ImageView imageFArbol, imageFCala;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // verificar o crear base de datos
        Base_Datos dataBase = new Base_Datos(getApplicationContext());
        SQLiteDatabase db = dataBase.getWritableDatabase();


        //mostrar y modificar menu
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Funny Market");
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_market_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //inicializar
        TVArbol = (TextView) findViewById(R.id.txtCantidadArbol);
        TvCalabaza = (TextView) findViewById(R.id.txtCantidadCala);
        FArbol =(TextView) findViewById(R.id.txtFavoritoArbol);
        FCala  =(TextView) findViewById(R.id.txtFavoritoCala);
        imageFArbol=(ImageView) findViewById(R.id.imageFavoritoArbol);
        imageFCala =(ImageView) findViewById(R.id.imageFavoritoCala);
        cuenta1=1;cuenta2=1;cuenta3=1;




    }

    public void arbolFavo (View view){

        if (FArbol.getText().toString().equals("_")){
            FArbol.setText("favorito");
            imageFArbol.setImageResource(R.drawable.corazon_select);

        }else {
            FArbol.setText("_");
            imageFArbol.setImageResource(R.drawable.corazon_no);
        }
    }

    public void calabazaFavo(View view){

        if (FCala.getText().toString().equals("_")){
            FCala.setText("favorito");
            imageFCala.setImageResource(R.drawable.corazon_select);
        }else {
            FCala.setText("_");
            imageFCala.setImageResource(R.drawable.corazon_no);
        }
    }




    public void masArbol (View view){
        cuenta1 = Integer.parseInt(TVArbol.getText().toString());
        cuenta1 += 1;
        TVArbol.setText(String.valueOf(cuenta1));
    }
    public void menosArbol (View view){
        cuenta1 = Integer.parseInt(TVArbol.getText().toString());
        if (cuenta1 > 1) {
            cuenta1 -= 1;
            TVArbol.setText(String.valueOf(cuenta1));
        }
    }

    public void masCala (View view){
        cuenta2 = Integer.parseInt(TvCalabaza.getText().toString());
        cuenta2 += 1;
        TvCalabaza.setText(String.valueOf(cuenta2));
    }
    public void menosCala (View view){
        cuenta2 = Integer.parseInt(TvCalabaza.getText().toString());
        if (cuenta2 > 1) {
            cuenta2 -= 1;
            TvCalabaza.setText(String.valueOf(cuenta2));
        }
    }

    public void agregarArbol (View view){
        valores[0] += cuenta1;
        Toast.makeText(getApplicationContext(),"se agrego "+cuenta1+"  Arbol al carrito",Toast.LENGTH_LONG).show();
        cuenta1 = 1;
        TVArbol.setText(String.valueOf(cuenta1));

    }
    public void agregarCala (View view){
        valores[1] += cuenta2;
        Toast.makeText(getApplicationContext(),"se agrego "+cuenta2+" Calabaza al carrito",Toast.LENGTH_LONG).show();
        cuenta2 = 1;
        TvCalabaza.setText(String.valueOf(cuenta2));
    }


    //botones barra inferior
    public void btnCarrito(View view){
        Intent intent = new Intent(this,Main_Carrito_Compra.class);
        intent.putExtra("llave",valores);
        startActivity(intent);

    }
    public void lyProfile(View view){
        Toast.makeText(getApplicationContext(), "proximamente mas Perfil", Toast.LENGTH_SHORT).show();
    }
    public void lyMaps(View view){
        Intent intent = new Intent(this,Main_Ubicaciones.class);
        intent.putExtra("llave",valores);
        startActivity(intent);
    }
    public void lySupport(View view){
        Toast.makeText(getApplicationContext(), "proximamente mas Soporte", Toast.LENGTH_SHORT).show();
    }



    // para llamar el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_opciones,menu);
        return true;
    }

    //para seleccionar opciones del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idItem = item.getItemId();
        if (idItem == R.id.ProductosNavidad){
            Intent pantallaNavidad = new Intent(this, MainActivityProductosNavidad.class);
            startActivity(pantallaNavidad);
        }
        if(idItem == R.id.ProductosFiesta){
            Intent pantallaFiesta = new Intent(this, MainActivityProductosFiesta.class);
            startActivity(pantallaFiesta);
        }
        if(idItem == R.id.ProductosHallowen){
            Intent pantallaHallowen = new Intent(this, MainActivityProductosHallowen.class);
            startActivity(pantallaHallowen);
        }
        if(idItem == R.id.Agregar_Sucur){
            Intent intent = new Intent(this, Agregar_Sucursal.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}