/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.example.Tema2.ActMariajo.ExecutorEjemplo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class ExecutorEjemplo {

      /**************************************************************************
     * ejecuta ocho veces la tarea NumerosAleatorios que imprime diez números
     * aleatorios menores que cincuenta, mediante un pool de tan sólo dos hilos
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //define un pool fijo de 4 hilos
        //4 hilos fijos
       /* ExecutorService executor = Executors.newFixedThreadPool(4);
        //1 único hilo
        //ExecutorService executor = Executors.newSingleThreadExecutor();
        //reutiliza hilos terminados
        //ExecutorService executor = Executors.newCachedThreadPool();

        //pasa 30 tareas NumerosAleatorios al pool de 4 hilos
        for (int i = 1; i <= 30; i++) {
                executor.submit(new NumerosAleatorios());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //ordena la destrucción de los hilos del pool cuando hayan
        //completado todas las tareas
        executor.shutdown();*/

        //EJEMPLO newScheduledThreadPool
       /* ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        //Espero 0 segundo para lanzar cada 5 segundos el hilo
        scheduledExecutorService.scheduleAtFixedRate(new NumerosAleatorios(),0, 5, TimeUnit.SECONDS);

        //Me voy a esperar 20 segundos antes de terminar la ejecución del programa para poder ver el resultado
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.shutdown();*/
    }
}
