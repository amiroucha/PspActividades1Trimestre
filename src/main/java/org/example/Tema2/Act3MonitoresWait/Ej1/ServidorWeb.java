package org.example.Tema2.Act3MonitoresWait.Ej1;

public class ServidorWeb {
    //clase que simula los accesos a un servidor
    private int cuenta;
    public ServidorWeb() {
        cuenta = 0;
    }
    public void incrementaCuenta() {
        System.out.println("hilo " + Thread.currentThread().getName()+"----- Entra en Servidor");
        cuenta++; //total de accesos
        System.out.println(cuenta + " accesos");
    }

}
