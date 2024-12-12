package org.example.Tema2.Act3MonitoresWait.Ejercicio3;

public class Clinica extends Thread {
    boolean hayGatoDentro = false;
    boolean perro3urg = false;//perro cion urgencia
    boolean gato2urg = false;
    int animalesDentro = 0;
    //metodo para que el gato entre
    public synchronized void gatoEntrar(boolean urgencia){
       while((perro3urg && !urgencia) || animalesDentro > 0){//no queremos a ningun animal dentro
           System.out.println(Thread.currentThread().getName() + "  esperando para entrar");
           try {
               wait();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
       animalesDentro++;
       hayGatoDentro = true;
       if(urgencia) {gato2urg = true;}

       System.out.println(Thread.currentThread().getName() + "  entra al quirofano");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        gatoSalir();
    }
    public synchronized void gatoSalir(){
        System.out.println(Thread.currentThread().getName() + "  sale del quirofano");
        animalesDentro--;//hay uno menos dentro
        hayGatoDentro = false;
        gato2urg = false;//como ya se salio, no queda nadie dentro
        notifyAll();
    }
    //perros
    public synchronized void perroEntrar(boolean urgencia){
        while((gato2urg && !urgencia) || hayGatoDentro || animalesDentro >=2 ){
            System.out.println(Thread.currentThread().getName() + "  esperando para entrar");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        animalesDentro++;
        if(urgencia) {perro3urg = true;}

        System.out.println(Thread.currentThread().getName() + "  entra al quirofano");

    }
    public synchronized void perroSalir(){
        System.out.println(Thread.currentThread().getName() + "  sale del quirofano");
        animalesDentro--;//hay uno menos dentro
        perro3urg = false;//como ya se salio, no queda nadie dentro
        notifyAll();
    }
}
