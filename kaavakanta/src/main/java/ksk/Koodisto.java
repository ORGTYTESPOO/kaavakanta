package ksk;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author saara
 */
@Entity
@Table(name = "koodisto")
public class Koodisto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 
    @Column(name = "id")
    private int id;

    @Column(name = "koodi")
    private int koodi;

    @Column(name = "ryhma")
    private String ryhma;

    @Column(name = "kuvaus")
    private String kuvaus;

    @Column(name = "lisainfo")
    private String lisainfo;

    protected Koodisto() {

    }

   

//     INSERT INTO KOODISTO(id,koodi,ryhma, kuvaus,lisainfo) VALUES(1,1,'suunnittelualue','Leppävaara','Leppävaaran suunnittelualue');
//INSERT INTO KOODISTO(id,koodi,ryhma, kuvaus,lisainfo) VALUES(2,2,'suunnittelualue','Tapiola','Tapiolan suunnittelualue');
//
//INSERT INTO KOODISTO(id,koodi,ryhma, kuvaus,lisainfo) VALUES(3,3,'suunnittelualue','Matinkylä','Matinkylän suunnittelualue');
//INSERT INTO KOODISTO(id,koodi,ryhma, kuvaus,lisainfo) VALUES(4,4,'suunnittelualue','Espoonlahti-Kauklahti','Espoonlahti-Kauklahti suunnittelualue');
//
//INSERT INTO KOODISTO(id,koodi,ryhma, kuvaus,lisainfo) VALUES(5,6,'suunnittelualue','Vanha-Espoo','Vanha-Espoon suunnittelualue');
//INSERT INTO KOODISTO(id,koodi,ryhma, kuvaus,lisainfo) VALUES(6,7,'suunnittelualue','Pohjois-Espoo','Pohjois-Espoon suunnittelualue');
//
//     
// 
            
    

    public Koodisto(int id, int koodi, String ryhma, String kuvaus, String lisainfo) {
        this.id = id;
        this.koodi = koodi;
        this.ryhma = ryhma;
        this.kuvaus = kuvaus;
        this.lisainfo = lisainfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKoodi() {
        return koodi;
    }

    public void setKoodi(int koodi) {
        this.koodi = koodi;
    }

    public String getRyhma() {
        return ryhma;
    }

    public void setRyhma(String ryhma) {
        this.ryhma = ryhma;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getLisainfo() {
        return lisainfo;
    }

    public void setLisainfo(String lisainfo) {
        this.lisainfo = lisainfo;
    }
    
    
}
