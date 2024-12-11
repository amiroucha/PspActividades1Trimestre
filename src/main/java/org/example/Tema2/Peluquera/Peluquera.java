package org.example.Tema2.Peluquera;

public class Peluquera extends Thread{
    Peluqueria peluqueria;
    public Peluquera(Peluqueria peluqueria){
        this.peluqueria = peluqueria;
    }

    @Override
    public void run() {
        while(peluqueria.clientes <6){
            peluqueria.esperarCliente();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            peluqueria.acabarCorte();
            if (peluqueria.clientes >= 6) { // Ajustado para el total de clientes
                System.out.println("No hay mas clientes");
                System.out.println("La peluqueria cierra");
                break;
            }
        }

    }
}
