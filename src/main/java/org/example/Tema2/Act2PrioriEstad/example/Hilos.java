package org.example.Tema2.Act2PrioriEstad.example;

import java.util.Random;

public class Hilos extends Thread {
    int tiempoDormir;
    public Hilos(String name) {
        super(name);
    }
//una clase para generar todos los hilos
    @Override
    public void run() {
        Random rand= new Random();
        tiempoDormir = rand.nextInt(1000,4001);
        for(int i = 1; i<=100;i++)
        {
            System.out.println("Soy "+getName()+": "+i);
            try {
                Thread.sleep(tiempoDormir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
