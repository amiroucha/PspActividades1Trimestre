package org.example.Tema2.Act6Barrera.Ej2;

import java.util.concurrent.CyclicBarrier;

public class Main2 {
    public static void main(String[] args) {

        CyclicBarrier barrera = new CyclicBarrier(4);
        Hilos goku = new Hilos("Goku", barrera);
        Hilos goten = new Hilos("Goten", barrera);
        Hilos gohan = new Hilos("Gohan", barrera);

        Celula celula = new Celula("Celula", barrera);
        Thread celu = new Thread(celula);

        goku.start();
        goten.start();
        gohan.start();
        celu.start();
    }
}
