package org.example.Tema2.ActMariajo.ProblemaJardin;

public class SalJardin extends Thread {
    //clase derivada de Thread que define un hilo
    private RecursoJardin jardin;
    public SalJardin(String nombre, RecursoJardin j) {
        super(nombre);
        this.jardin = j;
    }

    @Override
    public void run() {
        jardin.decrementaCuenta();
        //invoca al método que decrementa la cuenta de accesos al jardín
    }
}

