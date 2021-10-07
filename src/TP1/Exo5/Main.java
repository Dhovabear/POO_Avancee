package TP1.Exo5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Voiture> participants = new ArrayList<>();
        Circuit circuit = new Circuit(3);

        for (int i = 0; i < 2; i++) {
            Voiture v = new Voiture(Integer.toString(i+1),circuit);
            participants.add(v);
            v.start();
        }


        for(Voiture v : participants){
            v.join();
        }

        Thread.sleep(500);
        System.out.println("La course est finie !");
    }
}
