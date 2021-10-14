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

            String connectionString = "jdbc:derby:D:\\Documents\\Lpro\\POO\\POOAvancee\\BDDDerby\\Bdd";
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

    public static BDD getInstance(){
        if(instance == null) instance = new BDD();
        return instance;
    }
}
