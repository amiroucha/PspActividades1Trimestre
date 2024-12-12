package org.example.Tema2.Act3MonitoresWait.Ej2;

public class Main {
    public static void main(String[] args) {
        Oficina oficina = new Oficina();
        Jefe jefe = new Jefe("jefe",oficina);

        Empleados manzana = new Empleados("manzana", oficina);
        Empleados pera = new Empleados("pera", oficina);
        Empleados platano = new Empleados("platano", oficina);
        Empleados melocoton = new Empleados("melocoton", oficina);

        manzana.start();
        pera.start();
        platano.start();
        jefe.start();
        melocoton.start();

    }
}