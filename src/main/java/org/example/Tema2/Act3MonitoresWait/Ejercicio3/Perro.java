package org.example.Tema2.Act3MonitoresWait.Ejercicio3;

public class Perro extends Thread{
    Clinica clinica;
    boolean urgencia; //este se podia hacer con las prioridades
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
        //si lo pongo desde clinica me daba mal
        clinica.perroSalir(); //este metodo debe de ir aqui
    }
}
