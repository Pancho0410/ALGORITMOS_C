package main.Main;

import Controladores.ControladorUsuario;
import Controladores.ControladorLibro;
import Controladores.ControladorPrestamo;
import java.util.Scanner;

public class Proyecto2 {

    public static ControladorUsuario usuarios = new ControladorUsuario();
    public static ControladorLibro libros = new ControladorLibro();
    public static ControladorPrestamo prestamos = new ControladorPrestamo();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        boolean salir = true;
        Scanner leer = new Scanner(System.in);
        int opcion;
        while (salir) {
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("SISTEMA DE GESTION DE BIBLIOTECA");
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("1) Gestion de libros");
            System.out.println("2) Gestion de usuarios");
            System.out.println("3) Prestamos y devoluciones");
            System.out.println("4) Reportes");
            System.out.println("5) Salir");
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    menuLibro();
                    break;
                case 2:
                    menuUsuario();
                    break;
                case 3:
                    menuPrestamos();
                    break;
                case 4:
                    menuReportes();
                    break;
                case 5:
                    System.out.println("NOS VEMOS!!!!!!");
                    salir = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    public static void menuLibro() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        System.out.println("--------------------------------------");
        System.out.println("MENU DE GESTION DE LIBRO");
        System.out.println("--------------------------------------");
        System.out.println("1) Registrar Libro");
        System.out.println("2) Registrar Libro con estado");
        System.out.println("3) Consultar informacion de un libro (especifico)");
        System.out.println("4) Eliminar libro (especifico)");
        System.out.println("5) Listar todos los libros");
        System.out.println("6) Salir");
        opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                libros.Registro();
                break;
            case 2:
                libros.RegistroEstado();
                break;
            case 3:
                MenuBuscarLibro();
                break;
            case 4:
                libros.EliminarLibro();
                break;
            case 5:
                libros.ListarLibros();
                break;
            case 6:
                return;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public static void MenuBuscarLibro() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        String dato = "";
        int codigo = 0;
        System.out.println("--------------------------------------");
        System.out.println("SUBMENU BUSCAR LIBRO");
        System.out.println("--------------------------------------");
        System.out.println("1) Buscar por codigo");
        System.out.println("2) Buscar por titulo");
        System.out.println("3) Buscar por autor");
        System.out.println("4) Buscar por categoria");
        System.out.println("5) Salir");
        opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el codigo");
                codigo = leer.nextInt();
                leer.nextLine();
                break;
            case 2:
                System.out.println("Ingrese el titulo del libro");
                dato = leer.nextLine();
                break;
            case 3:
                System.out.println("Ingrese el autor del libro");
                dato = leer.nextLine();
                break;
            case 4:
                System.out.println("Ingrese la categoria del libro");
                dato = leer.nextLine();
                break;
            case 5:
                menuLibro();
            default:
                System.out.println("Opcion no valida");
                break;
        }
        libros.ListarLibro(dato, codigo, opcion);
        //menuLibro();
    }

    public static void menuPrestamos() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        System.out.println("--------------------------------------");
        System.out.println("MENU DE PRESTAMOS Y DEVOLUCIONES");
        System.out.println("--------------------------------------");
        System.out.println("1) Prestar libro");
        System.out.println("2) Devolver libro");
        System.out.println("3) Gestion de multas");
        System.out.println("4) Consultar prestamos activos de un usuario");
        System.out.println("5) Listar todos los prestamos activos");
        System.out.println("6) Salir");
        opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                prestamos.Prestamo();
                break;
            case 2:
                prestamos.Devolver();
                break;
            case 3:
                GestionMultas();
                break;
            case 4:
                prestamos.PrestamosActivos();
                break;
            case 5:
                prestamos.ListarPrestasmoActivos();
                break;
            case 6:
                return;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public static void GestionMultas() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        System.out.println("--------------------------------------");
        System.out.println("SUBMENU DE GESTION DE MULTAS");
        System.out.println("--------------------------------------");
        System.out.println("1) Historial de multas pagadas por USUARIO");
        System.out.println("2) Historial de multas pagadas");
        System.out.println("3) Salir");
        opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                prestamos.ConsultarMultas();  // POR ID DE USUARIO
                break;
            case 2:
                prestamos.MultasPagadas();
                break;
            case 3:
                menuPrestamos();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public static void menuUsuario() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        System.out.println("--------------------------------------");
        System.out.println("MENU DE GESTION DE USUARIO");
        System.out.println("--------------------------------------");
        System.out.println("1) Registrar usuario");
        System.out.println("2) Consultar informacion de un usuario (especifico)");
        System.out.println("3) Modificar datos");
        System.out.println("4) Listar todos los usuarios");
        System.out.println("5) Salir");
        opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                usuarios.Registrar();
                break;
            case 2:
                usuarios.ListarUsuario();
                break;
            case 3:
                usuarios.ModificarUsuario();
                break;
            case 4:
                usuarios.Listar();
                break;
            case 5:
                return;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
    
    public static void menuReportes(){
        Scanner leer = new Scanner(System.in);
        int opcion;
        System.out.println("--------------------------------------");
        System.out.println("MENU DE REPORTES");
        System.out.println("--------------------------------------");
        System.out.println("1) Reporte de libros mas prestados");
        System.out.println("2) Reporte de usuarios con prestamos activos");
        System.out.println("3) Libros en la biblioteca por categoria");
        System.out.println("4) Salir");
        opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                break;
            case 2:
                prestamos.ReportePrestamosActivos();
                break;
            case 3:
                libros.ReportePorCategoria();
                break;
            case 4:
                return;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}
