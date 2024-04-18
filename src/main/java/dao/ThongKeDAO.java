/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.HibernateConfig;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Son
 */
public class ThongKeDAO {
    public List<Object[]> thongKeSoLuongTVTheoKhoa(LocalDateTime startTime, LocalDateTime endTime) throws Exception {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "SELECT t.thanhVien.Khoa, COUNT(t.thanhVien.MaTV) " +
                        "FROM ThongTinSD t " +
                        "WHERE t.TGVao BETWEEN :startTime AND :endTime " +
                        "GROUP BY t.thanhVien.Khoa";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("startTime", startTime);
            query.setParameter("endTime", endTime);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error retrieving số lượng theo khoa: " + e.getMessage());
        }
    }
    public List<Object[]> thongKeSoLuongTVTheoNganh(LocalDateTime startTime, LocalDateTime endTime) throws Exception {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "SELECT t.thanhVien.Nganh, COUNT(t.thanhVien.MaTV) " +
                         "FROM ThongTinSD t " +
                         "WHERE t.TGVao BETWEEN :startTime AND :endTime " +
                         "GROUP BY t.thanhVien.Nganh";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("startTime", startTime);
            query.setParameter("endTime", endTime);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error retrieving số lượng theo ngành trong khoảng thời gian: " + e.getMessage());
        }
    }
}
