/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.HibernateConfig;
import java.util.List;
import model.XuLy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Son
 */
public class XuLyDAO {
    public List<XuLy> getAll() throws Exception {
        List<XuLy> xuLys = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            xuLys = session.createQuery("from XuLy", XuLy.class).list();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return xuLys;
    }
    public List<XuLy> getAll(String fieldName, Object value) throws Exception {
        List<XuLy> xuLys = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from XuLy where " + fieldName + " = :value";
            Query<XuLy> query = session.createQuery(hql, XuLy.class);
            query.setParameter("value", value);
            xuLys = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving XuLy list: " + e.getMessage());
        }
        return xuLys;
    }
    public List<XuLy> getByFilter(String fieldName, Object value) throws Exception {
        List<XuLy> xuLys = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from XuLy where lower(" + fieldName + ") like lower(:value)";
            Query<XuLy> query = session.createQuery(hql, XuLy.class);
            query.setParameter("value", "%" + value + "%");
            xuLys = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving XuLy list: " + e.getMessage());
        }
        return xuLys;
    }
    public XuLy getOne(String fieldName, Object value) throws Exception {
        XuLy xuLy = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from XuLy where " + fieldName + " = :value";
            Query<XuLy> query = session.createQuery(hql, XuLy.class);
            query.setParameter("value", value);
            query.setMaxResults(1);
            xuLy = query.uniqueResult();
        } catch (Exception e) {
            throw new Exception("Error retrieving XuLy: " + e.getMessage());
        }
        return xuLy;
    }
    public long generateNewId() throws Exception {
        long newMemberCode = 0;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "select max(MaXL) from XuLy";
            Long maxMemberCode = (Long) session.createQuery(hql).uniqueResult();
            if (maxMemberCode != null) {
                newMemberCode = 1 + maxMemberCode;
            } else {
                newMemberCode = 1;
            }
            transaction.commit();
        } catch (Exception e) {
            throw new Exception("Error generating new member code: " + e.getMessage());
        }
        return newMemberCode;
    }
    
    public Boolean add(XuLy xuLy) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(xuLy);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi thêm: " + e.getMessage());
        }
    }
    public Boolean update(XuLy xuLy) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(xuLy);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi cập nhật: " + e.getMessage());
        }
    }
    public Boolean delete(XuLy xuLy) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(xuLy);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi xóa: " + e.getMessage());
        }
    }
    public XuLy getLatestRecordByMaTV(long maTV) throws Exception {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        String hql = "FROM XuLy WHERE thanhVien.MaTV = :maTV AND TrangThaiXL = 0 ORDER BY NgayXL DESC";
        Query<XuLy> query = session.createQuery(hql, XuLy.class);
        query.setParameter("maTV", maTV);
        query.setMaxResults(1); // Chỉ lấy bản ghi đầu tiên
        return query.uniqueResult();
    } catch (Exception e) {
        throw new Exception("Lỗi khi truy vấn bản ghi mới nhất: " + e.getMessage());
    }
}
}
