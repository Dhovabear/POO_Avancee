package TP1.Exo1;

public class Parler implements Runnable{

    private String phrase;

    public Parler(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(phrase);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
