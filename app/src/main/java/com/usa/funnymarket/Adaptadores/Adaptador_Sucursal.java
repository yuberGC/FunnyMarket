package com.usa.funnymarket.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.usa.funnymarket.R;
import com.usa.funnymarket.actividades.MapsActivity;
import com.usa.funnymarket.entidades.Entidad_Sucursal;

import java.util.ArrayList;

public class Adaptador_Sucursal extends RecyclerView.Adapter<Adaptador_Sucursal.SucursalViewHolder> {
    ArrayList<Entidad_Sucursal> listaSucursales;


    public Adaptador_Sucursal(ArrayList<Entidad_Sucursal> lista_Sucursales){
        listaSucursales = lista_Sucursales;
    }


    @NonNull
    @Override
    public SucursalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_sucursales,null,
                false);
        return new SucursalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SucursalViewHolder holder, int position) {
        holder.tv_nombre.setText(listaSucursales.get(position).getNombre());
        holder.tv_direccion.setText(listaSucursales.get(position).getDireccion());
        holder.tv_telefono.setText(listaSucursales.get(position).getTelefono());
        holder.tv_latitud.setText(listaSucursales.get(position).getLatitud());
        holder.tv_longitud.setText(listaSucursales.get(position).getLongitud());
    }

    @Override
    public int getItemCount() {
        return listaSucursales.size();

    }

    public class SucursalViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nombre,tv_direccion,tv_telefono,tv_latitud,tv_longitud;

        public SucursalViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.Nombre_Sucursal);
            tv_direccion = itemView.findViewById(R.id.Direccion_Sucursal);
            tv_telefono = itemView.findViewById(R.id.Telefono_Sucursal);
            tv_latitud = itemView.findViewById(R.id.Latitud_Sucursal);
            tv_longitud = itemView.findViewById(R.id.Longitud_Sucursal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent =new Intent(context, MapsActivity.class);
                    intent.putExtra("ID",listaSucursales.get(getAdapterPosition()).getId());
                    intent.putExtra("nombre",listaSucursales.get(getAdapterPosition()).getNombre());
                    intent.putExtra("latitud",listaSucursales.get(getAdapterPosition()).getLatitud());
                    intent.putExtra("longitud",listaSucursales.get(getAdapterPosition()).getLongitud());
                    context.startActivity(intent);
                }
            });
        }
    }
}
