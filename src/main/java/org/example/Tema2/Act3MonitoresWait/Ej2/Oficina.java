package org.example.Tema2.Act3MonitoresWait.Ej2;

public class Oficina {
    boolean jefeEsta = false; //jefe no esta

    public synchronized void llegarOficina() {
        System.out.println(Thread.currentThread().getName()+ ": llego");
    }
    public synchronized void saludarJefe() {
         while(!jefeEsta)//mientras que no este el jefe
         {
             try {
                 System.out.println(Thread.currentThread().getName() + ": Esperando al jefe...");
                 wait();//me quedo hasta que me avisen que ha llegado
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
        System.out.println(Thread.currentThread().getName() + " -: Buenos días jefe");
    }

    public synchronized void llegarJefe(){
        System.out.println(Thread.currentThread().getName()+"  llegó");
        jefeEsta = true;
        System.out.println("*******"+Thread.currentThread().getName()+" -: Buenos días empleados. *******");
        notifyAll(); //se notifica que el jefe llego
    }
    //llegas tarde
    public synchronized void llegarTarde(){
        System.out.println(Thread.currentThread().getName()+"  disculpe el retraso");
    }
    public boolean EstaElJefe(){
        return jefeEsta;
    }

}
