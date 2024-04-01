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
import utils.Response;

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
        e.printStackTrace();
        throw new Exception("Error retrieving ThanhVien list:"+ e.getMessage());
    }
    return thanhViens;
}
    public ThanhVien getById(int id) throws Exception {
        ThanhVien thanhVien = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            thanhVien = session.get(ThanhVien.class, id);
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
            throw new Exception("Lỗi xảy ra khi thêm:"+ e.getMessage());
        }
    }

}
