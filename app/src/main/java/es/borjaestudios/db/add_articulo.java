package es.borjaestudios.db;

/**
 * Created by Borja on 15/03/2018.
 */

public class add_articulo {

    private String nombre,cantidad;

    public add_articulo() {

    }

    public add_articulo(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCantidad() {return cantidad;}

    public void setCantidad(String cantidad) {this.cantidad = cantidad;}



}
