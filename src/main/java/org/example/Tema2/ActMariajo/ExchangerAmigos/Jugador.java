/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Tema2.ActMariajo.ExchangerAmigos;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 *
 * @author alumno
 */
public class Jugador extends Thread {



      private final Exchanger<Integer> cita;

 

      public Jugador(String name, Exchanger<Integer> cita) {

            super(name);

            this.cita = cita;

      }

 

      public void run() {
            Random r = new Random();
            try {

                  sleep((int) (r.nextInt(3)*1000));

                  System.out.println(getName() + ": Genero mi número ...");

                  int numero = r.nextInt(10)*1000;

                  System.out.println(getName() + ": Genero el número -->"+numero);
                  sleep((int) (100 * Math.random()));
                  int recibido = cita.exchange(numero);

                  System.out.println(getName() + ": " + recibido);


            } catch (InterruptedException ignore) {

            }

      }

}    
