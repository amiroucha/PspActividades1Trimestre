package org.example.Tema2.Act1Hilos.example;


public class Main {
    public static void main(String[] args) {
        Perros perro1 = new Perros("Perrito1");
        perro1.start();
        Perros perro2 = new Perros("perrito2");
        perro2.start();

        //cuando usas runable, te creas un objeto de la clase(gato)
        //te creas un hilo
        //relacionas ese hilo al objeto
        //lanzas el hilo

        Gatos[] gatoGrupo = new Gatos[5];
        for (int i=0; i < gatoGrupo.length; i++)
        {
            gatoGrupo[i] = new Gatos();
            Thread hilogato = new Thread(gatoGrupo[i]);
            hilogato.setName("Gatito "+ i);
            hilogato.start();
        }
    }
}