package Gnadig.service;

import Gnadig.DTO.DTOKonyvek;
import Gnadig.model.Konyvek;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name = "konyvService")
@ApplicationScoped
public class KonyvService {
    private ArrayList<Konyvek> konyvek;

    public ArrayList<Konyvek> getKonyvek(){
        konyvek = (ArrayList<Konyvek>) DTOKonyvek.getAllKonyvek();
        return konyvek;
    }

    public void addKonyv(Konyvek konyv){
        DTOKonyvek.addKonyvToDB(konyv);
    }
    public void deleteKonyv(Konyvek konyv){
        DTOKonyvek.deleteKonyv(konyv);
    }

    public void editKonyv(Konyvek konyv){
        DTOKonyvek.editKonyv(konyv);
    }




}
