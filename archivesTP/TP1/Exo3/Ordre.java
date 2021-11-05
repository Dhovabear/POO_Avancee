package TP1.Exo3;

public class Ordre {

    private int compteur;

    public Ordre() {
        compteur = 0;
    }

    public synchronized int getPosition(){
        return compteur++;
    }
}
