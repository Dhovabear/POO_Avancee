package TP1.Exo5;

public class Circuit {
    private int nbrTours;
    private int position;

    public Circuit(int nbrTours) {
        this.nbrTours = nbrTours;
        position = 0;
    }

    public void stopStand() throws InterruptedException {
        System.out.println( ((Voiture)Thread.currentThread()).getNom() + " s'arrête au stand !");
        Thread.sleep(2000);
        //System.out.println( ((Voiture)Thread.currentThread()).getNom() + " repart du stand!");
    }

    public synchronized boolean finishTour(){
        return ((Voiture) Thread.currentThread()).getToursFaits() < nbrTours;
    }

    public synchronized int getPosition(){
        return position++;
    }
}
