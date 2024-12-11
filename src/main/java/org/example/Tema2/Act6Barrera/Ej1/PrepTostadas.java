package org.example.Tema2.Act6Barrera.Ej1;

import java.util.concurrent.CountDownLatch;

public class PrepTostadas extends Thread{
    CountDownLatch cont;
    CountDownLatch cont2 = new CountDownLatch(1);
    UntarTostadas untar = new UntarTostadas(cont2);
    public PrepTostadas(CountDownLatch cont) {
        this.cont = cont;
    }
    public void run() {
        System.out.println("Haciendo tostadas...");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tostadas hechas.");
        cont.countDown();
    }
    public void iniciarUntar(){
        untar.start();
        try {
            cont2.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
