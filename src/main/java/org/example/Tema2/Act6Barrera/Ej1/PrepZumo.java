package org.example.Tema2.Act6Barrera.Ej1;

import java.util.concurrent.CountDownLatch;

public class PrepZumo extends Thread{
    private CountDownLatch cont;
    public PrepZumo(CountDownLatch cont) {
        this.cont = cont;
    }
    public void run() {
        System.out.println("Haciendo zumo...");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Zumo hecho.");
        cont.countDown();
    }
}
