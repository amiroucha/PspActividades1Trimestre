/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Tema2.ActMariajo.ExcepcionesThread;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Hilo extends Thread{
    //clase que implementa el hilo
    
    //constructor
    public Hilo(String nombre) {
        super(nombre);
    }

    //
    public void run() {
        Random numero = new Random();
        //crea un objeto Random
        int division = 100 / numero.nextInt(4);
        //divide 100 entre el número pseudoaleatorio entre 0 y 4
        System.out.println("Division: " + division);
        //muestra el valor de la división
    }
}
