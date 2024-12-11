package org.example.Tema2.Act6Barrera.Ej2;

import java.util.concurrent.CyclicBarrier;

public class Main2 {
    public static void main(String[] args) {

        CyclicBarrier barrera = new CyclicBarrier(3);
        CyclicBarrier barrera2 = new CyclicBarrier(1);
        Hilos goku = new Hilos("Goku", barrera, barrera2);
        Hilos goten = new Hilos("Goten", barrera, barrera2);
        Hilos gohan = new Hilos("Gohan", barrera, barrera2);

        Celula celula = new Celula("Celula", barrera, barrera2);
        Thread celu = new Thread(celula);

        goku.start();
        goten.start();
        gohan.start();
        celu.start();
    }


}
