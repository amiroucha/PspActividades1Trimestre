package org.example.Tema2.ActMariajo.Estados;

public class Hilo extends Thread{
    public void run(){
        for(int i=10;i>=1;i--)
            System.out.print(i+",");
    }
}
