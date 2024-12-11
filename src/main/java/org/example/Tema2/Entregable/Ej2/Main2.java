package org.example.Tema2.Entregable.Ej2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main2 {

    public static void main(String[] args){
        Semaphore semaforo = new Semaphore(3);
        CountDownLatch cont = new CountDownLatch(10);
        ManejarExcepcion2 manejador = new ManejarExcepcion2();

        //declaraciones e inicializar los clientes
        for (int i = 0; i < 8; i++){
            //en caso de que sea el 3 o el 7 cliente son uno de los vip
            if(i == 2) clienteVip(semaforo, cont, manejador, "Victoria Beckham");//metodo que inicializa los vip
            if(i == 6) clienteVip(semaforo, cont, manejador, "David Beckham");
            clienteNormal(i, semaforo, cont, manejador);//inicializa los clientes normales, que son todos los demas
        }
        try {//barrera donde los hilos esperan a que llleguen todos
            cont.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //mensaje de cerrar
        System.out.println("TIENDA CERRADA.");
    }

    private static void clienteVip(Semaphore semaforo, CountDownLatch cont, ManejarExcepcion2 manejador, String nombre) {
        System.out.println("Voy a lanzar "+nombre+" ");//lanzo el vip
        Clientes david = new Clientes(nombre+" ", semaforo, Thread.MAX_PRIORITY, cont);
        david.setUncaughtExceptionHandler(manejador);//aplico el control de excepcion
        david.start();
    }

    private static void clienteNormal(int i, Semaphore semaforo, CountDownLatch cont, ManejarExcepcion2 manejador) {
        System.out.println("Voy a lanzar el Cliente "+(i +1));//lanzo el cliente normal
        Clientes cliente = new Clientes("Cliente "+(i +1), semaforo,Thread.MIN_PRIORITY, cont);
        cliente.setUncaughtExceptionHandler(manejador);//aplico el control de excepcion
        cliente.start();
    }
}
