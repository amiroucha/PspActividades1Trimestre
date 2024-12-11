package org.example.Tema2.ActMariajo.Interbloqueo;

public class Hilo1 extends Thread {
    //Declara dos objetos del tipos de cada fichero
    FicheroA a;
    FicheroB b;

    /*****************************************************************************
     constructor
     *
     * @param a: ficheroA
     * @param b: ficheroB
     */
    Hilo1(FicheroA a, FicheroB b) {
        this.a = a;
        this.b = b;
    }
    /*******************************************************************************
     * Tarea del hilo: acceder al ficheroA
     */
    @Override
    public void run() {
        a.metodoA(b);
        //el hilo accede al ficheroA
    }
}
