package TP1.Exo5;

public class Voiture extends Thread{
    private String nom;
    private Circuit circuit;
    private int toursFaits;

    public Voiture(String nom, Circuit circuit) {
        this.nom = nom;
        this.circuit = circuit;
        toursFaits = 0;
    }

    @Override
    public void run() {

        do{
            try {
                Thread.sleep((long) (Math.random() * ((7000-3000) +1)));

                if( (long)(Math.random() * ((1) + 1) ) == 1)circuit.stopStand();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toursFaits++;
            System.out.println(nom + " vient de finir le tour " + toursFaits);
        }while (circuit.finishTour());

        System.err.println("La voiture " + nom + " est arrivée en position " + circuit.getPosition());
    }

    public String getNom() {
        return nom;
    }

    public int getToursFaits() {
        return toursFaits;
    }
}
