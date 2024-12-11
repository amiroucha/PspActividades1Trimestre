package org.example.Tema2.Act4Executer;

public class ManejarExcepcion implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Thread que lanza la excepcion: %s \n", t.getName());
        //e.printStackTrace();
    }
}
