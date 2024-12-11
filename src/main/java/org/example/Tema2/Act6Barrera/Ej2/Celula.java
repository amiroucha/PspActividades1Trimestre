package org.example.Tema2.Act6Barrera.Ej2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Celula implements Runnable {
    CyclicBarrier barrera, barrera2;
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public Celula(String nombre, CyclicBarrier barrera, CyclicBarrier barrera2){
        this.nombre = nombre;
        this.barrera = barrera;
        this.barrera2 = barrera2;
    }

    public void run() {
        while (true){
            try {
                System.out.println(getNombre()+ " : shunkanido!!!");
                barrera.await();

                barrera2.await();
                Thread.sleep(1000);
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
