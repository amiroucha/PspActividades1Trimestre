package org.example.Tema3.Entregable.Ej1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    static final int Puerto = 1500;

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        try (DatagramSocket sSocket = new DatagramSocket()){
            //construir la direccion del socket del servidor
            InetAddress maquinaServ = InetAddress.getByName("localhost");
            //pide el mensaje al servidor
            System.out.println("Introduce el sorteo deseado (QUINIELA / LOTERIA): ");
            String sorteo = leer.nextLine();
            System.out.println("Vamos a solicitar nuestro sorteo: "+sorteo+"\n");
            //ccrear el mensaje a enviar;
            byte[] cadena = sorteo.getBytes();
            DatagramPacket mensaje = new DatagramPacket(cadena,sorteo.length(),maquinaServ,Puerto);
            //envia el mensaje
            sSocket.send(mensaje);

            //preparar la respuesta
            byte[] respuesta = new byte[1000];
            DatagramPacket respMensaje = new DatagramPacket(respuesta,respuesta.length);
            //recojo el mensaje que me ha devuelto el servidor
            sSocket.receive(respMensaje);
            String datosRecibidos = new String(respMensaje.getData(), 0, respMensaje.getLength());
            //muestro el mensaje
            System.out.println(datosRecibidos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
