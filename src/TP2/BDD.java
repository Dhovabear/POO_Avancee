package TP2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import  org.apache.derby.jdbc.EmbeddedDriver;

public class BDD {
    public static BDD instance;

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

    public static BDD getInstance(){
        if(instance == null) instance = new BDD();
        return instance;
    }
}
