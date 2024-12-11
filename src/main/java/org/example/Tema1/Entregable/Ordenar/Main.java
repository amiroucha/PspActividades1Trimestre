package org.example.Tema1.Entregable.Ordenar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();//me creo la lista

        Scanner entrada = new Scanner(System.in);//asigno la entrada a entrada

        while (entrada.hasNextInt()) {//hasNextInt me comprueba que sea un entero
            numeros.add(entrada.nextInt());//añado el numero a la lista
        }
        Collections.sort(numeros);//ordena la lista

        for(int i = 0; i < numeros.size(); i++)
        {//imprime la lista ordenada
            System.out.println(numeros.get(i));
        }

    }
}