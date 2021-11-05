package TP1.Exo3;

public class Compteur extends Thread{
    private String nom;

    private Ordre orderGiver;

    public Compteur(String nom , Ordre orderGiver) {
        this.nom = nom;
        this.orderGiver = orderGiver;
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
        System.out.println(nom + " a fini de compter j'usqu'a 10 en position " + orderGiver.getPosition());
    }
}
