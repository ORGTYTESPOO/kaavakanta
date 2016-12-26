/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksk;

import DB.Tietokanta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author saara
 */
public class HistoriaRepository {
     private ArrayList<Historia> all = new ArrayList();

    public ArrayList<Historia> findAll(Tietokanta t) {
        t.queryHistoria1("");
        return all;
    }
;
    
    
    public void insert(Tietokanta t, Historia h){
        //lisätään aina uusi rivi
        String query = "insert into historia(id,kaavatunnus,kaavanimi,lisatieto,hankkeenkuvaus,kaavatyyppi,suunnittelualue,aikaleima) values(";
        String values =  h.getId() +","+ h.getKaavatunnus()+","+h.getKaavanimi()+","+h.getLisatieto()+","+h.getHankkeenkuvaus()+","+h.getKaavatyyppi()+","+h.getSuunnittelualue()+","+h.getAikaleima()+")";
        t.executeDB(query + values);
             
    }
    
    
}
