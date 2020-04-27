package Gnadig.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tagok", schema = "konyvtar")
public class Tagok {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "telefonszam")
    private String telefonszam;

    @Column(name = "szemelyig")
    private String szemelyig;

    @Column(name = "lakcim")
    private String lakcim;

    public Tagok(){}

    public Tagok(String nev, String telefonszam, String szemelyig, String lakcim) {
        this.nev = nev;
        this.telefonszam = telefonszam;
        this.szemelyig = szemelyig;
        this.lakcim = lakcim;
    }

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getSzemelyig() {
        return szemelyig;
    }

    public void setSzemelyig(String szemelyig) {
        this.szemelyig = szemelyig;
    }

    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tagok tagok = (Tagok) o;
        return id == tagok.id &&
                nev.equals(tagok.nev) &&
                telefonszam.equals(tagok.telefonszam) &&
                szemelyig.equals(tagok.szemelyig) &&
                lakcim.equals(tagok.lakcim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, telefonszam, szemelyig, lakcim);
    }

    @Override
    public String toString() {
        return "Tagok{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", telefonszam='" + telefonszam + '\'' +
                ", szemelyig='" + szemelyig + '\'' +
                ", lakcim='" + lakcim + '\'' +
                '}';
    }
}//end class Tagok
