
package Modelos;
import java.time.LocalDate;

public class Prestamo {
    public int id_prestamo;
    public int id_usuario;
    public int codigo_libro;
    public int multa;
    public LocalDate fecha_prestamo;
    public LocalDate fecha_devolucion;
    public LocalDate fecha_final;
    public boolean estado;

    public Prestamo(int id_prestamo, int id_usuario, int codigo_libro, LocalDate fecha_prestamo, LocalDate fecha_devolucion) {
        this.id_prestamo = id_prestamo;
        this.id_usuario = id_usuario;
        this.codigo_libro = codigo_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.estado = true;  //True indica que el prestamos esta activo
        this.multa = 0;
        this.fecha_final = null;
    }
    
    
    
    
}
