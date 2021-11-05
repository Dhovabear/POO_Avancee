package TP1.Exo3;

import TP1.Exo3.Compteur;

public class CompteurMain {

    public static void main(String[] args) {

        Ordre ord = new Ordre();

        Compteur c1 = new Compteur("Paul",ord),
                 c2 = new Compteur("Pierre",ord),
                 c3 = new Compteur("Jacques",ord);

        c1.start();
        c2.start();
        c3.start();

        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tout le monde a fini !");
    }

}
