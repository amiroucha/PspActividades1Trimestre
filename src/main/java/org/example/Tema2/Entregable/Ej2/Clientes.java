package org.example.Tema2.Entregable.Ej2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Clientes extends Thread{
    String nombre;
    Semaphore semaforo;
    int normPriority; //la prioridad
    CountDownLatch cont; //la barrera

    public Clientes(String nombre, Semaphore semaforo, int normPriority, CountDownLatch cont) {
        this.nombre = nombre;
        this.semaforo = semaforo;
        this.normPriority = normPriority;
        this.cont = cont;
    }

    @Override
    public void run() {
            System.out.println("Llega a la puerta de la tienda "+nombre);
            try {
                if (normPriority == Thread.MAX_PRIORITY)//si es vip
                {
                    //entra a la tienda
                    semaforo.acquire(3);//coge todos los permisos porque quiere entrar solo
                    System.out.println("-->"+nombre+" entra a la tienda");
                    //------------------------------------------------------------------
                    sleep(3000); //tiempo dentro
                    //------------------------------------------------------------------
                    //se va de la tienda
                    System.out.println("<--"+nombre+" sale a la tienda");
                    semaforo.release(3); //libera los permisos
                    cont.countDown();//decrementa los nmeros necesarios a llegar a la barrera
                }else{
                    Random ran = new Random();
                    int numero = ran.nextInt(1000,2001);//numero entre 1 y 2 segundos
                    //entra a la tienda
                    semaforo.acquire(1);//coge solo 1 permiso porque es cliente normal
                    System.out.println("-->"+nombre+" entra a la tienda");
                    //------------------------------------------------------------------
                    sleep(numero); //esta entre 1 y 2 segundos dentro
                    //------------------------------------------------------------------
                    //se va de la tienda
                    System.out.println("<--"+nombre+" sale a la tienda");
                    semaforo.release(1);//libera el permiso
                    cont.countDown();//decrementa los nmeros necesarios a llegar a la barrera
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
