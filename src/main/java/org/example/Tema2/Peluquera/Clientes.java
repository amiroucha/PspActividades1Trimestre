package org.example.Tema2.Peluquera;

public class Clientes extends Thread{
    Peluqueria peluqueria;
    int idCliente;
    boolean estarPelu;
    public Clientes(Peluqueria peluqueria, int idCliente){
        this.peluqueria = peluqueria;
        this.idCliente= idCliente;
        estarPelu = true;
    }

    public void run(){
        while(estarPelu){
            try {
                if(peluqueria.entrarCliente(idCliente)){
                    estarPelu = false;
                }else{
                    Thread.sleep(2000);//se da una vuelta hasta que haya espacio
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
