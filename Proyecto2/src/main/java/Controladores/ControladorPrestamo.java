package Controladores;

import java.util.Scanner;
import Modelos.Prestamo;
import main.Main.Proyecto2;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControladorPrestamo {

    public static int id_actual;
    public Prestamo[] prestamos;
    public Scanner l;

    public ControladorPrestamo() {
        this.prestamos = new Prestamo[20];
        this.l = new Scanner(System.in);
        this.id_actual = 1;
    }

    public void Prestamo() {
        System.out.println("--------PRESTAMO DE LIBRO--------");
        System.out.println("Ingrese el codigo del LIBRO");
        int codigo = l.nextInt();
        l.nextLine();
        int id_usuario;
        boolean estado_libro = Proyecto2.libros.VerificarLibro(codigo);
        if (estado_libro) {
            System.out.println("Ingrese el ID del USUARIO");
            id_usuario = l.nextInt();
            l.nextLine();
            boolean estado_usuario = Proyecto2.usuarios.VerificarUsuario(id_usuario);
            if (estado_usuario) {

                for (int i = 0; i < prestamos.length; i++) {
                    if (prestamos[i] == null) {
                        LocalDate fechaPrestamo = LocalDate.now();
                        LocalDate fechaDevolucion = fechaPrestamo.plusDays(3); // Fecha calculada automaticamente para devolver el libro
                        prestamos[i] = new Prestamo(id_actual, id_usuario, codigo, fechaPrestamo, fechaDevolucion);
                        id_actual++;
                        Proyecto2.libros.CambiarEstado(codigo, 1);
                        Proyecto2.usuarios.CambiarPrestamos(id_usuario, 1); //Opcion para sumar 1 a la variable de prestamos en cada usuario
                        System.out.println("!!!-- PRESTAMO REGISTRADO CORRECTAMENTE --!!!");
                        break;
                    }
                }

            } else {
                return;
            }
        } else {
            return;
        }
    }

    public void CalcularMulta(int id_prestamo) {
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null) {
                if (prestamos[i].id_prestamo == id_prestamo) {
                    //Evalura la fecha prevista de devolucion con la fecha final de devolucion
                }
            }
        }
    }

    public void Devolver() {
        System.out.println("--------DEVOLVER LIBRO PRESTADO (PRESTAMO ACTIVO)--------");
        System.out.println("Ingrese el ID del prestamo activo");
        int id_prestamo = l.nextInt();
        l.nextLine();
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null) {
                if (prestamos[i].id_prestamo == id_prestamo && prestamos[i].estado) {

                    System.out.println("Ingrese el MES (numero) de entrega del libro"); //1 - 12
                    int mes = l.nextInt();
                    l.nextLine();
                    System.out.println("Ingrese el DIA (numero) del mes de entrega del libro "); // 1 - 31
                    int dia = l.nextInt();
                    l.nextLine();
                    LocalDate fechaFinalDevolucion = LocalDate.of(2025, mes, dia);
                    // 21/10 fecha de prestamo
                    // 24/10 fecha automatica de devolucion
                    // 29/10 fecha final
                    if (prestamos[i].fecha_devolucion.isBefore(fechaFinalDevolucion)) {
                        // Ocurrio un atraso
                        long dias = ChronoUnit.DAYS.between(prestamos[i].fecha_devolucion, fechaFinalDevolucion);  // Represntan los dias que se paso de la fecha de entrega
                        int mora = (int) (dias * 1);
                        System.out.println("!!-- Hubo un atraso en la entrega de: " + dias + " dias por lo que se genero una MULTA de Q" + mora + " --!!");
                        prestamos[i].multa = mora;
                    }
                    prestamos[i].fecha_final = fechaFinalDevolucion;
                    prestamos[i].estado = false;
                    Proyecto2.usuarios.CambiarPrestamos(prestamos[i].id_usuario, 2);
                    Proyecto2.libros.CambiarEstado(prestamos[i].codigo_libro, 2);
                    System.out.println("!!!-- SE DEVOLVIO CORRECTAMENTE EL LIBRO --!!!");
                    return;
                }
            }
        }
        System.out.println("----------- !!! EL PRESTAMO ACTIVO NO FUE ENCONTRADO !!! -----------");

    }

    public void PrestamosActivos() {   //De un usuario especifico
        System.out.println("--------BUSCAR PRESTAMOS ACTIVOS POR USUARIO--------");
        System.out.println("Ingrese el ID del USUARIO");
        int id_usuario = l.nextInt();
        l.nextLine();
        String nombre = Proyecto2.usuarios.DevolverNombre(id_usuario);
        if (!nombre.equals("")) {
            System.out.println("----------- PRESTAMO DEL USUARIO: " + nombre + " -----------");
            for (int i = 0; i < prestamos.length; i++) {
                if (prestamos[i] != null) {
                    if (prestamos[i].id_usuario == id_usuario && prestamos[i].estado) {
                        System.out.println("----------- PRESTAMO No: " + (i + 1) + " -----------"); //Indica la posicion dentro de mi lista de prestamos
                        System.out.println("ID del Prestamo: " + prestamos[i].id_prestamo);
                        System.out.println("ID Cliente: " + id_usuario);
                        System.out.println("Titulo del libro: " + Proyecto2.libros.DevolverTitulo(prestamos[i].codigo_libro));
                        System.out.println("Fecha de prestamo: " + prestamos[i].fecha_prestamo);
                        System.out.println("Fecha prevista de devolucion: " + prestamos[i].fecha_devolucion);
                    }

                }
            }
        } else {
            return;
        }
    }

    public void ListarPrestasmoActivos() {
        String nombre;
        System.out.println("--------LISTAR TODOS LOS PRESTAMOS ACTIVOS--------");
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null && prestamos[i].estado) {
                nombre = Proyecto2.usuarios.DevolverNombre(prestamos[i].id_usuario);
                System.out.println("----------- Prestamo No: " + (i + 1) + " -----------"); //Hacemos referencia a la posicion dentro del listado
                System.out.println("ID del Prestamo: " + prestamos[i].id_prestamo);
                System.out.println("Nombre del Cliente: " + nombre);
                System.out.println("ID Cliente: " + prestamos[i].id_usuario);
                System.out.println("Titulo del libro: " + Proyecto2.libros.DevolverTitulo(prestamos[i].codigo_libro));
                System.out.println("Fecha de prestamo: " + prestamos[i].fecha_prestamo);
                System.out.println("Fecha prevista de devolucion: " + prestamos[i].fecha_devolucion);
            }
        }
    }

    public void ConsultarMultas() { // Los prestamos devueltos que hayan generado multas
        System.out.println("Ingrese el ID del USUARIO");
        int id_usuario = l.nextInt();
        l.nextLine();

        String nombreU = Proyecto2.usuarios.DevolverNombre(id_usuario);
        if (nombreU.equals("")) {
            return;
        }
        System.out.println("----------- PRESTAMOS DEL USUARIO: " + nombreU + " Con MULTAS ----------");
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null && !prestamos[i].estado) {  //Se haya devuelto el libro
                if (prestamos[i].id_usuario == id_usuario && prestamos[i].multa > 0) {
                    System.out.println("----------- Prestamo No: " + (i + 1) + " -----------"); //Hacemos referencia a la posicion dentro del listado
                    System.out.println("ID del Prestamo: " + prestamos[i].id_prestamo);
                    System.out.println("ID Cliente: " + prestamos[i].id_usuario);
                    System.out.println("Titulo del libro: " + Proyecto2.libros.DevolverTitulo(prestamos[i].codigo_libro));
                    System.out.println("Fecha de prestamo: " + prestamos[i].fecha_prestamo);
                    System.out.println("Fecha devolucion: " + prestamos[i].fecha_final);
                    System.out.println("MULTA TOTAL: " + prestamos[i].multa);
                }
            }
        }
    }

    public void MultasPagadas() {
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null && !prestamos[i].estado) {  //Se haya devuelto el libro
                if (prestamos[i].multa > 0) { // Generaron un pago
                    System.out.println("----------- Prestamo No: " + (i + 1) + " -----------"); //Hacemos referencia a la posicion dentro del listado
                    System.out.println("ID del Prestamo: " + prestamos[i].id_prestamo);
                    System.out.println("ID Usuario: " + prestamos[i].id_usuario);
                    System.out.println("Titulo del libro: " + Proyecto2.libros.DevolverTitulo(prestamos[i].codigo_libro));
                    System.out.println("Fecha de prestamo: " + prestamos[i].fecha_prestamo);
                    System.out.println("Fecha devolucion: " + prestamos[i].fecha_final);
                    System.out.println("MULTA TOTAL: " + prestamos[i].multa);
                }
            }
        }
    }

    public void ReportePrestamosActivos() {
        String nombre;
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] != null && prestamos[i].estado) {
                nombre = Proyecto2.usuarios.DevolverNombre(prestamos[i].id_usuario);
                System.out.println("---------------------------------------------------------");
                System.out.println("ID del Prestamo: " + prestamos[i].id_prestamo);
                System.out.println("Nombre del usuario: " + nombre);
                System.out.println("ID Cliente: " + prestamos[i].id_usuario);
                System.out.println("Titulo del libro: " + Proyecto2.libros.DevolverTitulo(prestamos[i].codigo_libro));
                System.out.println("Fecha de prestamo: " + prestamos[i].fecha_prestamo);
            }
        }
    }

}
