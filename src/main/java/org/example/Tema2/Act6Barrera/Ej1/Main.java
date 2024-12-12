package org.example.Tema2.Act6Barrera.Ej1;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch cont = new CountDownLatch(3);

        //incializo los hilos
        PrepCafe cafe = new PrepCafe(cont);
        PrepTostadas tostadas = new PrepTostadas(cont);
        PrepZumo zumo = new PrepZumo(cont);
        cafe.start();
        tostadas.start();
        zumo.start();
        //el main espera a que terminen los hhilos anteriores
        System.out.println(" Preparando desayuno");

        try {
            cont.await(); //cuando hayan pasado los 3 hilos
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tostadas.iniciarUntar();
        System.out.println("Desayuno servido");
    }


}