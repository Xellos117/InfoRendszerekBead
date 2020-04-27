package Gnadig.service;

import Gnadig.DTO.DTOKolcsonzes;
import Gnadig.DTO.DTOKonyvek;
import Gnadig.DTO.DTOTagok;
import Gnadig.DTO.GenerateKiKolcsonzottLista;
import Gnadig.model.KiKolcsonzott;
import Gnadig.model.Kolcsonzes;
import Gnadig.model.Konyvek;
import Gnadig.model.Tagok;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@ManagedBean(name = "tagService")
@ApplicationScoped

public class TagService {
    public ArrayList<Tagok> getTagok(){
        ArrayList<Tagok> tagok = (ArrayList<Tagok>) DTOTagok.getOsszesTag();
        return tagok;
    }

    public ArrayList<KiKolcsonzott> getKiKolcsonzott(Tagok tag){
        ArrayList<KiKolcsonzott> kiKolcsonzott = (ArrayList<KiKolcsonzott>) GenerateKiKolcsonzottLista.generateKiKolcsonzott();
        ArrayList<KiKolcsonzott> tagKolcsonzesei = new ArrayList<>();

        for(KiKolcsonzott kolcsonzes: kiKolcsonzott){
            if(kolcsonzes.getTagID() == tag.getId()){
                tagKolcsonzesei.add(kolcsonzes);
            }
        }
        return tagKolcsonzesei;
    }

    public void addTag(Tagok tag){
        DTOTagok.addTagToDB(tag);
    }

    public void deleteTag(Tagok tag){
        DTOTagok.deleteTag(tag);
    }

    public void editTag(Tagok tag) { DTOTagok.editTag(tag);}

    public void saveKolcsonzes(Konyvek konyv, Tagok kivalasztottTag){
        System.out.println("konyv= "+konyv);
        System.out.println("kivalasztott tag= "+kivalasztottTag);
        Kolcsonzes kolcsonzes;
        Date dateStart = new Date();

        Date dateEnd = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateEnd);
        c.add(Calendar.DATE, 21);
        dateEnd = c.getTime();

        kolcsonzes = new Kolcsonzes(kivalasztottTag.getId(),konyv.getId(),dateStart,dateEnd);
        DTOKolcsonzes.addKolcsonzesToDB(kolcsonzes);
        DTOKonyvek.setKonyvToRented(konyv.getId());

    }
    public void deleteKolcsonzes(KiKolcsonzott kiKolcsonzott){
        DTOKolcsonzes.dateKolcsonzes(kiKolcsonzott.getId());
        DTOKonyvek.setKonyvToAvailable(kiKolcsonzott.getKonyvID());
    }

    public long getIdoTulLepes(Date hatarido){
        Date mai = new Date();
        long diff = 0;
        if(mai.compareTo(hatarido) >= 1){
            long diffInMillies = Math.abs(mai.getTime() - hatarido.getTime());
            diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        }
        return diff;
    }


}//end class
