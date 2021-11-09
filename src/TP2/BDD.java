package TP2;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class BDD {

    private static BDD instance;

    private Connection con;

    public BDD() {
        connect();
    }

    public void connect(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String connectionString = "jdbc:derby:D:/Documents/l3pro/poo/BDDDerby/Bdd";//a changer
            con = DriverManager.getConnection(connectionString);

        } catch (ClassNotFoundException e) {
            System.err.println("Problème avec le driver JBDC");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.err.println("Probleme de connection a a bdd");
            /*throwables.printStackTrace();*/
        }
    }


    public void disconnect(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet select(String req){
        Statement requette = null;
        ResultSet res = null;

        try {
            requette = con.createStatement();
            res = requette.executeQuery(req);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public boolean insert(String commande){
        Statement st = null;

        try {
            st = con.createStatement();
            st.executeUpdate(commande);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean remove(String commande){
        Statement st = null;

        try {
            st = con.createStatement();
            st.executeUpdate(commande);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public PreparedStatement getPreparedStatement(String commande){
        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement(commande);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prst;
    }


    public static BDD getInstance(){
        if(instance == null) instance = new BDD();
        return instance;
    }

}
