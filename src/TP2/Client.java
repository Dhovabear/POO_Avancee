package TP2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client {
    private int id;
    private String nom;
    private String prenom;

    private static ArrayList<Client> listeClients = new ArrayList<>();

    public static ArrayList<Client> getListeClients(){
        ResultSet res = BDD.getInstance().select("SELECT * FROM client ");

        try{
            while (res.next()){
                listeClients.add(new Client(res.getInt("id"),
                                            res.getString("nom"),
                                            res.getString("prenom")
                                )
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }



        return listeClients;
    }




    public static Client getClientWithId(int id) throws SQLException {

        ResultSet res = BDD.getInstance().select("SELECT * FROM client WHERE id = "+id);
        Client c = null;


        res.next();
        c = new Client(res.getInt("id"),res.getString("nom"),res.getString("prenom"));


        return c;
    }


    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(){}

    public static void removeClient(int num) {

        try {
            Client c = getClientWithId(num);
            for (Commande cmd: Commande.getCommandes(num)) {
                Commande.removeCommande(cmd);
            }
            StringBuilder sb = new StringBuilder("DELETE FROM Client WHERE id=");
            sb.append(c.id);
            BDD.getInstance().remove(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean addClient(Client c){
        PreparedStatement prepStat = BDD.getInstance().getPreparedStatement("INSERT INTO Client (id,nom,prenom) VALUES (?,?,?)");

        try {

            prepStat.setInt(1,c.getId());
            prepStat.setString(2,c.getPrenom());
            prepStat.setString(3,c.getNom());

            prepStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(id).append(": ");
        sb.append(nom.toUpperCase()).append(" ");
        sb.append(prenom.toLowerCase());

        return sb.toString();
    }



}
