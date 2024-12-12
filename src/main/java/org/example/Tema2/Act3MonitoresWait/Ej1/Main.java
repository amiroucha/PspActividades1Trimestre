package org.example.Tema2.Act3MonitoresWait.Ej1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServidorWeb servidorWebCompartido = new ServidorWeb();

        for(int i = 1; i <=4 ; i++) {
            Hilos hilo = new Hilos(""+i, servidorWebCompartido);
            hilo.start(); // Inicia el hilo
        }
    }
}