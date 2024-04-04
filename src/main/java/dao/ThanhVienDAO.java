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
    public ThanhVien getById(int id) throws Exception {
        ThanhVien thanhVien = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            thanhVien = session.get(ThanhVien.class, id);
        } catch (Exception e) {
            throw new Exception("Error retrieving ThanhVien list:"+ e.getMessage());
        }
        return thanhVien;
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
