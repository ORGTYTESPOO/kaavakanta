package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ksk.Kaavatilasto;
import ksk.Koodisto;
import ksk.Historia;

/**
 *
 * @author saara
 */
public class Tietokanta {

    private String driver = "";
    private String jdbcUrl = "";
    private String username = "";
    private String password = "";

    private ArrayList<Koodisto> koodistoQuery = new ArrayList();
    private ArrayList<Kaavatilasto> kaavatilastoQuery = new ArrayList();
    private ArrayList<Historia> historiaQuery = new ArrayList();

    public Tietokanta(String driver, String jdbcUrl, String username, String password) {
        this.driver = driver;
        this.jdbcUrl = jdbcUrl;
        this.password = password;
        this.username = username;
    }

    public ArrayList<Kaavatilasto> queryKaavatilasto1(String ehtoquery) {
        query("kaavatilasto", ehtoquery);
        return this.kaavatilastoQuery;
    }

    public ArrayList<Historia> queryHistoria1(String ehtoquery) {
        query("historia", ehtoquery);
        return this.historiaQuery;
    }

    public ArrayList<Koodisto> queryKoodisto1(String ehtoquery) {
        query("koodisto", ehtoquery);
        return this.koodistoQuery;
    }

    /**
     *
     * @param taulu
     * @param ehtoquery
     *
     * query(taulu, "") hakee kaiken taulusta query(taulu, "select * from taulu
     * where x order by 1")
     */
    public void query(String taulu, String ehtoquery) {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tietokanta.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection connection = null;
        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connected!");

//---------------------------------------------------------------------------------
            if (taulu.equals("koodisto")) {
                if (ehtoquery.isEmpty()) {
                    this.koodistoQuery = queryKoodisto(connection, "select * from koodisto");
                } else {
                    this.koodistoQuery = queryKoodisto(connection, ehtoquery);
                }

            } else if (taulu.equals("historia")) {
                if (ehtoquery.isEmpty()) {
                    this.historiaQuery = queryHistoria(connection, "select * from historia order by aikaleima");
                } else {
                    this.historiaQuery = queryHistoria(connection, ehtoquery);
                }
            } else {
                if (ehtoquery.isEmpty()) {
                    this.kaavatilastoQuery = queryKaavatilasto(connection, "select * from kaavatilasto");
                } else {
                    this.kaavatilastoQuery = queryKaavatilasto(connection, ehtoquery);
                }
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

    //---------------------------------------------------------------------
    private ArrayList<Koodisto> queryKoodisto(Connection connection, String query) throws SQLException {

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

    private ArrayList<Historia> queryHistoria(Connection connection, String query) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Historia> rslist = new ArrayList();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");;
            String kaavatunnus = resultSet.getString("kaavatunnus");
            String kaavanimi = resultSet.getString("kaavanimi");
            String lisatieto = resultSet.getString("lisatieto");
            String hankkeenkuvaus = resultSet.getString("hankkeenkuvaus");
            String kaavatyyppi = resultSet.getString("kaavatyyppi");
            String suunnittelualue = resultSet.getString("suunnittelualue");
            Date aikaleima = resultSet.getDate("aikaleima");

            Historia h = new Historia(id, kaavatunnus, kaavanimi, lisatieto, hankkeenkuvaus, kaavatyyppi, suunnittelualue, aikaleima);
            rslist.add(h);
        }
        return rslist;
    }

    private ArrayList<Kaavatilasto> queryKaavatilasto(Connection connection, String query) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Kaavatilasto> rslist = new ArrayList();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");;
            String kaavatunnus = resultSet.getString("kaavatunnus");
            String kaavanimi = resultSet.getString("kaavanimi");
            String lisatieto = resultSet.getString("lisatieto");
            String hankkeenkuvaus = resultSet.getString("hankkeenkuvaus");
            String kaavatyyppi = resultSet.getString("kaavatyyppi");
            String suunnittelualue = resultSet.getString("suunnittelualue");

            Kaavatilasto k = new Kaavatilasto(id, kaavatunnus, kaavanimi, lisatieto, hankkeenkuvaus, kaavatyyppi, suunnittelualue);
            rslist.add(k);
        }
        return rslist;
    }

    //------
    //-------------------------------------------------------------------------
    public void executeDB(String query) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tietokanta.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection connection = null;
        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connected!");

            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);

            System.out.println(result + " rows were changed");

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

}
