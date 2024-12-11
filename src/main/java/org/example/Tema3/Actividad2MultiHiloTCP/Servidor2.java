package org.example.Tema3.Actividad2MultiHiloTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor2 extends Thread  {
    static final int Puerto = 2000;
    private final Socket socketCliente;
    public Servidor2(Socket socketCliente, String nombre) {
        super(nombre);
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {//aqui la logica de la comunicacion
        Random rand = new Random();
        try{
            //preparo el flujo de salida
            DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
            //mando ese mensaje al cliente
            flujoSalida.writeUTF("Hola "+Thread.currentThread().getName()+" adivina el numero entre el 1 y el 100");
            //preparo el flujo de entrada
            DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());

            //creo el numero y lo impriomo para no jugar de verdad
            int num = rand.nextInt(1,101);
            System.out.println(Thread.currentThread().getName()+"Numero a adivinar: "+num);

            //lee el numero mandado por el cliente y lo guarda
            //numero...
            int numAdivina = flujoEntrada.readInt();
            //si no ha acertado
            if(num != numAdivina){
                //muestro el numero que mando el cliente
                System.out.println(Thread.currentThread().getName()+" probo con: " +numAdivina);
                //mando al cliente que ha fallado
                flujoSalida.writeUTF(Thread.currentThread().getName()+" has fallado, numero incorrecto");
            }else{
                //si ha acertado
                //manda el mensaje al usuario por el cliente
                flujoSalida.writeUTF(Thread.currentThread().getName()+": Numero acertado!!! : "+numAdivina);
                //imprime en el servidor
                System.out.println(Thread.currentThread().getName()+" acerto con el numero: " +numAdivina);
            }
            System.out.println(Thread.currentThread().getName()+" ha terminado.");

            //cierro la conexion
            socketCliente.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //creamos el socket con el puerto a utilizar
        try(ServerSocket skServidor = new ServerSocket(Puerto)){
            System.out.println("Escucho al puerto " + Puerto);
            int nCli=1;
            while(true){
                //espera la conexion al cliente
                Socket socketCliente = skServidor.accept();
                System.out.println("Conectado al Cliente "+nCli);
                new Servidor2(socketCliente, "Cliente "+nCli).start();
                nCli++;
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
