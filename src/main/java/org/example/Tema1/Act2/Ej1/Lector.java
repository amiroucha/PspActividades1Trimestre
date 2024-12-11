package org.example.Tema1.Act2.Ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lector {
    public static void main(String[] args) {
        //lee las palabras y las ordena
        //lo hace con las tuberias, que la salida del escritor se pasa al lector
        ArrayList<String> palabras = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        while(entrada.hasNextLine()){
            palabras.add(entrada.nextLine());
        }

        Collections.sort(palabras);

        for (int i = 0; i < palabras.size(); i++){
            System.out.println(palabras.get(i));
        }


    }
}