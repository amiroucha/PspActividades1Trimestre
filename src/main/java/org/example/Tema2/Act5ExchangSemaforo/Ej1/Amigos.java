package org.example.Tema2.Act5ExchangSemaforo.Ej1;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Amigos extends Thread{
    private final Exchanger<String> conversacion;
    public Amigos(String name, Exchanger<String> conversacion) {
        super(name);
        this.conversacion = conversacion;
    }

    public void run() {
        ArrayList<String> mensajePositivos = new ArrayList<>();
        mensajePositivos.add("Hoy invito yo");
        mensajePositivos.add("Toma un chocolate");
        mensajePositivos.add("Te compro algo");
        mensajePositivos.add("Vamos a comer");
        mensajePositivos.add("Vamos al buffet");
        mensajePositivos.add("Toma un michi");
        mensajePositivos.add("Toma 2 michis");
        Random r = new Random();
        String mensaje;
       while(true){
           try {
               sleep((int) (r.nextInt(3)*1000));
               System.out.println(getName() + ": Abriendo conversacion ...");
               int numero = r.nextInt(0,7);
               //coge un mensaje en la posicion random que le salio
               mensaje = mensajePositivos.get(numero);
               System.out.println(getName() + ": mensaje preparado--- "+mensaje);
               //en recibido es donde se hace el cambio de los mensajes
               String recibido = conversacion.exchange(mensaje);
               System.out.println(getName() + ": " + recibido);

           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }

    }
}
