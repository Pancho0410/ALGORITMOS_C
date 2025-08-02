Algoritmo Inventario
	Definir eleccion Como Entero;
	
	Repetir
		Escribir "---MENU----";
		Escribir "1) Agregar un producto";
		Escribir "2) COnsultar producto por codigo";
		Escribir "3) Modificar un producto";
		Escribir "4) Listar todos los productos";
		Escribir "5) Calcular inventario";
		Escribir "6) Salir";
		Leer eleccion;
		
		Segun eleccion Hacer
			1:
				Escribir "OPCION DE AGREGAR";
			2:
				Escribir "CONSULTAR POR CODIGO";
			3:
				Escribir "MODIFICAR UN PRODUCTO";
			6:
				Escribir "!! ADIOS !!";
			De Otro Modo:
				Escribir "!! OPCION NO VALIDA !!";
		Fin Segun
	Hasta Que eleccion==6
	
	
FinAlgoritmo
