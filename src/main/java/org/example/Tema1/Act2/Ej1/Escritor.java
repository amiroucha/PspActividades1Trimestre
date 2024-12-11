package org.example.Tema1.Act2.Ej1;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Escritor {
    public static void main(String[] args) {
        //genera tantas palabras como se le indique por argumento
        Random random = new Random();

        char caracteres[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

        int veces = Integer.parseInt(args[0]);

        for (int i = 0; i < veces; i++) {
            int longitud = random.nextInt(25) + 1;
            for (int j = 0; j < longitud; j++){
                System.out.print(caracteres[j]);
            }
            System.out.println("");
        }
    }
}