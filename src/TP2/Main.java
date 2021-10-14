package TP2;

import java.util.Scanner;

public class Main {

    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        BDD db = BDD.getInstance();

        int choix = 0;

        do{
            System.out.println("------TP2------");
            System.out.println("1: Liste des clients");
            System.out.println("2: Liste des commandes");
            System.out.println("0: Quitter");
            System.out.print("Votre choix: ");

            choix = in.nextInt();

            if(choix == 1){
                for(Client c : Client.getListeClients())
                    System.out.println(c);
            }
            else if(choix == 2){

            }


        }while (choix != 0);




        db.disconnect();
    }
}
