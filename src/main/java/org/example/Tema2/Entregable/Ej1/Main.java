package org.example.Tema2.Entregable.Ej1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManejarExcepcion manejador = new ManejarExcepcion();//manejador de excepciones para hilos
        Buffer buffer = new Buffer();//mi objeto buffer
        int productores;
        int consumidores;
        Scanner leer = new Scanner(System.in);
        System.out.println("Cualquier valor inválido será contando por 1");
        System.out.printf("Numero de productores\n->");//pido el numero de productores
        try{
            productores = leer.nextInt();
            if (productores <= 0){//en caso de que sea 0 o un numero negativo
                System.out.println("Debe de ser un numero mayor que 0. Se le asigna 1.");
                productores = 1;//cambio el valor
            }
        }catch (InputMismatchException e){//En caso de que me meta algo que no es un numero
            System.out.println("Productor invalido. Se les asignará 1 ");
            productores=1;//cambio el valor
            leer.next(); // para que no se coma el pedir de los consumidores

        }
        //hago dos try - catch para que solo me asigne a 1 el valor incorrecto
        //si productores esta mal y consumidores bien, consumidores se queda con ese valor
        //y a productores se le asigna 1. Pasa igual viceversa
        System.out.printf("Numero de consumidores\n->");//pido el numero de escritores
        try{
            consumidores = leer.nextInt();
            if (consumidores <= 0){//en caso de que sea 0 o un numero negativo
                System.out.println("Debe de ser un numero mayor que 0. Se le asigna 1.");
                consumidores = 1;//cambio el valor
            }
        }catch (InputMismatchException e){//En caso de que me meta algo que no es un numero
            System.out.println("Consumidor inválido. Se les asigna 1");
            consumidores=1;//cambio el valor
            leer.next();
        }
            //creo e inicializo los hilos
        for (int i = 0; i < productores; i++) {
            Productor productor = new Productor("Productor "+(i+1),buffer);
            productor.setUncaughtExceptionHandler(manejador);//se asiigna al hilo antes de lanzarlo
            productor.start();
        }
        for (int i = 0; i < consumidores; i++) {
            Consumidor consumidor = new Consumidor("Consumidor "+(i+1),buffer);
            consumidor.setUncaughtExceptionHandler(manejador);//se asiigna al hilo antes de lanzarlo
            consumidor.start();
        }
    }
}