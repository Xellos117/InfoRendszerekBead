package Gnadig.DTO;

import Gnadig.dataConnect.HibernateUtil;
import Gnadig.model.Tagok;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DTOTagok {
    private  static List<Tagok> tagok;

    public static List<Tagok> getOsszesTag(){
        tagok = new ArrayList<Tagok>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tagok = session.createQuery("from Tagok",Tagok.class).list();

        }catch (Exception e){
            System.out.println(e.getMessage()+"DTOTagok Message");
        }
        return tagok;
    }//end list<Tagok>

    public static void addTagToDB(Tagok tag){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            System.out.println(tag.toString());
            session.save(tag);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            System.out.println("Tag hozzáadása Exception, Message: " + e.getMessage());
        }
    }//end addTagoktoDB

    public static void deleteTag(Tagok tag){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Tagok deletedTag = (Tagok)session.load(Tagok.class,tag.getId());
            session.delete(deletedTag);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Tag törlés exception: " + e.getMessage());
        }
    }

    public static void editTag(Tagok tag){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(tag);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Tag szerkesztés exception: " + e.getMessage());
        }
    }


}//end DTOTagok
