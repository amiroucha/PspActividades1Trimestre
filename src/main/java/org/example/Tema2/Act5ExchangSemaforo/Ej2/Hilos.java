package org.example.Tema2.Act5ExchangSemaforo.Ej2;

public class Hilos extends Thread{
    Recurso recurso;

    public Hilos(String nombre, Recurso recurso){
        super(nombre);
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.lock(this);
    }
}
