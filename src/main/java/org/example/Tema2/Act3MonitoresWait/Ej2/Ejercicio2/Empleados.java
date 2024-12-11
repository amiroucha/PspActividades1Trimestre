package org.example.Tema2.Act3MonitoresWait.Ej2.Ejercicio2;

public class Empleados extends Thread{

    Oficina oficina;
    public Empleados(String nombre, Oficina ofi){
        this.setName(nombre);
        this.oficina = ofi;
    }
    public void run(){
        oficina.llegarOficina();
        if (!oficina.EstaElJefe())//si no esta el jefe
        {
            oficina.saludarJefe();//saludo
        }else{
            oficina.llegarTarde();//pido perdon
        }
    }

}
