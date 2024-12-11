package org.example.Tema2.Act4Executer;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Cajera extends Thread{

    ExecutorService cajeras = newFixedThreadPool(2);
    Cliente cliente;
    public Cajera(String nombre, Cliente client){
        this.setName(nombre);
        this.cliente = client;
    }
    @Override
    public void run() {
        System.out.println(getName()+" atiende  "+cliente.getNombre());
        for(int i=1; i<= cliente.getCarroCompra().length +1 ;i++){
            System.out.println(getName()+" procesando el producto "+i+" del "+cliente.getNombre());
        }
    }
}
