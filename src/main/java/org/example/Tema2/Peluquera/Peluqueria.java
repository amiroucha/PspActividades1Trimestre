package org.example.Tema2.Peluquera;

import java.util.ArrayList;

public class Peluqueria {
    private final int sillasMax;
    private boolean sillaCortarLibre = true;
    private boolean peluqueraDurmiendo = true;
    ArrayList<Integer> salaEspera;
    int clienteNum;
    int clientes =0; //para saber cuantos clientes fueron atendidos

    public Peluqueria(int numSillas){
        this.sillasMax = numSillas;
        salaEspera = new ArrayList<>();
    }
    public synchronized boolean entrarCliente(int idCliente){//ve si hay sillas
        if (salaEspera.size() >= sillasMax){
            System.out.println("----------Cliente " + idCliente + " intenta entrar pero no hay sitio.----------");
            return false;
        }
        //hay sitio
        //añado el cliente a la lista de espera
        salaEspera.add(idCliente);
        System.out.println("----------Cliente " + idCliente + "se sienta en una silla en la sala de espera----------");

        if(peluqueraDurmiendo){
            System.out.println("----------Cliente " + idCliente + "despierta a la peluquera----------");
            peluqueraDurmiendo = false;
            notifyAll();//avisa a la peluquera
        }

        while(!sillaCortarLibre || salaEspera.getFirst() != idCliente){//la peluquera esta ocupada
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        sillaCortarLibre = false;
        System.out.println("----------Cliente " + idCliente + " esta en la silla de corte.----------");
        System.out.println("Peluquera cortando el pelo XXXXXXXXXX");
        clienteNum = idCliente;
        salaEspera.removeFirst();//ya no esta ocupando esa silla
        return true; //el cliente entro y se sento para el corte
    }
    public synchronized void esperarCliente(){//para que la peluquera sepa cuando viene cliente
        while (salaEspera.isEmpty() && clientes<6 && sillaCortarLibre)
        {
            try {
                System.out.println("La peluquera se duerme esperando al cliente");
                peluqueraDurmiendo = true;
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public synchronized void acabarCorte(){
        System.out.println("Peluquera termina de cortar el pelo y llama al siguiente");
        System.out.println("Cliente "+clienteNum+" se va con el pelo cortado");
        sillaCortarLibre = true;
        clientes++;
        notifyAll();
    }
}
