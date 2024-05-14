/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.HibernateConfig;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import model.ThongTinSD;
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
    public long thongKeSoLuongXLChuaXuLi(LocalDateTime startTime, LocalDateTime endTime) throws Exception {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(xl) " +
                         "FROM XuLy xl " +
                         "WHERE xl.NgayXL BETWEEN :startTime AND :endTime AND xl.TrangThaiXuLi = 0";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("startTime", startTime);
            query.setParameter("endTime", endTime);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error retrieving số lượng bản ghi chưa xử lí trong khoảng thời gian: " + e.getMessage());
        }
    }

    public List<Object[]> thongKeSoLuongXLDaXuLi(LocalDateTime startTime, LocalDateTime endTime) throws Exception {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(xl.MaXL), SUM(xl.SoTien) " +
                         "FROM XuLy xl " +
                         "WHERE xl.TrangThaiXuLi = 1 AND xl.NgayXL BETWEEN :startTime AND :endTime";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("startTime", startTime);
            query.setParameter("endTime", endTime);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error retrieving thống kê số lượng bản ghi đã xử lí: " + e.getMessage());
        }
    }
    public List<ThongTinSD> timThietBiDaTraTrongHomNay(String keyword) throws Exception {
        LocalDateTime today = LocalDateTime.now();
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "SELECT t FROM ThongTinSD t WHERE t.TGMuon >= :today AND t.TGTra < :atMoment";
            if (keyword != null && !keyword.isEmpty()) {
                hql += " AND t.thietBi.TenTB LIKE :keyword";
            }
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            query.setParameter("today", today.toLocalDate().atStartOfDay());
            query.setParameter("atMoment", today);
            if (keyword != null && !keyword.isEmpty()) {
                query.setParameter("keyword", "%" + keyword + "%");
            }
            return query.getResultList();
        }
        catch (Exception e) {
                throw new Exception("Error retrieving thống kê số lượng bản ghi đã xử lí: " + e.getMessage());
            }
        }
    public List<ThongTinSD> timThietBiChuaTra(String keyword) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "SELECT t FROM ThongTinSD t WHERE t.TGTra is null";
            if (keyword != null && !keyword.isEmpty()) {
                hql += " AND t.thietBi.TenTB LIKE :keyword";
            }
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            query.setParameter("now", now);
            if (keyword != null && !keyword.isEmpty()) {
                query.setParameter("keyword", "%" + keyword + "%");
            }
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error retrieving thống kê số lượng bản ghi đã xử lí: " + e.getMessage());
        }
    }
}
    

