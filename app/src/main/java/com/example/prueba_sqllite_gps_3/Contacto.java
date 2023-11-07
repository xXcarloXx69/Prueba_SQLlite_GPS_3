package com.example.prueba_sqllite_gps_3;

public class Contacto {
    int id;
    String nombre;
    String precio;
    String existencias;
    String local;
    public Contacto(){
    }
    public Contacto( String nombre, String precio, String existencias, String local){
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.local = local;
    }
    public Contacto( int id,String nombre, String precio, String existencias, String local){
        this.id=id;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.local = local;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getPrecio(){
        return precio;
    }
    public void setPrecio(String apellido){
        this.precio = precio;
    }
    public String getExistencias(){
        return existencias;
    }
    public void setExistencias(String email){
        this.existencias = existencias;
    }
    public String getLocal(){
        return local;
    }
    public void setLocal(String telefono){
        this.local = local;
    }
}
