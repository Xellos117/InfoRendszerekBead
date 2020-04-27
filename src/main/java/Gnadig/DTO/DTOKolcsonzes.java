package Gnadig.DTO;

import Gnadig.dataConnect.HibernateUtil;
import Gnadig.model.Kolcsonzes;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DTOKolcsonzes {

    private static List<Kolcsonzes> kolcsonzes;

    public static List<Kolcsonzes> getAllKolcsonzes(){
        kolcsonzes = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            kolcsonzes = session.createQuery("from Kolcsonzes ",Kolcsonzes.class).list();
        }catch(Exception e){
            e.getMessage();
        }
        return kolcsonzes;
    }

    public static void dateKolcsonzes(int kolcsonzesId){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Kolcsonzes deletedKolcsonzes = (Kolcsonzes)session.load(Kolcsonzes.class, kolcsonzesId);
            session.delete(deletedKolcsonzes);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.getMessage();
        }
    }

    public static void addKolcsonzesToDB(Kolcsonzes kolcsonzes){
        System.out.println("kolcsonzes = "+kolcsonzes);
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(kolcsonzes);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.getMessage();
        }
    }
}
