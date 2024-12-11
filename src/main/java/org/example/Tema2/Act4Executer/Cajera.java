package org.example.Tema2.Act4Executer;

public class Cajera extends Thread{

    Cliente cliente;
    public Cajera(String nombre, Cliente client){
        this.setName(nombre); //super(nombre)
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
