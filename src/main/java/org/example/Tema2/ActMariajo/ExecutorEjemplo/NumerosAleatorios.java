/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Tema2.ActMariajo.ExecutorEjemplo;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class NumerosAleatorios implements Runnable {

    
    /**************************************************************************
     * compone una cadena de diez números aleatorios menores que 50, separados
     * por ','
     */
    public void run() {

        Random random = new Random();
        StringBuilder strReturn = new StringBuilder();
        for (int i = 0; i <10; i++) {
            strReturn.append(random.nextInt(50) + ", ") ;
            System.out.println(Thread.currentThread().getName() +": "+strReturn);
            //Thread.yield();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Números aleatorio obtenidos por " + Thread.currentThread().getName() + ": " + strReturn);
    }
}

