package org.example.Tema1.Act1Notepad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListarEj2 {
    public static void main(String[] args) {
        try{
            //creo el proceso que llamará al comando
            Process proceso = Runtime.getRuntime().exec("CMD /C DIR");
            proceso.waitFor(); //momento de espera

            //obtiene de la salida del proceso que llama al comando
            BufferedReader leer = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            //lee linea por linea y la muestra en pantalla
            String linea;
            while ((linea = leer.readLine()) != null) { //mientras que haya lineas por leer
                System.out.println(linea);
            }
            proceso.waitFor();

            //importante cerrar el proceso
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
