/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.HibernateConfig;
import java.util.List;
import model.ThanhVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Bum
 */
public class ThanhVienDAO {
    public List<ThanhVien> getAll() throws Exception {
       List<ThanhVien> thanhViens = null;
       try (Session session = HibernateConfig.getSessionFactory().openSession()) {
           thanhViens = session.createQuery("from ThanhVien", ThanhVien.class).list();
       } catch (Exception e) {
           throw new Exception("Error retrieving ThanhVien list:"+ e.getMessage());
       }
       return thanhViens;
   }
    public List<ThanhVien> getAll(String fieldName, Object value) throws Exception {
      List<ThanhVien> thanhViens = null;
      try (Session session = HibernateConfig.getSessionFactory().openSession()) {
          String hql = "from ThanhVien where " + fieldName + " = :value";
          Query<ThanhVien> query = session.createQuery(hql, ThanhVien.class);
          query.setParameter("value", value);
          thanhViens = query.list();
      } catch (Exception e) {
          throw new Exception("Error retrieving ThanhVien list:"+ e.getMessage());
      }
      return thanhViens;
    }
    public List<ThanhVien> getByFilter(String fieldName, Object value) throws Exception {
        List<ThanhVien> thanhViens = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThanhVien where lower(" + fieldName + ") like lower(:value)";
            Query<ThanhVien> query = session.createQuery(hql, ThanhVien.class);
            query.setParameter("value", "%" + value + "%");
            thanhViens = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThanhVien list:"+ e.getMessage());
        }
        return thanhViens;
    }
    public ThanhVien getOne(String fieldName, Object value) throws Exception {
        ThanhVien thanhVien = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThanhVien where " + fieldName + " = :value";
            Query<ThanhVien> query = session.createQuery(hql, ThanhVien.class);
            query.setParameter("value", value);
            query.setMaxResults(1);
            thanhVien = query.uniqueResult();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThanhVien list:"+ e.getMessage());
        }
        return thanhVien;
    }
    
    public int generateNewMemberCode() throws Exception {
        int newMemberCode = 0;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select max(MaTV) from ThanhVien";
            Integer maxMemberCode = (Integer) session.createQuery(hql).uniqueResult();
            System.out.println(maxMemberCode);
            if (maxMemberCode != null) {
                newMemberCode = 1+maxMemberCode;
                System.out.println(newMemberCode);
            } else {
                newMemberCode = 1;
            }
            transaction.commit();
        } catch (Exception e) {
            throw new Exception("Error generating new member code: " + e.getMessage());
        }
        return newMemberCode;
    }
    public Boolean add(ThanhVien thanhVien) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(thanhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi thêm:"+ e.getMessage());
        }
    }
    public Boolean update(ThanhVien thanhVien) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(thanhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi cập nhật:"+ e.getMessage());
        }
    }

    public Boolean delete(ThanhVien thanhVien) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(thanhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi xóa:"+ e.getMessage());
        }
    }

}
