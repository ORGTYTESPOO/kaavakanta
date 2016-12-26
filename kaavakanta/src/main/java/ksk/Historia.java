/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksk;

import java.util.Date;

/**
 *
 * @author saara
 */
public class Historia {
    
    private int id;
    private String kaavatunnus;
    private String kaavanimi;
    private String lisatieto;
    private String hankkeenkuvaus;
    private String kaavatyyppi;
    private String suunnittelualue;
    private Date aikaleima;

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

    public Historia() {
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
