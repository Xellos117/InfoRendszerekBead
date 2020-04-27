package Gnadig.view;

import Gnadig.model.KiKolcsonzott;
import Gnadig.model.Konyvek;
import Gnadig.model.Tagok;
import Gnadig.service.TagService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;

@ManagedBean(name = "tagView")
@SessionScoped
public class TagView {
    private ArrayList<Tagok> tagok;

    private Tagok kivalasztottTag;
    private ArrayList<KiKolcsonzott> kivalasztottTagKolcsonzesei;

    private Tagok szerksztettTag;
    private Tagok ujTag = new Tagok();
    private boolean edit = false;

    @ManagedProperty("#{tagService}")
    private TagService services;

    public ArrayList<Tagok> getTagok(){
        tagok = services.getTagok();
        return tagok;
    }

    public String addTag(){
        services.addTag(ujTag);
        ujTag = new Tagok();
        return "tagok?faces-redirect=true\"";
    }

    public String deleteTag(Tagok tag){
        System.out.println(tag.toString());
        services.deleteTag(tag);
        return "tagok?faces-redirect=true";
    }


    public String szerkeszthetosegTiltasa(){
        edit = !edit;
        szerksztettTag = kivalasztottTag;
        return "tag_data?faces-redirect=true";
    }

    public String saveTag(){
        System.out.println("Tagok mentése: " + szerksztettTag);
        services.editTag(szerksztettTag);
        szerkeszthetosegTiltasa();
        return "tag_data?faces-redirect=true";
    }

    // To show tag data + kikolcsonzott konyv
    public String dataTag(Tagok tag){
        System.out.println("kivalasztott tag: " + tag.toString());
        kivalasztottTag = tag;
        getKikolcsonzottTagIdAlapjan();
        return "tag_data?faces-redirect=true";
    }

    public ArrayList<KiKolcsonzott> getKikolcsonzottTagIdAlapjan(){
        kivalasztottTagKolcsonzesei = services.getKiKolcsonzott(kivalasztottTag);
        return kivalasztottTagKolcsonzesei;
    }
    //-------------------//

    public void setDataTag(Tagok tag){
        kivalasztottTag = tag;
    }

    //To Save Renting to database and get selected client renting.
    public String saveRenting(Konyvek konyvek){
        services.saveKolcsonzes(konyvek,kivalasztottTag);
        getKikolcsonzottTagIdAlapjan();
        return "tag_data?faces-redirect=true";
    }

    //To delete renting from database and remove renting from selectedClientRenting list.
    public String deleteRenting(KiKolcsonzott kolcsonzott){
        services.deleteKolcsonzes(kolcsonzott);
        kivalasztottTagKolcsonzesei.remove(kolcsonzott);
        return "tag_data?faces-redirect=true";

    }

    //To get days from end
    public int getNapokHatarIdoig(Date date){
        return (int) services.getIdoTulLepes(date);
    }

    //Getters and Setters


    public void setTagok(ArrayList<Tagok> tagok) {
        this.tagok = tagok;
    }

    public Tagok getKivalasztottTag() {
        return kivalasztottTag;
    }

    public void setKivalasztottTag(Tagok kivalasztottTag) {
        this.kivalasztottTag = kivalasztottTag;
    }

    public ArrayList<KiKolcsonzott> getKivalasztottTagKolcsonzesei() {
        return kivalasztottTagKolcsonzesei;
    }

    public void setKivalasztottTagKolcsonzesei(ArrayList<KiKolcsonzott> kivalasztottTagKolcsonzesei) {
        this.kivalasztottTagKolcsonzesei = kivalasztottTagKolcsonzesei;
    }

    public Tagok getSzerksztettTag() {
        return szerksztettTag;
    }

    public void setSzerksztettTag(Tagok szerksztettTag) {
        this.szerksztettTag = szerksztettTag;
    }

    public Tagok getUjTag() {
        return ujTag;
    }

    public void setUjTag(Tagok ujTag) {
        this.ujTag = ujTag;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public TagService getServices() {
        return services;
    }

    public void setServices(TagService services) {
        this.services = services;
    }
}
