/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksk;

import DB.Tietokanta;
import java.util.ArrayList;

/**
 *
 * @author saara
 */
public class KoodistoRepository {
    
    private ArrayList<Koodisto> all = new ArrayList();

    public ArrayList<Koodisto> findAll(Tietokanta t) {
        all = t.queryKoodisto1("");
        return all;
    }
;
    
}
