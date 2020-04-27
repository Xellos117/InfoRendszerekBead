package Gnadig.model;

import java.util.Date;


public class KiKolcsonzott {
    private int id;
    private int tagID;
    private int konyvID;
    private String konyvSzerzo;
    private String konyvCim;
    private String konyvSorszam;
    private String konyvStatusz;
    private Date kolcsonzesKezdete;
    private Date getKolcsonzesVege;

    public KiKolcsonzott(int id, int tagID, int konyvID, String konyvSzerzo, String konyvCim, String konyvSorszam, String konyvStatusz, Date kolcsonzesKezdete, Date getKolcsonzesVege) {
        this.id = id;
        this.tagID = tagID;
        this.konyvID = konyvID;
        this.konyvSzerzo = konyvSzerzo;
        this.konyvCim = konyvCim;
        this.konyvSorszam = konyvSorszam;
        this.konyvStatusz = konyvStatusz;
        this.kolcsonzesKezdete = kolcsonzesKezdete;
        this.getKolcsonzesVege = getKolcsonzesVege;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public int getKonyvID() {
        return konyvID;
    }

    public void setKonyvID(int konyvID) {
        this.konyvID = konyvID;
    }

    public String getKonyvSzerzo() {
        return konyvSzerzo;
    }

    public void setKonyvSzerzo(String konyvSzerzo) {
        this.konyvSzerzo = konyvSzerzo;
    }

    public String getKonyvCim() {
        return konyvCim;
    }

    public void setKonyvCim(String konyvCim) {
        this.konyvCim = konyvCim;
    }

    public String getKonyvSorszam() {
        return konyvSorszam;
    }

    public void setKonyvSorszam(String konyvSorszam) {
        this.konyvSorszam = konyvSorszam;
    }

    public String getKonyvStatusz() {
        return konyvStatusz;
    }

    public void setKonyvStatusz(String konyvStatusz) {
        this.konyvStatusz = konyvStatusz;
    }

    public Date getKolcsonzesKezdete() {
        return kolcsonzesKezdete;
    }

    public void setKolcsonzesKezdete(Date kolcsonzesKezdete) {
        this.kolcsonzesKezdete = kolcsonzesKezdete;
    }

    public Date getGetKolcsonzesVege() {
        return getKolcsonzesVege;
    }

    public void setGetKolcsonzesVege(Date getKolcsonzesVege) {
        this.getKolcsonzesVege = getKolcsonzesVege;
    }
}
