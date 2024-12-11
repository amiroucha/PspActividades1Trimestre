package org.example.Tema2.Entregable.Ej2;

public class ManejarExcepcion2 implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Cliente que lanza la excepcion: %s \n", t.getName());
    }
}
