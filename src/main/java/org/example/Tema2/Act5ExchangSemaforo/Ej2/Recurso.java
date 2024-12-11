package org.example.Tema2.Act5ExchangSemaforo.Ej2;

import java.util.concurrent.Semaphore;

public class Recurso {
    private final Semaphore semaforo;
    public Recurso(Semaphore semaforo) {
        this.semaforo = semaforo;
    }
    public void lock(Hilos hilo){
        try {
            semaforo.acquire(1);
            System.out.println(hilo.getName()+" tiene el lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error"+e);
        }
        System.out.println(hilo.getName()+" DEJA el lock");
        semaforo.release();
    }
}
