package org.example.Tema3.Actividad1.Ej1UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Servidor1 {
    public static void main(String[] args) {
        // Crea el  socket
        int num;
        Random rand  = new Random();
        if (args.length != 0){
            System.err.println("Uso: java RecepeptorUPD");
        }else{
            //crea el socket
            try(DatagramSocket sSocket = new DatagramSocket(1500)){
                //crea el espacio de los mensajes
                byte[] cadena = new byte[1000];
                DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
                System.out.println("Esperando mensajes........");
                while (true){
                    //recibe y muestra el mensaje
                    sSocket.receive(mensaje);
                    String datosRecibidos = new String(mensaje.getData(),0, mensaje.getLength());
                    try{
                        //me aseguro que el mensaje seleccionado es un numero
                        num = parseInt(datosRecibidos);
                    }catch (NumberFormatException e){
                        System.out.println("Error de parseo. Debe de ser un numero. Se le asignará 1");
                        num =1;
                    }

                    byte[] letras = {
                            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                            's', 't','u', 'v', 'w', 'x', 'y', 'z'
                    };

                    byte[] palabra = new byte[num];//Se le asigna la longitud que el servidor ha elegido para la aplabra
                    for(int i=0; i<num; i++){
                        palabra[i] = letras[rand.nextInt(26)];
                    }

                    System.out.println("Palabra generada: "+ new String(palabra));
                    System.out.println("Mensaje Recibido: "+datosRecibidos);

                    String respuesta = new String(palabra);
                    byte[] cadena1 = respuesta.getBytes();
                    DatagramPacket respuesta1 = new DatagramPacket(cadena1, respuesta.length(),mensaje.getAddress(), mensaje.getPort());
                    sSocket.send(respuesta1);

                }
            } catch (IOException es) {
                throw new RuntimeException(es);
            }


        }



    }



}
