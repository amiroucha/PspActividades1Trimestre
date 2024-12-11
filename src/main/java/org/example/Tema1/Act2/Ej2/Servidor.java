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
        RandomAccessFile raf;
        // El nombre del fichero en el que va a escribir, si no existe lo crea
        String nombreFichero = "miArchivo.txt";
        File archivo = new File(nombreFichero);
        // Printer se pone dentro del try porque así le indica que cuando termine de ejecutar el
        //bloque try cierra el PrintWriter, si no se cierra no escribe en el fichero
        //printWriter:

        //fileWriter: veveeeeeeeeeeeeeeeeer
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreFichero))) {
            for (int i = 0; i < 10; i++) {
                raf = new RandomAccessFile(archivo, "rwd");
                bloqueo = raf.getChannel().lock();
                while (raf.length() > 0) {
                    bloqueo.release();
                    bloqueo = null;
                    Thread.sleep(500);

                    bloqueo = raf.getChannel().lock();
                }
                raf.seek(0);
                raf.writeInt(i);
                bloqueo.release();
                bloqueo = null;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }
    }
}
