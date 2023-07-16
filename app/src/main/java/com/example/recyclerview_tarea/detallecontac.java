package com.example.recyclerview_tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detallecontac extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallecontac);
        Bundle bundle= this.getIntent().getExtras();
        TextView lblfirstName = (TextView) findViewById(R.id.txtemail1);
        lblfirstName.setText(bundle.getString("email"));
        TextView lbldatos = (TextView) findViewById(R.id.txtdatos);
        lbldatos.setText(bundle.getString("firstName")+" "+bundle.getString("lastName"));
        TextView lblphone = (TextView) findViewById(R.id.txtmovil);
        lblphone.setText(bundle.getString("phone"));
        TextView lblmaidenName = (TextView) findViewById(R.id.txtalias);
        lblmaidenName.setText(bundle.getString("maidenName"));
        TextView lblusername = (TextView) findViewById(R.id.txtemployer);
        lblusername.setText(bundle.getString("username"));
        ImageView imageView = (ImageView) findViewById(R.id.imagUser1);
        Glide.with(this).load(bundle.getString("image")).into(imageView);

    }
}