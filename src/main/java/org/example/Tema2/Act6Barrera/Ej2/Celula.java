package org.example.Tema2.Act6Barrera.Ej2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Celula implements Runnable {
    CyclicBarrier barrera, barrera2;
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public Celula(String nombre, CyclicBarrier barrera){
        this.nombre = nombre;
        this.barrera = barrera;
    }

    public void run() {
        while (true){
            try {
                // Esperar a los demás en la barrera
                barrera.await(); //cuando ella tabien llega aqui ya se suman 4
                // Célula responde después de los ataques
                System.out.println(getNombre() + " : shunkanido!!!");
                Thread.sleep(1000);
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
