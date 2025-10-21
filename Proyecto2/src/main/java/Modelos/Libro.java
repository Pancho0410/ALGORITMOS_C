
package Modelos;


public class Libro {
    
    public int codigo;
    public String titulo;
    public String autor;
    public String categoria;
    public String estado;

    public Libro(int codigo, String titulo, String autor, String categoria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.estado = "disponible";
    }

    public Libro(int codigo, String titulo, String autor, String categoria, String estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.estado = estado;
    }

}
