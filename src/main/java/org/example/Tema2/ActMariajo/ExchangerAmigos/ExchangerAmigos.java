/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Tema2.ActMariajo.ExchangerAmigos;

import java.util.concurrent.Exchanger;

/**
 *
 * @author alumno
 */
public class ExchangerAmigos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Exchanger<Integer> exchanger = new Exchanger<Integer>();

        Jugador jugador1 = new Jugador("Jugador1", exchanger);

        Jugador jugador2 = new Jugador("Jugador2", exchanger);



        jugador1.start();

        jugador2.start();
    }
    
}
