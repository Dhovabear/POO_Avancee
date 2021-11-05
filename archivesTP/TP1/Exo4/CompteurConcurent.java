package TP1.Exo4;

public class CompteurConcurent {

    private int compteur;

    public CompteurConcurent() {
        compteur = 0;
    }

    public synchronized void incr(){
        compteur++;
    }

    public synchronized void decr(){
        compteur--;
    }

    @Override
    public String toString() {
        return Integer.toString(compteur);
    }
}
