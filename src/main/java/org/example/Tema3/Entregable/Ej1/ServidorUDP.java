package org.example.Tema3.Entregable.Ej1;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

public class ServidorUDP {
    static final int Puerto = 1500;
    public static void main(String[] args) {
        //creo el cocket con el `puerto
        try(DatagramSocket sSocket = new DatagramSocket(Puerto)) {
            //crea el espacio del mensaje
            byte[] cadenaLLega = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(cadenaLLega, cadenaLLega.length);
            System.out.println("Servidor UPD esperando mensajes.......................");

            while(true){//esta constantemente pidiendo datos
                //recoge e imprime el mensaje
                sSocket.receive(mensaje);
                //convertimos el mensaje a String, ya que esta en bytes
                //poner desde el inicio hasta el fin del mensaje
                String datos = new String(mensaje.getData(),0, mensaje.getLength());
                System.out.println("Sorteo recibido: "+ datos);
                System.out.println("------------------Sorteo generado:------------------");
                //variable de respuesta que vamos a enviar
                String respuesta ;

                if("QUINIELA".equals(datos))//en caso de que sea quiniela
                {
                    respuesta = quinielaResp();
                }else if("LOTERIA".equals(datos)){//en caso de que sea loteria
                    //genero un numro random entre el 1 y 9999
                    Random rand = new Random();
                    int numero = rand.nextInt(10000);
                    respuesta = String.valueOf(numero);
                }else{//en caso de que este mal el mensaje que nos han mandado
                    respuesta = "Sorteo no disponible";
                }
                System.out.println(respuesta);
                //pasamos a byte la cadena
                byte[] cadenaFuera = respuesta.getBytes();
                //lo convertimos a un paquete
                DatagramPacket respuestaMandar = new DatagramPacket(cadenaFuera, respuesta.length(),mensaje.getAddress(), mensaje.getPort());
                //mandamos la respuesta paquete
                sSocket.send(respuestaMandar);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String quinielaResp(){
        String[] quiniela = {"1","X","2"}; //las opciones de la quiniela
        StringBuilder respuesta = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < 15; i++)
        {
            int posicion = rand.nextInt(3);
            respuesta.append("Partida ").append(i+1).append(": ").append(quiniela[posicion]);
            respuesta.append(" \n"); //creo todas las partidas de la quiniela y las guardo
        }

        return  respuesta.toString();
    }

}