package org.example.Tema2.Peluquera;

public class Main {
    public static void main(String[] args) {
        int numeroSillas = 4;
        int numeroClien = 6;

        Peluqueria peluqueria = new Peluqueria(numeroSillas);
        new Peluquera(peluqueria).start(); //peluquera se le pasa peluquería
        for (int i = 0; i < numeroClien; i++) {
            new Clientes(peluqueria,i).start();
        }
    }
}