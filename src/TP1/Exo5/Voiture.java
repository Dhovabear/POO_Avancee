package TP1.Exo5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("###.##",dfs);

        do{
            long time = System.currentTimeMillis();
            try {



                Thread.sleep((long) ( (Math.random()*(7000-3000)) + 3000 ) );

                if( (long)(Math.random() * ( (1 - 0) + 1) ) == 1)circuit.stopStand();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toursFaits++;

            long tmpsTours = System.currentTimeMillis() - time;
            System.out.println(nom + " vient de finir le tour " + toursFaits + " en " + df.format(((double)tmpsTours)/1000) +"s");
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
