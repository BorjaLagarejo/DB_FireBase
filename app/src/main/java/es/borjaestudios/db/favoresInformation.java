package es.borjaestudios.db;

/**
 * Created by Pestar on 01/03/2018.
 */

public class favoresInformation {

    private String edad;
    private String nombre;

    public favoresInformation() {}

    public favoresInformation(String edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEdad() {return edad;}

    public void setEdad(String edad) {this.edad = edad;}
}
