package org.example.Tema2.Act6Barrera.Ej1;

import java.util.concurrent.CountDownLatch;

public class UntarTostadas extends Thread{

    CountDownLatch cont;
    public UntarTostadas(CountDownLatch cont) {
        this.cont = cont;
    }

    public void run() {
        System.out.println("Untando tostadas...");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tostadas untadas.");
        cont.countDown();
    }
}
