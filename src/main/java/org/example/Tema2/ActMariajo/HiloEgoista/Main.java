package org.example.Tema2.ActMariajo.HiloEgoista;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //se crean dos hilos: hrojo y hazul
        Color hrojo = new Color ("Rojo");
        Color hazul = new Color ("Azul");
        //se inician los hilos para su ejecución
        hrojo.start();
        hazul.start();
    }
}