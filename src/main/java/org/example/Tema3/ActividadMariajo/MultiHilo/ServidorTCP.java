/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Tema3.ActividadMariajo.MultiHilo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor TCP que escucha en el puerto 2000. Se quedará esperando las peticiones de 3 clientes y le enviará un mensaje con el número de cliente
 * @author alumno
 */
public class ServidorTCP extends Thread{

    static final int Puerto = 2000;
    private Socket sCliente;

    public ServidorTCP(Socket sCliente, String nombre) {
        super(nombre);
        this.sCliente = sCliente;
    }

    public void run(){
        //Aquí la lógica de la comunicación


        OutputStream aux = null;
        try {
            aux = sCliente.getOutputStream();
            DataOutputStream flujo_salida = new DataOutputStream(aux);
            flujo_salida.writeUTF("Hola cliente ");

            InputStream aux2 = sCliente.getInputStream();
            DataInputStream flujo_entrada = new DataInputStream(aux2);
            System.out.println(Thread.currentThread().getName()+": "+flujo_entrada.readUTF());

            System.out.println(Thread.currentThread().getName()+": "+flujo_entrada.readUTF());
            sCliente.close();
            Thread.sleep(5000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Método principal de la clase
     * @param args sin argumentos
     */
    public static void main(String[] args) {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escucho el puerto " + Puerto);
            for (int nCli = 0; nCli < 3; nCli++) {
                System.out.println("Esperando a un cliente");
                Socket sCliente = skServidor.accept();
                System.out.println("Sirvo al cliente " +nCli);
                new ServidorTCP(sCliente, "Cliente"+nCli).start(); //Creo el hilo y lo lanzo

            }
            System.out.println("Ya se han atendido los 3 clientes");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}
