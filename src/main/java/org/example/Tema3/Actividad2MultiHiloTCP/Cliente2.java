package org.example.Tema3.Actividad2MultiHiloTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2{
    static final String HOST = "localhost";
    static final int Puerto = 2000;

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero;
        int clientes = 0;
        while (clientes < 4) {
            try {
                //construir la direccion del socket del servidor
                Socket sCliente = new Socket(HOST, Puerto);
                //preparar el flujo de entrada, mensajes del servidor
                DataInputStream flujoEntrada = new DataInputStream(sCliente.getInputStream());
                //leo el mensaje recibido del servidor y lo impriomo
                //Hola cliente ...  adivina el numero entre el 1 y el 100
                System.out.println(flujoEntrada.readUTF());

                //preparar el flujo de salida, mensajes que mandamos al servidor
                DataOutputStream flujoSalida = new DataOutputStream(sCliente.getOutputStream());

                try {//pido el numero y lo parsero por si me mete algo distinto
                    numero = Integer.parseInt(leer.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato : " + e.getMessage());
                    numero = 0;
                }
                //manda el numero al servidor
                flujoSalida.writeInt(numero);

                //mensaje de leer del servidor
                //has fllado o numero acertado
                System.out.println(flujoEntrada.readUTF());
                clientes++;
                sCliente.close();

            } catch (IOException e) {
                System.err.println("Error de conexión: " + e.getMessage());
                break;
            }
        }
    }
}
