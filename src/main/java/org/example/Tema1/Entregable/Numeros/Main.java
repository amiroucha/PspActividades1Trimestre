package org.example.Tema1.Entregable.Numeros;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int totNumeros = 0;
        if (args.length > 0){//compruebo que me haya introducido argumento
            try {
                totNumeros = Integer.parseInt(args[0]);//numeros a generar, y comprueba que sea numero

            }catch (NumberFormatException e) {
                System.out.println("Lo introducido no es un numero ");
            }
            int contador = 0;//para contar el numero de primos que van saliendo

            Random random = new Random();
            //random.nextInt((max - min) + 1) + min para que se cuente solo entre el 2 y 999 incluidos

            while (contador < totNumeros) {//mientras que no se hayan generado todos los numeros
                int numero = random.nextInt((999-2)+1)+2;//genero el numero random

                if (esPrimo(numero)){//compruebo si es primo
                    System.out.println(numero);//lo enseño
                    contador++;//aumento contador
                }
            }

        }else {
            System.out.println("NO has introducido ningun argumento");
        }
    }

    public static boolean esPrimo(int numero)
    {
        //empiezo a comprobar desde el 2, el primer num primo
        //hasta la raiz cuadrada del numero generado, para asi poder hacer menos comprobaciones
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0){//no es primo
                return false;
            }
        }
        return true;//si no entra al if es primo
    }
}