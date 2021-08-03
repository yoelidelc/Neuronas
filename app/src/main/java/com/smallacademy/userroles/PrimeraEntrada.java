package com.smallacademy.userroles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import io.grpc.Context;

public class PrimeraEntrada extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_entrada);
    }

    public void irIniciar(View view){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void irRegistrarse(View view){
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    public void inicializarElementos(){

    }
}