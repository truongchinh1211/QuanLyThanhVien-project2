/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.HibernateConfig;
import java.util.List;
import model.ThietBi;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Son
 */
public class ThietBiDAO {
    public List<ThietBi> getAll() throws Exception {
       List<ThietBi> thietBis = null;
       try (Session session = HibernateConfig.getSessionFactory().openSession()) {
           thietBis = session.createQuery("from ThietBi", ThietBi.class).list();
       } catch (Exception e) {
           throw new Exception("Error retrieving ThietBi list: " + e.getMessage());
       }
       return thietBis;
   }
   
    public List<ThietBi> getAll(String fieldName, Object value) throws Exception {
      List<ThietBi> thietBis = null;
      try (Session session = HibernateConfig.getSessionFactory().openSession()) {
          String hql = "from ThietBi where " + fieldName + " = :value";
          Query<ThietBi> query = session.createQuery(hql, ThietBi.class);
          query.setParameter("value", value);
          thietBis = query.list();
      } catch (Exception e) {
          throw new Exception("Error retrieving ThietBi list: " + e.getMessage());
      }
      return thietBis;
    }
    
    public List<ThietBi> getByFilter(String fieldName, Object value) throws Exception {
        List<ThietBi> thietBis = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThietBi where lower(" + fieldName + ") like lower(:value)";
            Query<ThietBi> query = session.createQuery(hql, ThietBi.class);
            query.setParameter("value", "%" + value + "%");
            thietBis = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThietBi list: " + e.getMessage());
        }
        return thietBis;
    }
    
    public ThietBi getOne(String fieldName, Object value) throws Exception {
        ThietBi thietBi = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThietBi where " + fieldName + " = :value";
            Query<ThietBi> query = session.createQuery(hql, ThietBi.class);
            query.setParameter("value", value);
            query.setMaxResults(1);
            thietBi = query.uniqueResult();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThietBi: " + e.getMessage());
        }
        return thietBi;
    }
    
    public Boolean add(ThietBi thietBi) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(thietBi);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(thietBi.getMaTB()+": " + e.getMessage());
        }
    }
    
    public Boolean update(ThietBi thietBi) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(thietBi);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(thietBi.getMaTB()+": " + e.getMessage());
        }
    }

    public Boolean delete(ThietBi thietBi) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(thietBi);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(thietBi.getMaTB()+": " + e.getMessage());
        }
    }
}


