/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.HibernateConfig;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import model.ThongTinSD;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Son
 */
public class ThongTinSDDAO {
    public List<ThongTinSD> getAll() throws Exception {
        List<ThongTinSD> thongTinSDs = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            thongTinSDs = session.createQuery("from ThongTinSD", ThongTinSD.class).list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD list: " + e.getMessage());
        }
        return thongTinSDs;
    }
    
    public List<ThongTinSD> getAll(String fieldName, Object value) throws Exception {
        List<ThongTinSD> thongTinSDs = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThongTinSD where " + fieldName + " = :value";
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            query.setParameter("value", value);
            thongTinSDs = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD list: " + e.getMessage());
        }
        return thongTinSDs;
    }
    public List<ThongTinSD> getCheckinByFilter(String sort) throws Exception {
        List<ThongTinSD> thongTinSDs = null;
        if(!"asc".equals(sort)&&!"desc".equals(sort))
            throw new Exception("Error retrieving ThongTinSD list: Giá trị sort sai");
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThongTinSD where TGVao is not null ORDER BY TGVao "+sort;
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            thongTinSDs = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD list: " + e.getMessage());
        }
        return thongTinSDs;
    }
    public List<ThongTinSD> getAllCheckin() throws Exception {
        List<ThongTinSD> thongTinSDs = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThongTinSD where TGVao is not null";
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            thongTinSDs = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD list: " + e.getMessage());
        }
        return thongTinSDs;
    }
        public List<ThongTinSD> getAllBorrow() throws Exception {
        List<ThongTinSD> thongTinSDs = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThongTinSD where TGMuon is not null AND TGTra is not null";
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            thongTinSDs = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD list: " + e.getMessage());
        }
        return thongTinSDs;
    }
    public List<ThongTinSD> getAllReserve() throws Exception {
        List<ThongTinSD> thongTinSDs = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThongTinSD where TGDatCho is not null AND TGMuon is null";
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            thongTinSDs = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD list: " + e.getMessage());
        }
        return thongTinSDs;
    }
    
    public List<ThongTinSD> getCheckInByTimeRange(LocalDateTime startTime, LocalDateTime endTime,String sort) throws Exception {
        List<ThongTinSD> thongTinSDs = null;
        if(!"asc".equals(sort)&&!"desc".equals(sort))
            throw new Exception("Error retrieving ThongTinSD list: Giá trị sort sai");
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThongTinSD where TGVao between :startTime and :endTime order by TGVao "+sort;
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            query.setParameter("startTime", startTime);
            query.setParameter("endTime", endTime);
            thongTinSDs = query.list();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD list: " + e.getMessage());
        }
        return thongTinSDs;
    }


    public ThongTinSD getOne(String fieldName, Object value) throws Exception {
        ThongTinSD thongTinSD = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "from ThongTinSD where " + fieldName + " = :value";
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            query.setParameter("value", value);
            query.setMaxResults(1);
            thongTinSD = query.uniqueResult();
        } catch (Exception e) {
            throw new Exception("Error retrieving ThongTinSD: " + e.getMessage());
        }
        return thongTinSD;
    }
        public Boolean add(ThongTinSD thongTinSD) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(thongTinSD);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi thêm: " + e.getMessage());
        }
    }

    public Boolean update(ThongTinSD thongTinSD) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(thongTinSD);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi cập nhật: " + e.getMessage());
        }
    }

    public Boolean delete(ThongTinSD thongTinSD) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(thongTinSD);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Lỗi xảy ra khi xóa: " + e.getMessage());
        }
    }
        public int generateId() throws Exception {
        int newestId = 0;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "select max(MaTT) from ThongTinSD";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            Integer maxId = query.uniqueResult();
            if (maxId != null) {
                newestId = maxId + 1;
            } else {
                newestId = 1;
            }
        } catch (Exception e) {
            throw new Exception("Error generating ThongTinSD ID: " + e.getMessage());
        }
        return newestId;
    }
    public List<ThongTinSD> findConflictingRecords(int MaTB,LocalDateTime startTime, LocalDateTime endTime) throws Exception {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            String hql = "SELECT t FROM ThongTinSD t " +
             "WHERE t.thietBi.MaTB = :MaTB " +
             "AND (:startTime BETWEEN t.TGMuon AND t.TGTra " +
             "OR :endTime BETWEEN t.TGMuon AND t.TGTra " +
             "OR t.TGMuon BETWEEN :startTime AND :endTime " +
             "OR t.TGTra BETWEEN :startTime AND :endTime)";
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            query.setParameter("MaTB", MaTB);
            query.setParameter("startTime", startTime);
            query.setParameter("endTime", endTime);
            List<ThongTinSD> conflictingRecords = query.getResultList();
            return conflictingRecords;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Lỗi xảy ra " + e.getMessage());
        }
    }

}

