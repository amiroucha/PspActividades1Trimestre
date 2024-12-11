package org.example.Tema2.Act3MonitoresWait.Ej2.Ejercicio1;

public class Hilos extends Thread{
    private ServidorWeb servidor;

    public Hilos(String nombre, ServidorWeb servidorWe)
    {
        super(nombre);
        this.servidor = servidorWe;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // Cada hilo llama a incrementaCuenta 10 veces
            synchronized (servidor){
                servidor.incrementaCuenta();
            }

        }
    }
}
