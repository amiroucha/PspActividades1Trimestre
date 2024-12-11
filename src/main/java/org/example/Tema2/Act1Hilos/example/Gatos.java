package org.example.Tema2.Act1Hilos.example;

import java.util.Random;

public class Gatos implements Runnable {
    int dormir;
    @Override
    public void run() {
        try{
            Random rand = new Random();
            dormir = rand.nextInt(500, 700);
            System.out.println("Dame mi comida " +Thread.currentThread().getName());
            Thread.sleep(dormir);
            System.out.println("Adios "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
