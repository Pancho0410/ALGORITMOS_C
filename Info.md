# LABORATORIO DE INTRODUCCION A LOS ALGORIMTOS Y FLUJO DE DATOS C

Ejemplos realizados en clase

## Índice

- [Configuración recomendada para el software PSeint](#configuracion-recomendada-para-el-software)
- [Sistema de inventario en PSeInt](#sistema-de-inventario-en-pseint)

---
## Configuracion recomendada para el software

![configuracion](./Img//configPSEINT.png)

---
## Sistema de inventario en PSeInt


La carpeta que contiene los archivos utilizados es: **[Inventario PSeInt](./Inventario%20PSeInt)** 

<!-- `ss` -->

### Enunciado
Desarrollar un programa interactivo que permita al usuario gestionar un pequeño inventario de productos, brindando opciones para agregar, consultar, modificar, eliminar y listar productos, con control de cantidad en existencia y precio. El sistema debe mostrar un menú, validar datos y repetir el proceso hasta que el usuario decida salir.

### Requirimientos

1. Crear un menú interactivo y repetitivo  

```pseudocodigo
Repetir
    Escribir "--- MENÚ ---"
    Escribir "1) Agregar un producto"
    Escribir "2) Consultar producto por código"
    Escribir "3) Modificar un producto"
    Escribir "4) Listar todos los productos"
    Escribir "5) Calcular inventario"
    Escribir "6) Salir"
    Leer eleccion

    Segun eleccion Hacer
        1:
            Escribir "OPCIÓN DE AGREGAR"
        2:
            Escribir "CONSULTAR POR CÓDIGO"
        3:
            Escribir "MODIFICAR UN PRODUCTO"
        4:
            Escribir "LISTAR TODOS LOS PRODUCTOS"
        5:
            Escribir "CALCULAR INVENTARIO"
        6:
            Escribir "¡¡ ADIÓS !!"
        De Otro Modo:
            Escribir "¡¡ OPCIÓN NO VÁLIDA !!"
    Fin Segun
Hasta Que eleccion == 6
```
**¿Cómo funciona?**
**`Repetir...Hasta Que`**: Crea un ciclo que seguirá mostrando el menú hasta que el usuario seleccione la opción 6 (Salir).

**`Escribir`**: Muestra en pantalla las opciones del menú.

**`Leer eleccion`**: Captura la opción que el usuario elige.

**`Segun eleccion Hacer`**: Evalúa el valor ingresado por el usuario y ejecuta la acción correspondiente.

**`De Otro Modo`**: Si el usuario ingresa un número fuera del rango 1-6, se muestra un mensaje indicando que la opción no es válida.

**`Fin Segun`**: Cierra la estructura de selección múltiple.

**`Hasta Que eleccion`** == 6: Termina el ciclo solo cuando la elección es 6.

2. Agregar un nuevo producto al inventario  
3. Consultar la información de un producto según una característica específica  
4. Modificar los datos de un producto existente  
5. Mostrar todos los productos almacenados  
6. Salir del menú, terminando el algoritmo

---