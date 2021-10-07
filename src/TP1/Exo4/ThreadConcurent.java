package TP1.Exo4;

public class ThreadConcurent extends Thread{

    private boolean increment;
    private int nbrOccurences;
    private CompteurConcurent compteur;

    public ThreadConcurent(boolean increment, int nbrOccurences, CompteurConcurent compteur) {
        this.increment = increment;
        this.nbrOccurences = nbrOccurences;
        this.compteur = compteur;
    }

    @Override
    public void run() {
        for (int i = 0; i < nbrOccurences; i++) {
            if(increment) compteur.incr();
            else compteur.decr();
        }
    }
}
