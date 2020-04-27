package Gnadig.DTO;

import Gnadig.model.KiKolcsonzott;
import Gnadig.model.Kolcsonzes;
import Gnadig.model.Konyvek;
import Gnadig.model.Tagok;

import java.util.ArrayList;
import java.util.List;

public class GenerateKiKolcsonzottLista {

    private static List<Tagok> tagok;
    private static List<Konyvek> konyveks;
    private static List<Kolcsonzes> kolcsonzes;

    private static List<KiKolcsonzott> kiKolcsonzottList;

    private static void getTagok(){ tagok = DTOTagok.getOsszesTag(); }
    private static void getKonyvek(){ konyveks = DTOKonyvek.getAllKonyvek(); }
    private static void getKolcsonzes(){
        kolcsonzes = DTOKolcsonzes.getAllKolcsonzes();
    }

    public static List<KiKolcsonzott> generateKiKolcsonzott(){

        getTagok();
        getKonyvek();
        getKolcsonzes();

        KiKolcsonzott kiKolcsonzott;
        kiKolcsonzottList = new ArrayList<>();
        for (Kolcsonzes kolcson: kolcsonzes) {
            for(Tagok tag: tagok){
                for(Konyvek konyv: konyveks){
                    if(kolcson.getTagid() == tag.getId() && kolcson.getKonyvid() == konyv.getId()){
                        kiKolcsonzott = new KiKolcsonzott(
                                kolcson.getId(),
                                tag.getId(),
                                konyv.getId(),
                                konyv.getSzerzo(),
                                konyv.getCim(),
                                konyv.getSorszam(),
                                konyv.getStatusz(),
                                kolcson.getKezdes(),
                                kolcson.getHatarido());
                        kiKolcsonzottList.add(kiKolcsonzott);
                    }
                }
            }
        }
        return kiKolcsonzottList;
    }
}
