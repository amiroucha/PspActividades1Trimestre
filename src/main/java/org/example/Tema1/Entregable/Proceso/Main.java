package org.example.Tema1.Entregable.Proceso;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //inicializo variables
        int procesoss; //total de procesos
        String nombreFichero; //nombre/ruta del archivo
        File archivo;  //archivo al que vamos a acceder
        RandomAccessFile raf = null;
        FileLock bloqueo;

        //comprobacion de los argumentos

        if (args.length>0){
            try{
                procesoss = Integer.parseInt(args[0]);//numero de procesos
                nombreFichero = args[1]; //nombre fichero

                // Creo un objeto File con la ruta del archivo para el acceso
                archivo = new File(nombreFichero);

                try {
                    raf = new RandomAccessFile(archivo,"rwd");

                    for (int i = 1; i < procesoss + 1; i++){

                        String palabra = generaPalabra();//ASIGNO LA PALABRA
                        bloqueo = raf.getChannel().lock();
                        try{
                            raf.seek(raf.length());//para escribir al final
                            raf.writeBytes("Proceso " + procesoss + ": " + palabra + "\n");

                        }catch(IOException e){
                            System.err.println("Error al escribir en el archivo: " + e.getMessage());
                        }finally {
                            bloqueo.release(); // Libero el bloqueo
                        }
                        Thread.sleep(500);
                    }
                }catch (InterruptedException | IOException e) {
                    System.err.println("Error al acceder al fichero");
                } finally {
                    try {
                        if (raf != null) {
                            raf.close(); // Me aseguro de cerrar el RandomAccessFile
                        }
                    } catch (IOException e) {
                        System.err.println("Error al cerrar el fichero: " + e.getMessage());
                    }
                }

            }catch(NumberFormatException e){
                System.out.println("El primer argumento debe ser un número entero válido.");
                System.exit(1);//para que termine
            }catch (ArrayIndexOutOfBoundsException ex)
            {
                System.out.println("Segundo argumento vacio");
                System.exit(1);
            }
        }else{
            System.out.println("Sin argumentos");
        }

    }

    public static String generaPalabra(){
        Random random = new Random(); //para la creacion de las palabras

        char[] caracteres = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ',
                'o','p','q','r','s','t','u','v','w','x','y','z'};
        StringBuilder palabra = new StringBuilder();
        //random.nextInt((max - min) + 1) + min
        //palabras random a generar
        int longitud = random.nextInt((15 - 5) + 1) + 5;
        for (int j = 0; j < longitud; j++){
            palabra.append(caracteres[j]);
        }
        return palabra.toString();
    }
}