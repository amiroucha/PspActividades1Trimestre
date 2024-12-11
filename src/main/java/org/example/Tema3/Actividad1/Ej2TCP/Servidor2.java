package org.example.Tema3.Actividad1.Ej2TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor2 {
    //UDP
    static final int Puerto = 2000;
    public static void main(String[] args) {
        Random rand = new Random();
        try{
            //creamos el socket con el puerto a utilizar
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escucha el puerto " + Puerto);
            //espera la conexion al cliente
            Socket sockEspera = skServidor.accept();
            System.out.println("Conectando al cliente");
            //preparo el flujo de salida
            OutputStream fuera = sockEspera.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(fuera);
            //preparo el flujo de entrada
            InputStream entrada = sockEspera.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            //mando ese mensaje al cliente
            flujoSalida.writeUTF("Hola, adivina el numero entre el 0 y el 100");
            //creo el numero y lo impriomo para no jugar de verdad
            int num = rand.nextInt(0,101);
            System.out.println("Numero a adivinar: "+num);
            //mando el true al cliente
            flujoSalida.writeBoolean(true);
            //lee el numero mandado por el cliente y lo guarda
            int numAdivina = flujoEntrada.readInt();
            //si no ha acertado
            while(num != numAdivina){
                //muestro el numero que mando el cliente
                System.out.println("El cliente probo con el numero: " +numAdivina);
                flujoSalida.writeUTF("El numero es incorrecto");
                //mando de nuevo el true, ya que no ha acertado todavia
                flujoSalida.writeBoolean(true);
                //leo lo que ha vuelto a introducir el cliente
                numAdivina = flujoEntrada.readInt();
            }
            //si ha acertado
            //manda el mensaje al usuario por el cliente
            flujoSalida.writeUTF("Numero acertado!!!");
            //imprime el servidor
            System.out.println("El cliente acerto con el numero: " +numAdivina);
            //cambia el booleano para indicar que ya ha acertado
            flujoSalida.writeBoolean(false);

            sockEspera.close();
            System.out.println("El cliente ha acertado. Fin del programa");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
