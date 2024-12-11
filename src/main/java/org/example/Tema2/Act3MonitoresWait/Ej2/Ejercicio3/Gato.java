package org.example.Tema2.Act3MonitoresWait.Ej2.Ejercicio3;

public class Gato extends Thread{
    Clinica clinica;
    boolean urgencia;
    public Gato(String nombre, boolean urgencia, Clinica clinica){
        this.setName(nombre);
        this.urgencia = urgencia;
        this.clinica = clinica;
    }
    public void run(){
        System.out.println("----------------- "+this.getName() + " llega a la clinica-----------------");
        clinica.gatoEntrar(urgencia);
    }
}
