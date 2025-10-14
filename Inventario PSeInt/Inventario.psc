Funcion AgregarProducto (codigos Por Referencia,nombres Por Referencia,cantidades Por Referencia,precios Por Referencia,total_productos Por Referencia)
	Definir codigo, nombre Como Cadena;
	Definir precio, cantidad Como Entero;
	Escribir 'Ingrese el codigo';
	Leer codigo;
	Escribir 'Ingrese el nombre del producto';
	Leer nombre;
	Escribir 'Ingrese la cantidad del producto';
	Leer cantidad;
	Escribir 'Ingrese el precio unitario del producto';
	Leer precio;
	codigos[total_productos] <- codigo;
	nombres[total_productos] <- nombre;
	cantidades[total_productos] <- cantidad;
	precios[total_productos] <- precio;
	Escribir 'SE REGISTRO CORRECTAMENTE EL PRODUCTO: '+nombre;
	total_productos <- total_productos+1;
	Escribir 'TOTAL DE PRODUCTOS: '+ConvertirATexto(total_productos);
FinFuncion

Funcion ConsultaPorCodigo (codigos,nombres,cantidades,precios,total_productos)
	Definir i Como Entero;
	Definir codigo Como Cadena;
	Definir indice Como Entero;
	indice <- -1;
	Escribir 'Ingrese el codigo del producto:';
	Leer codigo;
	Para i<-0 Hasta total_productos-1 Con Paso 1 Hacer
		Si codigos[i]==codigo Entonces
			indice <- i;
		FinSi
	FinPara
	Si indice<>-1 Entonces
		Escribir '---------SE ECNONTRO EL PRODUCTO--------';
		Escribir 'Codigo: '+codigos[indice];
		Escribir 'Nombre: '+nombres[indice];
		Escribir 'Stock: '+ConvertirATexto(cantidades[indice]);
		Escribir 'Precio / Unitario: '+ConvertirATexto(precios[indice]);
	SiNo
		Escribir '!! NO SE ENCONTRO EL PRODUCTO CON EL CODIGO: '+codigo+' !!';
	FinSi
FinFuncion

Funcion ModificarProducto (codigos Por Referencia,nombres Por Referencia,cantidades Por Referencia,precios Por Referencia,total_productos)
	Definir i, indice Como Entero;
	Definir codigo, nombre Como Cadena;
	Definir precio, cantidad Como Entero;
	indice <- -1;
	Escribir 'Ingrese el codigo del producto';
	Leer codigo;
	Para i<-0 Hasta total_productos-1 Con Paso 1 Hacer
		Si codigos[i]==codigo Entonces
			indice <- i;
		FinSi
	FinPara
	Si indice<>-1 Entonces
		Escribir 'Ingrese el nuevo codigo';
		Leer codigo;
		Escribir 'Ingrese el nuevo nombre del producto';
		Leer nombre;
		Escribir 'Ingrese la nueva cantidad del producto';
		Leer cantidad;
		Escribir 'Ingrese el nuevo precio unitario del producto';
		Leer precio;
		codigos[indice] <- codigo;
		nombres[indice] <- nombre;
		cantidades[indice] <- cantidad;
		precios[indice] <- precio;
		Escribir '!! SE ACTUALIZO EL PRODUCTO !!';
	SiNo
		Escribir '!! NO SE ENCONTRO EL PRODUCTO CON EL CODIGO: '+codigo+' !!';
	FinSi
FinFuncion

Funcion ListarProductos (codigos,nombres,cantidades,precios,total_productos)
	Definir i Como Entero;
	Para i<-0 Hasta total_productos-1 Con Paso 1 Hacer
		Escribir '---------------------';
		Escribir 'Codigo: '+codigos[i];
		Escribir 'Nombre: '+nombres[i];
		Escribir 'Stock: '+ConvertirATexto(cantidades[i]);
		Escribir 'Precio / Unitario: '+ConvertirATexto(precios[i]);
	FinPara
FinFuncion

Algoritmo Inventario
	Definir eleccion Como Entero;
	Dimensionar codigos(5), nombres(5), cantidades(5), precios(5);
	Definir codigos, nombres Como Cadena;
	Definir cantidades, precios Como Entero;
	Definir total_productos Como Entero;
	total_productos <- 0;
	Repetir
		Escribir '-------- Menu --------';
		Escribir '1) Agregar producto';
		Escribir '2) Consultar produto por código';
		Escribir '3) Modificar un producto';
		Escribir '4) Listar todos los productos';
		Escribir '5) Calcular valor total del inventario';
		Escribir '6) Salir';
		Leer eleccion;
		Segun eleccion Hacer
			1:
				Escribir 'OPCION AGREGAR PRODUCTO';
				AgregarProducto(codigos,nombres,cantidades,precios,total_productos);
			2:
				Escribir 'OPCION CONSULTAR POR CODIGO';
				ConsultaPorCodigo(codigos,nombres,cantidades,precios,total_productos);
			3:
				Escribir 'OPCION MODIFICAR UN PRODUCTO';
				ModificarProducto(codigos,nombres,cantidades,precios,total_productos);
			4:
				Escribir 'OPCION LISTAR TODOS LOS PRODUCTOS';
				ListarProductos(codigos,nombres,cantidades,precios,total_productos);
			6:
				Escribir 'ADIOS';
			De Otro Modo:
				Escribir 'Opcion invalida';
		FinSegun
	Hasta Que eleccion=7
FinAlgoritmo
