package org.example.Tema1.Act2.Ej2;


import java.io.*;
import java.nio.channels.FileLock;


public class Servidor {
    public static void main(String[] args) {
        FileLock bloqueo = null;
        RandomAccessFile raf = null;
        // El nombre del fichero en el que va a escribir, si no existe lo crea
        String nombreFichero = "miArchivo.txt";
        File archivo = new File(nombreFichero);
        // Printer se pone dentro del try porque así le indica que cuando termine de ejecutar el
        //bloque try cierra el PrintWriter, si no se cierra no escribe en el fichero
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
