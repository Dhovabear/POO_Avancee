package TP2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Commande {
    private int numero;
    private String description;
    private double montant;
    private int Idclient;

    /*private static int nextIdToTake = ;

    getAllCommandes().get(getAllCommandes().size()).numero;*/

    public Commande(int numero, String description, double montant, int clientId) {
        this.numero = numero;
        this.description = description;
        this.montant = montant;
        this.Idclient = clientId;
    }

    public Commande(){}


    /*public static boolean init(){
        ArrayList<Commande> cmds = getAllCommandes();
        Collections.sort(cmds, Comparator.comparing(Commande::getNumero));

    }*/

    public static ArrayList<Commande> getCommandes(int idClient){

        ArrayList<Commande> listeCommandes = new ArrayList<>();

        ResultSet res = BDD.getInstance().select("SELECT * FROM COMMANDE WHERE ID_CLIENT = "+idClient);

        try{
            while (res.next()){
                listeCommandes.add(new Commande(res.getInt("numero"),
                                res.getString("description"),
                                res.getDouble("montant"),
                                res.getInt("id_client")
                        )
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }



        return listeCommandes;
    }

    public static ArrayList<Commande> getAllCommandes(){

        ArrayList<Commande> listeCommandes = new ArrayList<>();

        ResultSet res = BDD.getInstance().select("SELECT * FROM COMMANDE");

        try{
            while (res.next()){
                listeCommandes.add(new Commande(res.getInt("numero"),
                                res.getString("description"),
                                res.getDouble("montant"),
                                res.getInt("id_client")
                        )
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }



        return listeCommandes;
    }


    public static Commande prompt(){
        Commande c = new Commande();

        System.out.print("Entrez la description de la commande: ");
        c.description = Main.in.nextLine();

        System.out.print("Entrez le montant: ");
        c.montant = Main.in.nextDouble();

        System.out.print("Entrez le numéro du client: ");
        c.Idclient = Main.in.nextInt();

        return c;
    }


    public Client getClient(){

        try{
            return Client.getClientWithId(Idclient);
        }catch (SQLException e){
            return null;
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getDescription() {
        return description;
    }

    public double getMontant() {
        return montant;
    }

    public int getIdclient() {
        return Idclient;
    }

    /*public static int getNextIdToTake() {
        return nextIdToTake;
    }*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(numero).append(": ");
        sb.append(description).append(" ");
        sb.append(" montant: ").append(montant);

        Client client = getClient();


        sb.append(" idClient: ").append(Idclient);

        if(client != null) sb.append("(").append(client.getNom()).append(" ").append(client.getPrenom()).append(")");

        return sb.toString();
    }

}
