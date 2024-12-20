/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.example.Tema2.ActMariajo.CyclicBarrier2;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author profesoro
 */
public class EjemploCyclicBarrierMain {

    public static void main(String[] args) {
        int numeroHilos = 100;
        final CyclicBarrier barreraInicio = new CyclicBarrier(numeroHilos + 1);
        final CyclicBarrier barreraFin = new CyclicBarrier(numeroHilos + 1);

        System.out.println("Creando hilos");
        for (int i = 0; i < numeroHilos; i++) {
            //como si fuese la clase hilos
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        barreraInicio.await();
                        System.out.println("hilo ejecutandose");
                        barreraFin.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            hilo.start();
        }

        try {
            System.out.println("levanto barrera");
            barreraInicio.await(); //se esperana q todos acaben apra seguir
            barreraFin.await();
            System.out.println("todo acabado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
