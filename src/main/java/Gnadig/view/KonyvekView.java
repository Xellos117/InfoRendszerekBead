package Gnadig.view;

import Gnadig.model.Konyvek;
import Gnadig.service.KonyvService;
import org.hibernate.service.spi.InjectService;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

      /*  public void onRowEdit(RowEditEvent<Konyvek> event) {
            FacesMessage msg = new FacesMessage("Konyvek Edited", event.getObject().getIdToString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //konyvek.set(event.getObject().getId(),event.getObject());


        }

        public void onRowCancel(RowEditEvent<Konyvek> event) {
            FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getIdToString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        public void onCellEdit(CellEditEvent event) {
            Object oldValue = event.getOldValue();
            Object newValue = event.getNewValue();

            if(newValue != null && !newValue.equals(oldValue)) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }*/

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
