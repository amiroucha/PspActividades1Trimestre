package org.example.Tema2.Entregable.Ej1;

public class Productor extends Thread{
    Buffer buffer;
    String nombre;
    public Productor(String nombre, Buffer buffer) {
        this.nombre = nombre;
        this.buffer = buffer;
    }
    //Escribe los numeros
    @Override
    public void run() {
        while(true){//se ejecuta infinitamente
            try {
                buffer.escribirNumero(nombre);//llamo a la funcion para escribir
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
