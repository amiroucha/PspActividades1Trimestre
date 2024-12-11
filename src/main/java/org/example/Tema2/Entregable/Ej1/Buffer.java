package org.example.Tema2.Entregable.Ej1;

import java.util.Random;

/*ARCHIVO COMPARTIDO*/
//es el de las 3 posiciones y se va insertando y leyendo del mismo lugar, solo 1 cada vez
// -num-  -num-  -num-
public class Buffer {
    private final Integer[] buffer = new Integer[3];
    private final int maxCapacidad = 3;   //max capacidad del buffer
    private int indiceInsertar = 0;//por donde se queda el productor insertando
    private int indiceLeer = 0;//por donde se queda el consumidor insertando
    private int numsDentro = 0;     //los numeros dentro del buffer

    //metodo para escribir en el buffer
    public synchronized void escribirNumero(String nombre){
        Random ram = new Random();
        //el buffer esta lleno, dentro hay = numeros que la maxCapacidad
        while(numsDentro == maxCapacidad){
            System.out.println(nombre + " el buffer esta lleno, espero ");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar "+e.getMessage());
            }
        }
        int numero = ram.nextInt(1, 101);//NUM RANDOM ENTRE 1 Y 100
        buffer[indiceInsertar] = numero;//inserto el numero dentro del buffer
        System.out.println(nombre + " ha insertado el numero: " + numero);

        //Actualizo el indice de por donde se va insertando y el numero de numeros que hay dentro
        indiceInsertar = (indiceInsertar+1) % maxCapacidad;//asi vuelve al 0 cuando llega al 3
        numsDentro++;
        //Aviso a todos de que ya he escrito un numero
        notify();
    }

    public synchronized void leerNumero(String nombre){
        //si no hay nada escrito, espero
        while(numsDentro == 0){
            System.out.println(nombre + " el buffer esta vacio, espero");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar "+e.getMessage());
            }
        }
        Integer numeroLeer = buffer[indiceLeer];//me guardo el numero que hay en esa posicion

        if(numeroLeer != null){
            System.out.println(nombre + " ha leido el numero: " + numeroLeer);//muestro el numero
            buffer[indiceLeer] = null;//vacio la posicion

            //Actualizo el indice de por donde se va insertando y el numero de numeros que hay dentro
            indiceLeer = (indiceLeer+1) % maxCapacidad;//asi vuelve al 0 cuando llega al 3(la max capacidad)
            numsDentro--;//hay un numero menos dentro
            //Aviso a todos de que ya he leido un numero

        }
        notifyAll();
    }
    /*
    * Se lee en el mismo orden en el que escribe
    * SE ESCRIBE DE UNO EN UNO
    * SE LEE DE UNO EN UNO
    *PRODUCTOR:
    * Escribe cuando hay hueco sino espera a que se lea y se saque
    * espera cuando esta lleno
    *           comprobar si el buffer esta lleno,
    *           tiene que buscar una posicion vacia
    *
    * CONSUMIDOR
    * lee cuando hay algo escrito
    * espera cuando no hay nada leido
    * leer en caso de que alguna posicion tenga algo escrito sino espera
    *
    * usar syncronized
    *
    * */

}
