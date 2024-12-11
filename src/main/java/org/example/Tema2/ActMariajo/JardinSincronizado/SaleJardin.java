package org.example.Tema2.ActMariajo.JardinSincronizado;

public class SaleJardin extends Thread {
    //clase derivada de Thread que define un hilo
    private RecursoJardin jardin;
    public SaleJardin(String nombre, RecursoJardin j) {
        this.setName(nombre);
        this.jardin = j;
    }

    @Override
    public void run() {
        jardin.decrementaCuenta();
        //invoca al método que decrementa la cuenta de accesos al jardín
    }
}