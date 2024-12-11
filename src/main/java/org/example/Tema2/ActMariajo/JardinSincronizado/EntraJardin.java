package org.example.Tema2.ActMariajo.JardinSincronizado;

public class EntraJardin extends Thread {
    //clase derivada de Thread que define un hilo
    private RecursoJardin jardin;

    public EntraJardin(String nombre, RecursoJardin j) {
        this.setName(nombre);
        this.jardin = j;
    }

    @Override
    public void run() {
        jardin.incrementaCuenta();
        //invoca al método que incrementa la cuenta de accesos al jardín
    }
}
