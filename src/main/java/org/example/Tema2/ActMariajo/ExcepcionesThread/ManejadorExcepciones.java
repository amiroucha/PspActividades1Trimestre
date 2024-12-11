package org.example.Tema2.ActMariajo.ExcepcionesThread;


import java.lang.Thread.UncaughtExceptionHandler;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class ManejadorExcepciones implements UncaughtExceptionHandler{//manejador de excepciones para toda la aplicación
   
    //implementa el método uncaughtException()
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("Thread que lanzó la excepción: %s \n", t.getName());
        //muestra en consola el hilo que produce la exceción
        e.printStackTrace();
        //muestra en consola la pila de llamadas
    }
}
