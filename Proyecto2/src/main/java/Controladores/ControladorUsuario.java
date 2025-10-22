package Controladores;

import Modelos.Usuario;
import java.util.Scanner;

public class ControladorUsuario {

    public Usuario[] usuarios;
    public Scanner l;
    public static int id_actual;

    public ControladorUsuario() {
        this.usuarios = new Usuario[10];
        this.l = new Scanner(System.in);
        this.id_actual = 1;
    }

    public void Registrar() {
        System.out.println("--------REGISTRO DE DATOS PARA USUARIO--------");
        System.out.println("Ingrese su nombre");
        String nombre = l.nextLine();
        System.out.println("Ingrese su carnet");
        int carnet = l.nextInt();
        System.out.println("Ingrese su telefono");
        int telefono = l.nextInt();
        l.nextLine();
        System.out.println("Ingrese su email");
        String email = l.nextLine();

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = new Usuario(id_actual, nombre, carnet, telefono, email);
                break;
            }
        }
        id_actual++;
        System.out.println("!!!-- USUARIO REGISTRADO CORRECTAMENTE --!!!");
    }

    public void Listar() {    //Lista todos los usaurios
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.println("----------- USUARIO: " + (i + 1) + " -----------");
                System.out.println("ID: " + usuarios[i].id);
                System.out.println("Nombre: " + usuarios[i].nombre);
                System.out.println("Carnet: " + usuarios[i].carnet);
                System.out.println("Telefono: " + usuarios[i].telefono);
                System.out.println("Email: " + usuarios[i].email);
                System.out.println("Libros prestado: " + usuarios[i].prestamos);
            }
        }
    }

    public void ListarUsuario() {  //Lista un usuario en especifico
        System.out.println("Ingrese el ID del usuario a buscar");
        int id = l.nextInt();
        boolean estado = true;
        for (Usuario u : usuarios) {
            if (u != null && u.id == id) {
                System.out.println("----------- USUARIO ENCONTRADO -----------");
                System.out.println("ID: " + u.id);
                System.out.println("Nombre: " + u.nombre);
                System.out.println("Carnet: " + u.carnet);
                System.out.println("Telefono: " + u.telefono);
                System.out.println("Email: " + u.email);
                System.out.println("Libros prestado: " + u.prestamos);
                estado = false;
                break;
            }
        }

        if (estado) {
            System.out.println("----------- !!! USUARIO NO ENCONTRADO !!! -----------");
        }
    }

    public void ModificarUsuario() {
        System.out.println("Ingrese el ID del usuario a modificar");
        int id = l.nextInt();
        boolean estado = true;
        int indice = -1;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].id == id) {
                estado = false;
                indice = i;
                break;
            }
        }

        if (estado) {
            System.out.println("----------- !!! USUARIO NO ENCONTRADO !!! -----------");
        } else {

            System.out.println("--------MODIFICACION DE DATOS PARA USUARIO--------");
            System.out.println("Ingrese su nombre");
            l.nextLine();
            String nombre = l.nextLine();
            System.out.println("Ingrese su telefono");
            int telefono = l.nextInt();
            l.nextLine();
            System.out.println("Ingrese su email");
            String email = l.nextLine();

            usuarios[indice].nombre = nombre;
            usuarios[indice].telefono = telefono;
            usuarios[indice].email = email;
            System.out.println("!!!-- USUARIO MODIFICADO CORRECTAMENTE --!!!");
        }

    }

    public boolean VerificarUsuario(int id) {
        for (Usuario us : usuarios) {
            if (us != null) {
                if (us.id == id) {
                    if (us.prestamos < 3) {
                        return true;
                    } else {
                        System.out.println("!!!-- EL USUARIO indicado ya tiene 3 prestamos --!!!");
                        return false;
                    }
                }
            }
        }
        System.out.println("----------- !!! EL USUARIO NO FUE ENCONTRADO !!! -----------");
        return false;
    }

    public void CambiarPrestamos(int id, int opcion) {

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].id == id) {
                    if (opcion == 1) {
                        usuarios[i].prestamos++;
                    } else {
                        usuarios[i].prestamos--;
                    }
                }
            }
        }
    }
    
    public String DevolverNombre(int id) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].id == id) {
                    return usuarios[i].nombre;
                }
            }
        }
        System.out.println("----------- !!! EL USUARIO NO FUE ENCONTRADO !!! -----------");
        return "";
    }

}
