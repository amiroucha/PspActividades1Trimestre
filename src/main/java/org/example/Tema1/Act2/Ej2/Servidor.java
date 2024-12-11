package org.example.Tema1.Act2.Ej2;


import java.io.*;
import java.nio.channels.FileLock;

/*Suministrador: El suministrador escribe 10 números del 0 al 9 en un fichero. Debe
escribir los números de uno en uno y únicamente escribir en el fichero cuando esté
vacío. Es decir, hasta que no esté vacío no escribe. Una vez consiga escribir los 10
números termina.

Cliente: El cliente lee los números que le va dejando el suministrador. Lee el fichero
cuando existe algún número. Una vez lee el fichero, lo vacía (una forma de vaciarlo
puede ser poner su longitud a cero del fichero), imprime el número por pantalla. Una
vez leídos los 10 números termina.*/
public class Servidor {
    public static void main(String[] args) {
        FileLock bloqueo;
        //RandomAccessFile, que permite acceder
        // al archivo de manera aleatoria, tanto para lectura como para escritura.
        RandomAccessFile raf;

        // El nombre del fichero en el que va a escribir, si no existe lo crea
        String nombreFichero = "miArchivo.txt";
        File archivo = new File(nombreFichero); //representa el archivo en el sistema

        // Printer se pone dentro del try porque así le indica que cuando termine de ejecutar el
        //bloque try cierra el PrintWriter, si no se cierra no escribe en el fichero
        //printWriter:v Este objeto se usa para escribir en el archivo.

        try {
            for (int i = 0; i < 10; i++) {
                //rwd permiso de lectura y escritura
                raf = new RandomAccessFile(archivo, "rwd");
                bloqueo = raf.getChannel().lock();
                //Este bloqueo asegura que solo un hilo pueda escribir
                // en el archivo en un momento dado, evitando problemas de concurrencia.
                while (raf.length() > 0) {
                    bloqueo.release();
                    bloqueo = null;
                    Thread.sleep(500);

                    bloqueo = raf.getChannel().lock();
                }
                raf.seek(0); //volver a la posicion inicial, al principiio
                raf.writeInt(i); //escribe el valor de i como num entero
                bloqueo.release();
                bloqueo = null;
                raf.close();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("error: " + e.getMessage());
        }
    }
}

/*Este ejercicio hecho de otra forma con chatGpt
*public class Suministrador {
    public static void main(String[] args) {
        FileLock bloqueo = null;
        RandomAccessFile raf = null;
        String nombreFichero = "miArchivo.txt";
        File archivo = new File(nombreFichero);

        try {
            // Abre el archivo en modo "rwd" (lectura y escritura, con actualización de datos)
            raf = new RandomAccessFile(archivo, "rwd");

            // Empezamos el ciclo para escribir los números del 0 al 9
            for (int i = 0; i < 10; i++) {
                // Intentamos obtener un bloqueo exclusivo en el archivo para asegurarnos de que nadie más esté escribiendo
                bloqueo = raf.getChannel().lock();

                // Verificamos si el archivo está vacío
                if (raf.length() == 0) {
                    // Si está vacío, escribimos el número
                    raf.writeInt(i);
                    System.out.println("Escribiendo el número: " + i);
                } else {
                    // Si el archivo no está vacío, esperamos
                    System.out.println("El archivo no está vacío, esperando...");
                    // Liberamos el bloqueo
                    bloqueo.release();
                    bloqueo = null;
                    Thread.sleep(500);  // Esperamos medio segundo antes de volver a intentar
                    // Re-obtenemos el bloqueo y seguimos con la siguiente iteración
                    bloqueo = raf.getChannel().lock();
                }
            }
        } catch (IOException | InterruptedException e) {
            // Manejo de excepciones
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (bloqueo != null) {
                    bloqueo.release(); // Liberamos el bloqueo si lo tenemos
                }
                if (raf != null) {
                    raf.close(); // Cerramos el archivo
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el archivo o el bloqueo: " + e.getMessage());
            }
        }
    }
}
*
*
*
*
*
*
*
*
*
*
* */
