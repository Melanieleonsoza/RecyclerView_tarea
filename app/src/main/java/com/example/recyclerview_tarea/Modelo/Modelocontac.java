package com.example.recyclerview_tarea.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Modelocontac {
    private String firstName;
    private String lastName;
    private String email;
   private String username;
    private String phone;
    private String maidenName;
    private String image;

    public Modelocontac(JSONObject a) throws JSONException {
        firstName = a.getString("firstName").toString() ;
        lastName = a.getString("lastName").toString() ;
        email = a.getString("email").toString() ;
        username = a.getString("username").toString() ;
        phone = a.getString("phone").toString() ;
        maidenName = a.getString("maidenName").toString() ;
        image = a.getString("image").toString() ;

    }
    public static ArrayList<Modelocontac> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Modelocontac> modelocontac = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            modelocontac.add(new Modelocontac(datos.getJSONObject(i)));
        }
        return modelocontac;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
