package TP1.Exo1;

public class ParlerMain {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Parler("Wesh!"));
        t1.start();
        Thread.sleep(1000);

        Thread t2 = new Thread(new Parler("\t\tBien ou quoi?"));
        t2.start();
    }
}
