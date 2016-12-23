//-- Table: public.historia
//
//-- DROP TABLE public.historia;
//
///CREATE TABLE public.historia
//(
//id numeric NOT NULL,
//  kaavatunnus character varying(10) NOT NULL, -- LUPLANVIEW / LUPLANLABEL ja PERUSCSV / Kunnan kaavatunnus
//  kaavanimi character varying(255), -- LUPLANVIEW / LUPLANNAME
//  lisatieto character varying(255), -- valmistelijalta tekstiä
//  hankkeenkuvaus character varying, -- valmistelijalta tekstiä
//  kaavatyyppi character varying(255), -- Valintalista: Priorisoidut kohteet;Lautakunnasta edenneet kohteet;Muut merkittävät kohteet;Pienehköt tai teknisluonteiset kohteet
//  suunnittelualue integer, -- 1,2,3,4,5,6 tai 7
//  aikaleima date
//  );



package ksk;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author saara
 */
@Entity
@Table(name = "historia")
public class Historia implements Serializable{

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private int id;

    @Column(name = "kaavatunnus")
    private String kaavatunnus;

    @Column(name = "kaavanimi")
    private String kaavanimi;

    @Column(name = "lisatieto")
    private String lisatieto;

    @Column(name = "hankkeenkuvaus")
    private String hankkeenkuvaus;

    @Column(name = "kaavatyyppi")
    private String kaavatyyppi;

    @Column(name = "suunnittelualue")
    private String suunnittelualue;

    // timestamp muutokselle
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "aikaleima")
    private Date aikaleima;

    public Historia() {
    }

    
    public Historia(int id, String kaavatunnus, String kaavanimi, String lisatieto, String hankkeenkuvaus, String kaavatyyppi, String suunnittelualue, Date aikaleima) {
        this.id = id;
        this.kaavatunnus = kaavatunnus;
        this.kaavanimi = kaavanimi;
        this.lisatieto = lisatieto;
        this.hankkeenkuvaus = hankkeenkuvaus;
        this.kaavatyyppi = kaavatyyppi;
        this.suunnittelualue = suunnittelualue;
        this.aikaleima = aikaleima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKaavatunnus() {
        return kaavatunnus;
    }

    public void setKaavatunnus(String kaavatunnus) {
        this.kaavatunnus = kaavatunnus;
    }

    public String getKaavanimi() {
        return kaavanimi;
    }

    public void setKaavanimi(String kaavanimi) {
        this.kaavanimi = kaavanimi;
    }

    public String getLisatieto() {
        return lisatieto;
    }

    public void setLisatieto(String lisatieto) {
        this.lisatieto = lisatieto;
    }

    public String getHankkeenkuvaus() {
        return hankkeenkuvaus;
    }

    public void setHankkeenkuvaus(String hankkeenkuvaus) {
        this.hankkeenkuvaus = hankkeenkuvaus;
    }

    public String getKaavatyyppi() {
        return kaavatyyppi;
    }

    public void setKaavatyyppi(String kaavatyyppi) {
        this.kaavatyyppi = kaavatyyppi;
    }

    public String getSuunnittelualue() {
        return suunnittelualue;
    }

    public void setSuunnittelualue(String suunnittelualue) {
        this.suunnittelualue = suunnittelualue;
    }

    public Date getAikaleima() {
        return aikaleima;
    }

    public void setAikaleima(Date aikaleima) {
        this.aikaleima = aikaleima;
    }
    
    
}
