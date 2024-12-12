/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Tema3.ActividadMariajo.EjemploUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * EmisorUDP envía un string que se le pasa en el segundo argumento a un receptor que se encuentra en host indicado como primer argumento.
 * La conexión se hace mediante UDP.
 * 
 * @author alumno
 */
public class EmisorUDP {

    /**
     * Método principal que envía una cadena al host receptor por UDP
     * @param args[0] Host receptor
     * @param args[1] String a enviar
     */
    public static void main(String args[])  {
        // Comprueba los argumentos
        if (args.length != 2) {
            System.err.println("Uso: java EmisorUDP maquina mensaje");
        } else {
            try {
                // Construye la dirección del socket del receptor
                // Crea el socket
                try (DatagramSocket sSocket = new DatagramSocket()) {
                    // Construye la dirección del socket del receptor
                    InetAddress maquina = InetAddress.getByName(args[0]);
                    int Puerto = 1500;
                    // Crea el mensaje
                    byte[] cadena = args[1].getBytes();
                    DatagramPacket mensaje = new DatagramPacket(cadena, args[1].length(), maquina, Puerto);
                    // Envía el mensaje
                    sSocket.send(mensaje);
                    // Cierra el socket
                    sSocket.close();
                }
            } catch (UnknownHostException e) {
                System.err.println("Desconocido: " + e.getMessage());
            } catch (SocketException e) {
                System.err.println("Socket: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("E/S: " + e.getMessage());
            }
        }
    }
}
