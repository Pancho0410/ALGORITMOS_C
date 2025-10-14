package main.Main;

import Controladores.ControladorUsuario;
import java.util.Scanner;

public class Proyecto2 {

    public static ControladorUsuario usuarios = new ControladorUsuario();

    public static void main(String[] args) {

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
            System.out.println("6) Salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    menuUsuario();
                    break;
                case 6:
                    System.out.println("NOS VEMOS!!!!!!");
                    salir = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
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
        
        switch(opcion){
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
}
