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
}
