package TP1.Exo2;

public class CompteurMain {

    public static void main(String[] args) {
        Compteur c1 = new Compteur("Paul"),
                 c2 = new Compteur("Pierre"),
                 c3 = new Compteur("Jacques");

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
