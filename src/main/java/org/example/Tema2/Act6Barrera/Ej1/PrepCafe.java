package org.example.Tema2.Act6Barrera.Ej1;

import java.util.concurrent.CountDownLatch;

public class PrepCafe extends Thread {
    private CountDownLatch cont;

    public PrepCafe(CountDownLatch cont) {
        this.cont = cont;
    }

    public void run() {
        System.out.println("Haciendo el cafe...");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cafe hecho.");
        cont.countDown();
    }
}
