/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author saara
 */
public class Kantatesti {
 
    public static void main(String[] args) throws Exception {
 
        Class.forName("org.postgresql.Driver");
        String jdbcUrl = "********";
        String username = "******";
        String password = "*****";
 
        Connection connection = null;
        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connected!");
            String result = query(connection);
            System.out.println(result);
 
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
            String nimi = resultSet.getString("kuvaus");
 
            query = query + id + "\t" + nimi + "\n";
        }
        return query;
    }
}
