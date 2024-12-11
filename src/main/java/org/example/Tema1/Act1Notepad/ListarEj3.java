package org.example.Tema1.Act1Notepad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListarEj3 {

    public static void main(String[] args) {
        try{
            //creo el proceso que llamará al comando
            ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c" ,"dir");
           //inicio el proceso
            Process procesoInicio = proceso.start();

            //obtiene de la salida del flujo del proceso que llama al comando
            BufferedReader leer = new BufferedReader(new InputStreamReader(procesoInicio.getInputStream()));

            //lee linea por linea y la muestra en pantalla
            String linea;
            while ((linea = leer.readLine()) != null) { //mientras que haya lineas por leer
                System.out.println(linea);
            }
            procesoInicio.waitFor();//para esperar que el proceso termine

            leer.close();
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
        catch (InterruptedException exe)
        {
            throw new RuntimeException(exe);
        }
    }
}
