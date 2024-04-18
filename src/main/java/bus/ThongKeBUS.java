/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import constants.ResponseStatus;
import dao.ThongKeDAO;
import dao.ThongTinSDDAO;
import java.time.LocalDateTime;
import java.util.List;
import model.ThongTinSD;
import utils.Response;

/**
 *
 * @author Son
 */
public class ThongKeBUS {
    public Response<List<Object[]>> thongKeSoLuongTVTheoKhoa(LocalDateTime startTime, LocalDateTime endTime) {
        ThongKeDAO thongKeDAO  = new ThongKeDAO();
        Response<List<Object[]>> response = new Response<>();
        try {
            List<Object[]> result = thongKeDAO.thongKeSoLuongTVTheoKhoa(startTime, endTime);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(result);
            response.setMessage("Thống kê số lượng thành viên theo khoa thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thực hiện thống kê: " + e.getMessage());
        }
        return response;
    }
    public Response<List<Object[]>> thongKeSoLuongTVTheoNganh(LocalDateTime startTime, LocalDateTime endTime) {
        ThongKeDAO thongKeDAO  = new ThongKeDAO();
        Response<List<Object[]>> response = new Response<>();
        try {
            List<Object[]> result = thongKeDAO.thongKeSoLuongTVTheoNganh(startTime, endTime);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(result);
            response.setMessage("Thống kê số lượng thành viên theo khoa thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thực hiện thống kê: " + e.getMessage());
        }
        return response;
    }
    public Response<Long> thongKeSoLuongXLChuaXuLi(LocalDateTime startTime, LocalDateTime endTime){
        ThongKeDAO thongKeDAO  = new ThongKeDAO();
        Response<Long> response = new Response<>();
        try {
            long result = thongKeDAO.thongKeSoLuongXLChuaXuLi(startTime, endTime);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(result);
            response.setMessage("Thống kê số lượng thành viên theo khoa thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thực hiện thống kê: " + e.getMessage());
        }
        return response;
    } 
    public Response<Object[]> thongKeSoLuongXLDaXuLi(LocalDateTime startTime, LocalDateTime endTime) {
        ThongKeDAO thongKeDAO  = new ThongKeDAO();
        Response<Object[]> response = new Response<>();
        try {
            List<Object[]> result = thongKeDAO.thongKeSoLuongXLDaXuLi(startTime, endTime);
            if (result != null && !result.isEmpty()) {
                Object[] data = result.get(0); // Lấy phần tử đầu tiên của danh sách
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(data);
                response.setMessage("Thống kê số lượng bản ghi đã xử lí thành công.");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Không có dữ liệu thống kê.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thực hiện thống kê: " + e.getMessage());
        }
        return response;
    }
    public Response<List<ThongTinSD>> timThietBiDaTraTrongHomNay(String keyword) {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        Response<List<ThongTinSD>> response = new Response<>();
        try {
            List<ThongTinSD> result = thongKeDAO.timThietBiDaTraTrongHomNay(keyword);
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(result);
                response.setMessage("Thống kê số lượng bản ghi đã xử lí thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thực hiện thống kê: " + e.getMessage());
        }
        return response;
    }
        public Response<List<ThongTinSD>> timThietBiChuaTra(String keyword) {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        Response<List<ThongTinSD>> response = new Response<>();
        try {
            List<ThongTinSD> result = thongKeDAO.timThietBiChuaTra(keyword);
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(result);
                response.setMessage("Thống kê số lượng bản ghi đã xử lí thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thực hiện thống kê: " + e.getMessage());
        }
        return response;
    }
}
