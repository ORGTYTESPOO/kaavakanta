package ksk;

import DB.Tietokanta;
import java.util.ArrayList;

/**
 *
 * @author saara
 */
public class KaavatilastoRepository {

    private ArrayList<Kaavatilasto> resultSet = new ArrayList();

    public ArrayList<Kaavatilasto> findAll(Tietokanta t) {
        resultSet = t.queryKaavatilasto1("");
        return resultSet;
    }

    ;
    
    public void save(Tietokanta t, Kaavatilasto h) {
        //poista vanha jos löytyy
        resultSet = t.queryKaavatilasto1(h.getKaavatunnus());

        if (!resultSet.isEmpty()) {
            t.executeDB("delete from kaavatilasto where id =" + h.getKaavatunnus());
        }
        
        // tallenna uusi rivi tauluun
        String query = "insert into kaavatilasto(id,kaavatunnus,kaavanimi,lisatieto,hankkeenkuvaus,kaavatyyppi,suunnittelualue) values(";
        String values = h.getId() + "," + h.getKaavatunnus() + "," + h.getKaavanimi() + "," + h.getLisatieto() + "," + h.getHankkeenkuvaus() + "," + h.getKaavatyyppi() + "," + h.getSuunnittelualue() + ")";

        t.executeDB(query + values);

    }
;
}
