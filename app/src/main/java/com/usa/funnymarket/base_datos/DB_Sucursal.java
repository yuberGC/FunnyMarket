package com.usa.funnymarket.base_datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.usa.funnymarket.entidades.Entidad_Sucursal;

import java.util.ArrayList;

public class DB_Sucursal extends Base_Datos{
    Context context;


    public DB_Sucursal(@Nullable Context con_text) {
        super(con_text);
        context = con_text;
    }

    public long insert_sucursal(String nombre, String telefono,String direccion,String latitud,String longitud){
        Long id;
        Base_Datos dataBase =new Base_Datos(context);
        SQLiteDatabase DB =dataBase.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("nombre",nombre);
        values.put("telefono",telefono);
        values.put("direccion",direccion);
        values.put("latitud",latitud);
        values.put("longitud",longitud);

        id = DB.insert(Tabla_nombre,null,values);

        return id;
    }
    public ArrayList<Entidad_Sucursal>Llamar_Sucursal(){

        Base_Datos dataBase =new Base_Datos(context);
        SQLiteDatabase DB =dataBase.getWritableDatabase();

        ArrayList<Entidad_Sucursal>lista_Sucursal=new ArrayList<>();
        Entidad_Sucursal  entidadSucursal = null;
        Cursor cursorSucursal = null;

        cursorSucursal =DB.rawQuery("SELECT * FROM "+Tabla_nombre,null);

        if (cursorSucursal.moveToFirst()){
            do{
                entidadSucursal.setId(cursorSucursal.getInt(0));
                entidadSucursal.setNombre(cursorSucursal.getString(1));
                entidadSucursal.setTelefono(cursorSucursal.getString(2));
                entidadSucursal.setDireccion(cursorSucursal.getString(3));
                entidadSucursal.setLatitud(cursorSucursal.getString(4));
                entidadSucursal.setLongitud(cursorSucursal.getString(5));

                lista_Sucursal.add(entidadSucursal);
            }while(cursorSucursal.moveToNext());
        }
        cursorSucursal.close();
        return lista_Sucursal;
    }

    public Entidad_Sucursal Ver_Sucursal(int id){

        Base_Datos dataBase =new Base_Datos(context);
        SQLiteDatabase DB =dataBase.getWritableDatabase();

        Entidad_Sucursal  entidadSucursal = null;
        Cursor cursorSucursal;

        cursorSucursal =DB.rawQuery("SELECT * FROM "+Tabla_nombre+" WHERE id ="+id,null);

        if (cursorSucursal.moveToFirst()) {

            entidadSucursal.setId(cursorSucursal.getInt(0));
            entidadSucursal.setNombre(cursorSucursal.getString(1));
            entidadSucursal.setTelefono(cursorSucursal.getString(2));
            entidadSucursal.setDireccion(cursorSucursal.getString(3));
            entidadSucursal.setLatitud(cursorSucursal.getString(4));
            entidadSucursal.setLongitud(cursorSucursal.getString(5));

        }
        cursorSucursal.close();
        return entidadSucursal;
    }
}
