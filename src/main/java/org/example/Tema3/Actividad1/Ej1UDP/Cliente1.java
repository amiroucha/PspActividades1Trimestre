package org.example.Tema3.Actividad1.Ej1UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa el numero a enviar:");
        String numero = leer.nextLine();
        if (args.length != 0){
            System.err.println("Uso: java RecepeptorUPD");
        }else{
            try (DatagramSocket sSocket = new DatagramSocket()){
                //construir la direccion del socket del servidor
                InetAddress maquinaServ = InetAddress.getByName("localhost");
                int puerto = 1500;
                //ccrear el mensaje a enviar;
                byte[] cadena = numero.getBytes();
                DatagramPacket mensaje = new DatagramPacket(cadena,numero.length(),maquinaServ,puerto);
                //envia el mensaje
                sSocket.send(mensaje);
                //cierra el socket

                byte[] respuesta = new byte[1000];
                DatagramPacket respMensaje = new DatagramPacket(respuesta,respuesta.length);
                sSocket.receive(respMensaje);
                //muy improtante poner el punto incial yb final del paquete recibido
                String datosRecibidos = new String(respMensaje.getData(), 0, respMensaje.getLength());
                System.out.println(datosRecibidos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

}