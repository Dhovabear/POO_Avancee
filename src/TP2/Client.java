package TP2;

import java.sql.Connection;
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


    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
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
