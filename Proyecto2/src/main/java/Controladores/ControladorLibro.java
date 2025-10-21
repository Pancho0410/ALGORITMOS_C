package Controladores;

import Modelos.Libro;
import java.util.Scanner;

public class ControladorLibro {

    public Libro[] libros;
    public Scanner l;
    public static int id_actual;

    public ControladorLibro() {
        this.libros = new Libro[10];
        this.l = new Scanner(System.in);
        this.id_actual = 1;
    }

    public void Registro() {
        System.out.println("--------REGISTRO DE DATOS PARA LIBRO--------");
        System.out.println("Ingrese el titulo del libro");
        String titulo = l.nextLine();
        System.out.println("Ingrese el autor");
        String autor = l.nextLine();
        System.out.println("Ingrese la categoria del libro");
        String categoria = l.nextLine();

        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = new Libro(id_actual, titulo, autor, categoria);
                break;
            }
        }
        id_actual++;
        System.out.println("!!!-- LIBRO REGISTRADO CORRECTAMENTE --!!!");
    }

    public void RegistroEstado() {
        System.out.println("--------REGISTRO DE DATOS PARA LIBRO--------");
        System.out.println("Ingrese el titulo del libro");
        String titulo = l.nextLine();
        System.out.println("Ingrese el autor");
        String autor = l.nextLine();
        System.out.println("Ingrese la categoria del libro");
        String categoria = l.nextLine();
        System.out.println("Ingrese el estado del libro");
        String estado = l.nextLine();

        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = new Libro(id_actual, titulo, autor, categoria, estado);
                break;
            }
        }
        id_actual++;
        System.out.println("!!!-- LIBRO CON ESTADO REGISTRADO CORRECTAMENTE --!!!");
    }

    public void ListarLibros() {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                System.out.println("----------- LIBRO: " + (i + 1) + " -----------");
                System.out.println("CODIGO: " + libros[i].codigo);
                System.out.println("Titulo del libro: " + libros[i].titulo);
                System.out.println("Autor: " + libros[i].autor);
                System.out.println("Categoria: " + libros[i].categoria);
                System.out.println("Estado: " + libros[i].estado);
            }
        }
    }

    public void ListarLibro(String dato, int codigo, int opcion) {
        int indice = -1; //Representa que no existe
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                if (opcion == 1 && libros[i].codigo == codigo) {                //POR CODIGO
                    indice = i;
                    break;
                } else if (opcion == 2 && libros[i].titulo.equalsIgnoreCase(dato)) {      //POR TITULO
                    indice = i;
                    break;
                } else if (opcion == 3 && libros[i].autor.equalsIgnoreCase(dato)) {       //POR AUTOR
                    indice = i;
                    break;
                } else if (opcion == 4 && libros[i].categoria.equalsIgnoreCase(dato)) {   //POR CATEGORIA
                    indice = i;
                    break;
                }
            }
        }
        if (indice != -1) {
            System.out.println("----------- LIBRO ENCONTRADO -----------");
            System.out.println("CODIGO: " + libros[indice].codigo);
            System.out.println("Titulo del libro: " + libros[indice].titulo);
            System.out.println("Autor: " + libros[indice].autor);
            System.out.println("Categoria: " + libros[indice].categoria);
            System.out.println("Estado: " + libros[indice].estado);
        } else {
            System.out.println("----------- !!! EL LIBRO NO FUE ENCONTRADO !!! -----------");
        }
    }

    public void EliminarLibro() {
        boolean eliminado = false;
        System.out.println("--------ELIMINACION DE LIBRO--------");
        System.out.println("Ingrese el codigo del libro a eliminar");
        int codigo = l.nextInt();
        l.nextLine();
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                if(libros[i].codigo == codigo){
                    libros[i] = null;
                    eliminado = true;
                    break;
                }
            }
        }
        if(eliminado){
            System.out.println("!!!-- LIBRO ELIMINADO CORRECTAMENTE --!!!");
        } else {
            System.out.println("----------- !!! EL LIBRO NO FUE ENCONTRADO POR LO QUE NO SE ELIMINO NADA !!! -----------");
        }
    }

}
