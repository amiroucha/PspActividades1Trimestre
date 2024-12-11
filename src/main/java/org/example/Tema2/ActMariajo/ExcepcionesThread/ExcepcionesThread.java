/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.example.Tema2.ActMariajo.ExcepcionesThread;

/**
 *
 * @author Usuario
 */
public class ExcepcionesThread {

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("hilo1");
        Hilo hilo2 = new Hilo("hilo2");
        Hilo hilo3 = new Hilo("hilo3");
        Hilo hilo4 = new Hilo("hilo4");
        Hilo hilo5 = new Hilo("hilo5");
        //se crean 5 hilos
        ManejadorExcepciones manejador = new ManejadorExcepciones();
        //se crea el manejador
        hilo1.setUncaughtExceptionHandler(manejador);
        hilo2.setUncaughtExceptionHandler(manejador);
        hilo3.setUncaughtExceptionHandler(manejador);
        hilo4.setUncaughtExceptionHandler(manejador);
        hilo5.setUncaughtExceptionHandler(manejador);
        //se asocia a cada hilo el manejador de excepciones creado
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        //se inician los hilos
    }
}
