/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Tema3.ActividadMariajo.MultiHilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Clase que se conecta a un servidor TCP que se encuentra en localhost:2000 y que recibe un flujo de entrada que imprime por pantalla
 * @author alumno
 */
public class ClienteTCP {

    static final String HOST = "localhost";
    static final int Puerto = 2000;
    /**
     * Método principal de la clase
     * @param args sin argumentos
     */
    
    public static void main(String[] args) {
        try {
            Socket sCliente = new Socket(HOST, Puerto);
            InputStream aux = sCliente.getInputStream();
            DataInputStream flujo_entrada = new DataInputStream(aux);

             String respuesta = flujo_entrada.readUTF();
            System.out.println(respuesta);
             if(respuesta.equals("OK")){

             }

            //System.out.println(flujo_entrada.readUTF());

            OutputStream aux2 = sCliente.getOutputStream();
            DataOutputStream flujo_salida = new DataOutputStream(aux2);

            Thread.sleep(5000);

            flujo_salida.writeUTF("Hola servidor ");

            flujo_salida.writeUTF("Que pases un buen día ");



            sCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
