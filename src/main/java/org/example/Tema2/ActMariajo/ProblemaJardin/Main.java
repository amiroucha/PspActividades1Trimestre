package org.example.Tema2.ActMariajo.ProblemaJardin;

public class Main {
    public static void main(String[] args) {

        RecursoJardin jardin = new RecursoJardin();
        //crea un objeto RecursoJardín

        for (int i = 1; i <= 10; i++) {
            (new EntraJardin("Entra" + i, jardin)).start();
        }//entrada de 10 hilos al jardín

        for (int i = 1; i <= 15; i++) {
            (new SalJardin("Sale" + i, jardin)).start();
        }//salida de 15 hilos al jardín
    }
}