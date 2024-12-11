package org.example.Tema2.ActMariajo.ProblemaJardin;

public class EntraJardin extends Thread {
    //clase derivada de Thread que define un hilo
    private RecursoJardin jardin;

    public EntraJardin(String nombre, RecursoJardin j) {
        super(nombre);
        this.jardin = j;
    }

    @Override
    public void run() {
        jardin.incrementaCuenta();
        //invoca al método que incrementa la cuenta de accesos al jardín
    }
}
