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
