package TP1.Exo2;

import java.util.Random;

public class Compteur extends Thread{
    private String nom;

    public Compteur(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long)(Math.random()*((5000)+1)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nom + " a fini de compter j'usqu'a 10");
    }
}
