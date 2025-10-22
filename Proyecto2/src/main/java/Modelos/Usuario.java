
package Modelos;

import java.util.Date;


public class Usuario {
    public int id;
    public String nombre;
    public int carnet;
    public int telefono;
    public String email;
    public int prestamos;

    public Usuario(int id, String nombre, int carnet, int telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.carnet = carnet;
        this.telefono = telefono;
        this.email = email;
        this.prestamos = 0;
    }
    
    
}
