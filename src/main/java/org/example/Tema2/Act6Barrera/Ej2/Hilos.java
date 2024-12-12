package org.example.Tema2.Act6Barrera.Ej2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Hilos extends Thread{
    CyclicBarrier barrera;
    String nombre;
    public Hilos(String nombre, CyclicBarrier barrera){
        this.nombre = nombre;
        this.barrera = barrera;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public void run() {
        while(true){
            System.out.println(getNombre()+ " : Kame hame ha!!!");
            try {
                barrera.await();
                sleep(1000);
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
