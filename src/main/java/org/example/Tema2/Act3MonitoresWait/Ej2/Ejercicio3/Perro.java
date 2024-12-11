package org.example.Tema2.Act3MonitoresWait.Ej2.Ejercicio3;

public class Perro extends Thread{
    Clinica clinica;
    boolean urgencia;
    public Perro(String nombre, boolean urgencia, Clinica clinica){
        this.setName(nombre);
        this.urgencia = urgencia;
        this.clinica = clinica;
    }
    //las prioridades de lo de urgencia
    public void run(){
        System.out.println("----------------- "+this.getName() + " llega a la clinica-----------------");
        clinica.perroEntrar(urgencia);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clinica.perroSalir();
    }
}
