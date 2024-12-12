package org.example.Tema2.Entregable.Ej1;

public class Consumidor extends Thread{
    Buffer buffer;
    String nombre;
    public Consumidor(String nombre, Buffer buffer) {
        this.nombre = nombre;
        this.buffer = buffer;
    }
    //lee los numeros
    @Override
    public void run() {
        while(true){//se ejecuta infinitamente
            try {
                buffer.leerNumero(nombre);//llamo a la funcion
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
