/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtest;

import DB.Tietokanta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ksk.Koodisto;

/**
 *
 * @author saara
 */
public class Kantatesti2 {

    public static void main(String[] args) throws Exception {

        String driver = "org.postgresql.Driver";
        String jdbcUrl = "jdbc:postgresql://localhost:5432/test1";
        String username = "saara";
        String password = "postgres";

        Connection connection = null;

        ArrayList<Koodisto> koodistoQuery = new ArrayList();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tietokanta.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connected!");

//---------------------------------------------------------------------------------
            koodistoQuery = queryKoodisto(connection, "select * from koodisto");
            
            for(Koodisto k : koodistoQuery){
                System.out.println(":"+k.getId()+k.getRyhmakoodi());
            }

//---------------------------------------------------------------------------------
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        } finally {
            System.out.println("Closing the connection.");
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
            }
        }

    }

    private static String query(Connection connection) throws SQLException {

        String query = "";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM koodisto");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nimi = resultSet.getString("ryhma");

            query = query + id + "\t" + nimi + "\n";
        }
        return query;
    }

    private static ArrayList<Koodisto> queryKoodisto(Connection connection, String query) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Koodisto> rslist = new ArrayList();

        while (resultSet.next()) {
//             id numeric NOT NULL,
//  koodi numeric NOT NULL,
//  ryhmakoodi numeric NOT NULL,
//  ryhma character varying(20),
//  kuvaus character varying(30),
//  lisainfo character varying(50)
            int id = resultSet.getInt("id");
            int koodi = resultSet.getInt("koodi");
            int ryhmakoodi = resultSet.getInt("ryhmakoodi");
            String ryhma = resultSet.getString("ryhma");
            String kuvaus = resultSet.getString("kuvaus");
            String lisainfo = resultSet.getString("lisainfo");
            Koodisto k = new Koodisto(id, koodi, ryhmakoodi, ryhma, kuvaus, lisainfo);
            rslist.add(k);
            System.out.println("k:" + k.getKuvaus() + k.getRyhma());
        }
        return rslist;
    }
}