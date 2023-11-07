package com.example.prueba_sqllite_gps_3;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listaPrincipal extends AppCompatActivity {
    daoContacto dao;
    Adaptador adaptador;
    ArrayList<Contacto> lista;
    Contacto c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaprincipal);

        dao=new daoContacto(listaPrincipal.this);
        lista=dao.verTodo();
        adaptador=new Adaptador(this,lista,dao);
        ListView list= findViewById(R.id.lista);
        Button insertar= findViewById(R.id.btn_agregar);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        insertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Dialog dialog = new Dialog(listaPrincipal.this);
                dialog.setTitle("Nuevo registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText nombre = dialog.findViewById(R.id.et_nombreproducto_dialogo);
                final EditText precio = dialog.findViewById(R.id.et_precio_dialogo);
                final EditText existencias = dialog.findViewById(R.id.et_existencias_dialogo);
                final EditText local = dialog.findViewById(R.id.et_local_dialogo);
                Button guardar = dialog.findViewById(R.id.btn_agregar_dialogo);
                guardar.setText("Agregar");
                Button cancelar = dialog.findViewById(R.id.btn_cancelar_dialogo);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            c=new Contacto (nombre.getText().toString(),
                                    precio.getText().toString(),
                                    existencias.getText().toString(),
                                    local.getText().toString());
                            dao.insertar(c);
                            lista=dao.verTodo();
                            adaptador.notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(),"error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
