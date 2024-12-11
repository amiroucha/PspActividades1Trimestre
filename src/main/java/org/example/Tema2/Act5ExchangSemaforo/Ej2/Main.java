package org.example.Tema2.Act5ExchangSemaforo.Ej2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(7);
        Recurso recurso = new Recurso(sema);
        for (int i = 0; i < 10; i++) {
            new Hilos("Hilo " + (i+1), recurso).start();
        }

    }
}