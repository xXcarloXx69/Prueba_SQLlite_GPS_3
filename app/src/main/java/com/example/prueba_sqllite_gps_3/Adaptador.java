package com.example.prueba_sqllite_gps_3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    ArrayList<com.example.prueba_sqllite_gps_3.Contacto> lista;
    daoContacto dao;
    com.example.prueba_sqllite_gps_3.Contacto c;
    Activity a;
    int id = 0;

    public Adaptador(Activity a, ArrayList<Contacto> lista, daoContacto dao) {
        this.lista = lista;
        this.a = a;
        this.dao = dao;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public int getCount() {
        return lista.size();
    }
    @Override
    public Object getItem(int i) {
        c = lista.get(i);
        return null;
    }
    @Override
    public long getItemId(int i) {
        c = lista.get(i);
        return c.getId();
    }
    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item, null);
        }

        c = lista.get(posicion);

        TextView nombre = v.findViewById(R.id.txt_producto_item);
        TextView precio = v.findViewById(R.id.txt_precio_item);
        TextView existencias = v.findViewById(R.id.txt_existencias_item);
        TextView local = v.findViewById(R.id.txt_local_item);
        Button editar = v.findViewById(R.id.btn_editar_item);
        Button eliminar = v.findViewById(R.id.btn_eliminar_item);
        nombre.setText(c.getNombre());
        precio.setText(c.getPrecio());
        existencias.setText(c.getExistencias());
        local.setText(c.getLocal());
        editar.setTag(posicion);
        eliminar.setTag(posicion);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = Integer.parseInt(view.getTag().toString());
                final Dialog dialog = new Dialog(a);
                dialog.setTitle("Editar Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText nombre = dialog.findViewById(R.id.et_nombreproducto_dialogo);
                final EditText precio = dialog.findViewById(R.id.et_precio_dialogo);
                final EditText existencias = dialog.findViewById(R.id.et_existencias_dialogo);
                final EditText local = dialog.findViewById(R.id.et_local_dialogo);
                Button guardar = dialog.findViewById(R.id.btn_agregar_dialogo);
                Button cancelar = dialog.findViewById(R.id.btn_cancelar_dialogo);
                c = lista.get(pos);
                setId(c.getId());
                nombre.setText(c.getNombre());
                precio.setText(c.getPrecio());
                existencias.setText(c.getExistencias());
                local.setText(c.getLocal());
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            c = new Contacto(getId(), nombre.getText().toString(),
                                    precio.getText().toString(),
                                    existencias.getText().toString(),
                                    local.getText().toString());
                            dao.editar(c);
                            lista = dao.verTodo();
                            notifyDataSetChanged();
                            dialog.dismiss();
                        } catch (Exception e) {
                            Toast.makeText(a, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        dialog.dismiss();
                    }
                });
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int pos=Integer.parseInt(view.getTag().toString());
                c=lista.get(posicion);
                setId(c.getId());
                AlertDialog.Builder del = new AlertDialog.Builder(a);
                del.setMessage("estas seguro de eliminar");
                del.setCancelable(false);
                del.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dao.eliminar(getId());
                        lista=dao.verTodo();
                        notifyDataSetChanged();
                    }
                });
                del.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                del.show();
            }
        });
        return v;
    }
}
