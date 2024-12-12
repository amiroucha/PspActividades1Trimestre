package org.example.Tema2.Act3MonitoresWait.Ej1;

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

            synchronized(servidor){
                //se sincroniza el objeto, cuando llamas l metodo es compartido tambien
                //cada vez que entra un hilo necesita terminar todo el metodo para poder meter se otro
                servidor.incrementaCuenta();
            }

        }
    }
}
