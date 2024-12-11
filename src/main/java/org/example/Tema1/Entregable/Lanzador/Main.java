package org.example.Tema1.Entregable.Lanzador;

public class Main {
    public static void main(String[] args) {

        String nombreArchivo = "fichero.txt"; //llamo al archivo, fichero

        try {
            for (int i = 10; i <= 100; i =i+10) {
                //Lee el nombre de mi fichero jar generado para proceso
                 Runtime.getRuntime().exec("java -jar "
                        + "Proceso_chaa-1.0-SNAPSHOT.jar " + i + " " + nombreArchivo);
            }
        } catch (SecurityException ex) {//en caso de cualquier error
            System.err.println("Ha ocurrido un error de Seguridad."
                    + "No se ha podido crear el proceso por falta de permisos.");
        } catch (Exception ex) {
            System.err.println("Ha ocurrido un error ");
        }

    }
}