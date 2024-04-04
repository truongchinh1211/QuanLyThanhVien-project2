/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import constants.ResponseStatus;
import dao.ThanhVienDAO;
import java.util.List;
import model.ThanhVien;
import utils.Response;

/**
 *
 * @author Bum
 */
public class ThanhVienBUS {
     public Response<List<ThanhVien>> getAll() {
        Response<List<ThanhVien>> response = new Response<>();
        List<ThanhVien> thanhViens = null;
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            thanhViens = thanhVienDAO.getAll();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thanhViens);
        } catch (Exception e) {

            // Xử lý lỗi khi có lỗi trong quá trình gọi DAO
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThanhVien list");
        }
        return response;
    }
     public Response<Boolean> addThanhVien(ThanhVien thanhVien) {
        Response<Boolean> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            boolean isSuccess = thanhVienDAO.add(thanhVien);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Thêm thành viên thành công");
                response.setData(true); // Trả về true nếu thêm thành công
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage()); // Trả về thông báo lỗi từ ngoại lệ
            response.setData(false); // Trả về false nếu có lỗi xảy ra
        }
        return response;
    }   
     
    public Response<Boolean> updateThanhVien(ThanhVien thanhVien) {
        Response<Boolean> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            boolean isSuccess = thanhVienDAO.update(thanhVien);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Cập nhật thành viên thành công");
                response.setData(true);
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Cập nhật thành viên thất bại");
                response.setData(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi cập nhật thành viên: " + e.getMessage());
            response.setData(false);
        }
        return response;
    }

    public Response<Boolean> deleteThanhVien(ThanhVien thanhVien) {
        Response<Boolean> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            boolean isSuccess = thanhVienDAO.delete(thanhVien);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Xóa thành viên thành công");
                response.setData(true);
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Xóa thành viên thất bại");
                response.setData(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi xóa thành viên: " + e.getMessage());
            response.setData(false);
        }
        return response;
    }
}
