package Gnadig.view;

import Gnadig.model.Konyvek;
import Gnadig.service.KonyvService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;



    @ManagedBean(name="konyvView")
    @SessionScoped
    public class KonyvekView  implements Serializable {

        private ArrayList<Konyvek> konyvek;
        private Konyvek editedKonyv = new Konyvek();
        private boolean konyvekIsEdited = false;
        private Konyvek ujKonyv = new Konyvek();

        @ManagedProperty("#{konyvService}")
        private KonyvService service;

        public ArrayList<Konyvek> getKonyvek(){
            konyvek = service.getKonyvek();
            return konyvek;
        }

        public String addKonyv(){
            service.addKonyv(ujKonyv);
            ujKonyv = new Konyvek();
            return "konyvek?faces-redirect=true";
        }

        public String deleteKonyv(Konyvek konyv){
            service.deleteKonyv(konyv);
            return "konyvek?faces-redirect=true";
        }

        public String selectKonyvToedit(Konyvek konyv){
            konyvekIsEdited = true;
            editedKonyv = konyv;
            return "konyvek?faces-redirect=true";
        }

        public String saveEditedKonyv(){
            service.editKonyv(editedKonyv);
            editedKonyv = new Konyvek();
            konyvekIsEdited = false;
            return "konyvek?faces-redirect=true";
        }

        public void setService(KonyvService service){
            this.service = service;
        }



        //Getters and Setters


        public void setKonyvek(ArrayList<Konyvek> konyvek) {
            this.konyvek = konyvek;
        }

        public Konyvek getEditedKonyv() {
            return editedKonyv;
        }

        public void setEditedKonyv(Konyvek editedKonyv) {
            this.editedKonyv = editedKonyv;
        }

        public boolean isKonyvekIsEdited() {
            return konyvekIsEdited;
        }

        public void setKonyvekIsEdited(boolean konyvekIsEdited) {
            this.konyvekIsEdited = konyvekIsEdited;
        }

        public Konyvek getUjKonyv() {
            return ujKonyv;
        }

        public void setUjKonyv(Konyvek ujKonyv) {
            this.ujKonyv = ujKonyv;
        }

        public KonyvService getService() {
            return service;
        }
    }
