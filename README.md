# Project
Descripción del proyecto. Este proyecto consiste en el desarrollo de una aplicación sencilla de reservación de tiquetes aéreos, creada en Java (Swing), que simula un sistema de aerolínea.
Con este programa se puede verificar la disponibilidad de vuelos según la clase seleccionada (Business/Economy), realizar reservaciones según la capacidad limitada de espacios y generar automáticamente el boleto (Ticket) y la factura (Invoice) para el pasajero.
El propósito principal es la aplicación de los conceptos de Programación Orientada a Objetos (POO) haciendo que las clases principales del sistema trabajen juntas: Airplane, Flight, Passenger, Reservation, Ticket e Invoice.

Objetivos del Proyecto. Desarrollar un sistema funcional de boletos aéreos y que permita:
Simular la compra y reservación de tiquetes aéreos.
Verificar la disponibilidad de asientos según clase (Económica o Ejecutiva).
Generar automáticamente el Ticket y la Factura del pasajero.
Aplicar conceptos de encapsulamiento, composición y métodos de negocio en Java.

Estructura del Proyecto. Este proyecto usa programación orientada a objetos y tiene un paquete domain con las siguientes clases principales:
Airplane: Define el avión y su capacidad por clase.
Flight: Contiene información del vuelo (origen, destino, fecha, hora, precio base, etc.).
Passenger: Guarda los datos del pasajero.
Ticket: Representa el boleto emitido.
Invoice: Genera la factura asociada al boleto.
Reservation:Controla el proceso de reserva, verifica disponibilidad y crea el ticket y la factura.
Paquete Progra_project, contiene la clase principal: Progra_project que maneja la lógica del menú principal y la interfaz con el usuario mediante Swing (JOptionPane).

Requerimientos Técnicos.
Lenguaje: Java
Entorno de desarrollo: NetBeans
Modo de ejecución: Swing (interfaz con cuadros de diálogo JOptionPane)
Base de datos: No requerida
Capacidad por avión:
2 asientos en clase Business.
2 asientos en clase Economy.

Cómo Ejecutar el Proyecto.
1.	Clonar o descargar el repositorio 
https://github.com/Johnny-707/Project.git

2.	Abrir el proyecto en NetBeans:
Archivo.
Abrir Proyecto.
Selecciona la carpeta del repositorio.

4.	Compilar y ejecutar
Ejecuta la clase principal: Progra_project.Progra_project.java
5.	Interacción del sistema
Al ejecutar, aparecerá un menú con las siguientes opciones:
Verify Availability: Verifica asientos disponibles por clase.
Make Reservation: Permite registrar los datos del pasajero y reservar.
Show Flights Status: Muestra el estado y ocupación de todos los vuelos.
Exit: Cierra el programa.

Principios de POO aplicados.
Encapsulamiento: Cada clase gestiona sus propios atributos mediante getters/setters.
Composición: Clases como Reservation usan objetos Flight, Passenger, Ticket, Invoice.
Abstracción: Métodos como verifyAndReserve() y calculatePrice() simplifican la lógica de negocio.
Modularidad: Código organizado por paquetes y responsabilidades claras.

Control de Versiones (Git).
El proyecto se gestiona con GitHub e incluye:
Múltiples commits con mensajes descriptivos.
Estructura organizada en carpetas (domain/ y Progra_project/).
Este archivo README.md que explica propósito y ejecución.

