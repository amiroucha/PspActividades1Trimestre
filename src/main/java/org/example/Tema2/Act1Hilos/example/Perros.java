package org.example.Tema2.Act1Hilos.example;

import java.util.Random;

public class Perros extends Thread{
    @Override
    public void run() {
        try {
            Random rand = new Random();
            int ladrar = rand.nextInt(1, 4);
            for (int i=0; i<=ladrar; i++){
                System.out.println("GuauGuau "+getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Perros(String nombre){
        super(nombre);
    }

}
