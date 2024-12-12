package org.example.Tema2.Act3MonitoresWait.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica();

        //con poner aqui max prioriry me ahorro mucho
        //gatos
        Gato gato1 = new Gato("gatito 1",false,clinica);
        Gato gato2 = new Gato("gatito 2",true,clinica);
        Gato gato3 = new Gato("gatito 3",false,clinica);
        Gato gato4 = new Gato("gatito 4",false,clinica);
        Gato gato5 = new Gato("gatito 5",false,clinica);
        //perros
        Perro perro1 = new Perro("perro 1",false,clinica);
        Perro perro2 = new Perro("perro 2",false,clinica);
        Perro perro3 = new Perro("perro 3",true,clinica);
        Perro perro4 = new Perro("perro 4",false,clinica);
        Perro perro5 = new Perro("perro 5",false,clinica);


        //iniciar hilos
        gato1.start();
        gato2.start();
        gato3.start();
        gato4.start();
        gato5.start();

        perro1.start();
        perro2.start();
        perro3.start();
        perro4.start();
        perro5.start();
    }


}
