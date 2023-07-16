package com.example.recyclerview_tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.recyclerview_tarea.Adaptador.AdaptadorContacto;
import com.example.recyclerview_tarea.Modelo.Modelocontac;
import com.example.recyclerview_tarea.WebService.Asynchtask;
import com.example.recyclerview_tarea.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {
    private ListView lstOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url= "https://dummyjson.com/users";

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(url,datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

        //VISTA
        lstOp = (ListView) findViewById(R.id.lstListaUsuario);

        //Inicializacion del evento Onclick
        lstOp.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Modelocontac modelocontac=(Modelocontac) adapterView.getItemAtPosition(i);

        Intent intent=new Intent(MainActivity.this, detallecontac.class);

        Bundle bundle=new Bundle();
        bundle.putString("firstName",modelocontac.getFirstName().toString());
        bundle.putString("lastName",modelocontac.getLastName().toString());
        bundle.putString("email",modelocontac.getEmail().toString());
        bundle.putString("phone",modelocontac.getPhone().toString());
        bundle.putString("username",modelocontac.getUsername().toString());
        bundle.putString("maidenName",modelocontac.getMaidenName().toString());
        bundle.putString("image",modelocontac.getImage().toString());

        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject jsonres = new JSONObject(result);
        JSONArray JSONlistacontac = jsonres.getJSONArray("users");
        ArrayList<Modelocontac> lstcontac = Modelocontac.JsonObjectsBuild(JSONlistacontac);
        AdaptadorContacto adaptadorcontac = new AdaptadorContacto(this,lstcontac);
        lstOp.setAdapter(adaptadorcontac);

    }
}