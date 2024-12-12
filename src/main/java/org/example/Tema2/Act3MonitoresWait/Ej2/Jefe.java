package org.example.Tema2.Act3MonitoresWait.Ej2;

public class Jefe extends Thread{
    Oficina oficina;
    public Jefe(String nombre, Oficina ofi)
    {
        this.setName(nombre);
        this.oficina = ofi;
    }
    @Override
    public void run() {
        oficina.llegarJefe();
    }
}
