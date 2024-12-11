package org.example.Tema2.ActMariajo.Estados;

public class Main {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo();
        //Crea un nuevo hilo. El hilo está en estado Nuevo (new)

        System.out.println("Hilo Auxiliar Nuevo: Estado=" + hilo1.getState() + ",¿Vivo? isAlive()=" + hilo1.isAlive());
        //Obtenemos el estado del thread hilo1 y si está vivo o no

        hilo1.start();
        //Inicia el thread hilo1 y pasa al estado Ejecutable

        System.out.println("Hilo Auxiliar Iniciado: Estado="+ hilo1.getState() + ",¿Vivo? isAlive()=" + hilo1.isAlive() + "\n");

        try {
            hilo1.join();
            //espera a que el thread hilo1 muera
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("\n Hilo Auxiliar Muerto: Estado="+ hilo1.getState() + ",¿Vivo? isAlive()=" + hilo1.isAlive());
    }
}