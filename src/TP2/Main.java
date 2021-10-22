package TP2;

import java.util.ArrayList;
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
            System.out.println("3: Ajouter une commande");
            System.out.println("0: Quitter");
            System.out.print("Votre choix: ");

            choix = in.nextInt();

            if(choix == 1){
                for(Client c : Client.getListeClients())
                    System.out.println(c);
            }
            else if(choix == 2){
                ArrayList<Client> clients = Client.getListeClients();

                System.out.println("Entrez l'id du client: ");
                int idClient = in.nextInt();

                for(Commande cm : Commande.getCommandes(idClient))
                    System.out.println(cm);
            }else if(choix == 3){
                System.out.println("----Saisie d'une nouvelle commande----");
                Commande c = Commande.prompt();
                System.out.println();


            }


        }while (choix != 0);




        db.disconnect();
    }



    public static int promptIntInRange(int min, int max){
        int val =  min-1;
        do{
            System.out.print("Entrez un entier entre "+min+" et "+max+": ");
            val = in.nextInt();
        }while (val <= min || val >= max );

        return val;
    }
}
