package TP1.Exo4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CompteurConcurent cont = new CompteurConcurent();

        ThreadConcurent t1 = new ThreadConcurent(true,100,cont),
                        t2 = new ThreadConcurent(false,100,cont);


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(cont);
    }
}
