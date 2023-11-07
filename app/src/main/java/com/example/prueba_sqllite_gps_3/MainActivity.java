package com.example.prueba_sqllite_gps_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void listaPrincipal(View view){
        Intent i = new Intent(this, listaPrincipal.class);
        startActivity(i);
    }
    public void localGPS(View view){
        Intent i = new Intent(this, localGPS.class);
        startActivity(i);
    }
}