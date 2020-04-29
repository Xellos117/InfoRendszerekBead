package Gnadig.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "konyvek", schema = "konyvtar")
public class Konyvek {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipus")
    private String tipus;

    @Column(name = "szerzo")
    private String szerzo;

    @Column(name = "cim")
    private String cim;

    @Column(name = "beszerzes")
    private Date beszerzes;

    @Column(name = "sorszam")
    private String sorszam;

    @Column(name = "statusz")
    private String statusz;

    public Konyvek(){}

    public Konyvek(String tipus, String szerzo, String cim, Date beszerzes, String sorszam, String statusz) {
        this.tipus = tipus;
        this.szerzo = szerzo;
        this.cim = cim;
        this.beszerzes = beszerzes;
        this.sorszam = sorszam;
        this.statusz = statusz;
    }

    //getter seter

    public int getId() {
        return id;
    }

    public String getIdToString(){
        return String.valueOf(getId());
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }


    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }


    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public Date getBeszerzes() {
        return beszerzes;
    }

    public void setBeszerzes(Date beszerzes) {
        this.beszerzes = beszerzes;
    }


    public String getSorszam() {
        return sorszam;
    }

    public void setSorszam(String sorszam) {
        this.sorszam = sorszam;
    }


    public String getStatusz() {
        return statusz;
    }

    public void setStatusz(String statusz) {
        this.statusz = statusz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Konyvek konyvek = (Konyvek) o;
        return id == konyvek.id &&
                tipus.equals(konyvek.tipus) &&
                szerzo.equals(konyvek.szerzo) &&
                cim.equals(konyvek.cim) &&
                beszerzes.equals(konyvek.beszerzes) &&
                sorszam.equals(konyvek.sorszam) &&
                statusz.equals(konyvek.statusz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipus, szerzo, cim, beszerzes, sorszam, statusz);
    }

    @Override
    public String toString() {
        return "Konyvek{" +
                "id=" + id +
                ", tipus='" + tipus + '\'' +
                ", szerzo='" + szerzo + '\'' +
                ", cim='" + cim + '\'' +
                ", beszerzes=" + beszerzes +
                ", sorszam='" + sorszam + '\'' +
                ", statusz='" + statusz + '\'' +
                '}';
    }
}//end class konyvek
