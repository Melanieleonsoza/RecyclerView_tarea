package com.example.recyclerview_tarea.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview_tarea.Modelo.Modelocontac;
import com.example.recyclerview_tarea.R;

import java.util.ArrayList;

public class AdaptadorContacto extends ArrayAdapter<Modelocontac> {

    public AdaptadorContacto(Context context, ArrayList<Modelocontac> datos) {
        super(context, R.layout.lyitemcontacto,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemcontacto, null);

        TextView firstName = (TextView) item.findViewById(R.id.lblnombre);
        firstName.setText(getItem(position).getFirstName()+" "+ getItem(position).getLastName());

        TextView email = (TextView) item.findViewById(R.id.lblmail);
        email.setText(getItem(position).getEmail());

        TextView username = (TextView) item.findViewById(R.id.lblcargo);
        username.setText(getItem(position).getUsername());


        ImageView imageView = (ImageView) item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext()).load(getItem(position).getImage()).into(imageView);
        return (item);

    }
}
