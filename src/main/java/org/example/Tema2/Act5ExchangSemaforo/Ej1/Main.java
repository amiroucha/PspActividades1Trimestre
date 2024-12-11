package org.example.Tema2.Act5ExchangSemaforo.Ej1;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Amigos amigo1 = new Amigos("Pepito", exchanger);
        Amigos amigo2 = new Amigos("Lola", exchanger);

        amigo1.start();
        amigo2.start();

    }
}