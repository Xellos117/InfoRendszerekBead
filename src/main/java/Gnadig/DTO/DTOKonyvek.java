package Gnadig.DTO;

import Gnadig.dataConnect.HibernateUtil;
import Gnadig.model.Konyvek;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DTOKonyvek {

    private static List<Konyvek> konyvek;
    private static Calendar naptar = Calendar.getInstance();
    private static java.sql.Date date = new java.sql.Date(naptar.getTime().getTime());

    public static List<Konyvek> getAllKonyvek(){
        konyvek = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            konyvek = session.createQuery("from Konyvek",Konyvek.class).list();
        }catch (Exception e){
            System.out.println("DTOKonyvek üzibüzi: "+e.getMessage());
        }
        return konyvek;
    }//end getALLKonyvek!!!

    public static void addKonyvToDB(Konyvek konyv){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(konyv);
            transaction.commit();
        }catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            System.out.println("könyv hozzadas Exception"+e.getMessage());
        }
    }

    public static void deleteKonyv(Konyvek konyv){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Konyvek deleteKonyv = (Konyvek)session.load(Konyvek.class,konyv.getId());
            session.delete(deleteKonyv);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("konyv törlés exception: " + e.getMessage());
        }
    }

    public static void editKonyv(Konyvek konyv){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(konyv);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("könyv törlés exception: " + e.getMessage());
        }
    }

    public static void setKonyvToRented(int konyvID){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Konyvek updatedkonyv = (Konyvek) session.load(Konyvek.class,konyvID);
            updatedkonyv.setStatusz("Rented");
            session.update(updatedkonyv);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("könyv státusz update exception: " + e.getMessage());
        }
    }

    public static void setKonyvToAvailable(int konyvID){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Konyvek updatedmovie = (Konyvek)session.load(Konyvek.class,konyvID);
            updatedmovie.setStatusz("Available");
            session.update(updatedmovie);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("könyv státusz update exception: " + e.getMessage());
        }
    }


}//end class DTOKonyvek
