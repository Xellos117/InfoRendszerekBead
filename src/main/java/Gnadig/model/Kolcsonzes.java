package Gnadig.model;




import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "kolcsonzes", schema = "konyvtar")
public class Kolcsonzes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "tagid")
    private int tagid;

    @Column(name = "konyvid")
    private int konyvid;

    @Column(name = "kezdes")
    private Date kezdes;

    @Column(name = "hatarido")
    private Date hatarido;


    public Kolcsonzes(){
    }

    public Kolcsonzes(int tagid, int konyvid, Date kezdes, Date hatarido){
        this.tagid=tagid;
        this.konyvid=konyvid;
        this.kezdes=kezdes;
        this.hatarido=hatarido;
    }


    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public int getKonyvid() {
        return konyvid;
    }

    public void setKonyvid(int konyvid) {
        this.konyvid = konyvid;
    }

    public Date getKezdes() {
        return kezdes;
    }

    public void setKezdes(Date kezdes) {
        this.kezdes = kezdes;
    }

    public Date getHatarido() {
        return hatarido;
    }

    public void setHatarido(Date hatarido) {
        this.hatarido = hatarido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolcsonzes that = (Kolcsonzes) o;
        return id == that.id &&
                tagid == that.tagid &&
                konyvid == that.konyvid &&
                kezdes.equals(that.kezdes) &&
                hatarido.equals(that.hatarido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagid, konyvid, kezdes, hatarido);
    }

    @Override
    public String toString() {
        return "Kolcsonzes{" +
                "id=" + id +
                ", tagid=" + tagid +
                ", konyvid=" + konyvid +
                ", kezdes=" + kezdes +
                ", hatarido=" + hatarido +
                '}';
    }
}//end kolcsonzes
