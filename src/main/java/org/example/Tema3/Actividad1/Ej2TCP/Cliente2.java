package org.example.Tema3.Actividad1.Ej2TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2 {
    static final String HOST = "localhost";
    static final int Puerto = 2000;
    public static void main(String[] args) {
        if (args.length != 0){
            System.err.println("Uso: java RecepeptorUPD");
        }else {
            Scanner leer = new Scanner(System.in);
            int numero;
            try {
                //construir la direccion del socket del servidor
                Socket sCliente = new Socket(HOST, Puerto);
                //preparar el flujo de entrada, mensajes del servidor
                InputStream entrada = sCliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);
                //preparar el flujo de salida, mensajes que mandamos al servidor
                DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());
                //leo el mensaje recibido del servidor y lo impriomo
                System.out.println(flujoEntrada.readUTF());
                    //mientras que el servidor me mande un true
                while (flujoEntrada.readBoolean()) {
                    do {
                        try {//pido el numero y lo parsero por si me mete algo distinto
                            System.out.println("Adivina el numero (entre el 0 y 100)");
                            numero = Integer.parseInt(leer.nextLine());
                        } catch (NumberFormatException e) {
                            System.err.println("Error de formato : " + e.getMessage());
                            numero = 0;
                        }

                    } while (numero < 0 || numero > 100);
                    //manda el numero al servidor
                    flujo_salida.writeInt(numero);
                    //mensaje de vuelta del servidor
                    System.out.println(flujoEntrada.readUTF());
                }
                sCliente.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }





    }
}
