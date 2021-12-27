package com.usa.funnymarket.base_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Base_Datos extends SQLiteOpenHelper {
    private static final int Data_Version=1;
    private static final String Nombre_Data="location";
    public static final String Tabla_nombre="tabla_location";

    public Base_Datos(@Nullable Context context) {
        super(context, Nombre_Data, null,Data_Version);

    }

    @Override
    public void onCreate(SQLiteDatabase baseDatos) {
        baseDatos.execSQL(" CREATE TABLE "+Tabla_nombre+"(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "direccion TEXT NOT NULL," +
                "latitud TEXT NOT NULL," +
                "longitud TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
