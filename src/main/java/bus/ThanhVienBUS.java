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
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThanhVien list");
        }
        return response;
    }
    
    
    public Response<List<ThanhVien>> getAll(String fieldName,Object value) {
        Response<List<ThanhVien>> response = new Response<>();
        List<ThanhVien> thanhViens = null;
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            thanhViens = thanhVienDAO.getAll(fieldName,value);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thanhViens);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThanhVien list");
        }
        return response;
    }
    
    public Response<List<ThanhVien>> getByFilter(String fieldName,Object value) {
        Response<List<ThanhVien>> response = new Response<>();
        List<ThanhVien> thanhViens = null;
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            thanhViens = thanhVienDAO.getByFilter(fieldName, value);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thanhViens);
        } catch (Exception e) {

            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThanhVien list");
        }
        return response;
    }
    
    
    public Response<ThanhVien> getOne(String fieldName,Object value) {
        Response<ThanhVien> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            ThanhVien thanhVien = thanhVienDAO.getOne(fieldName,value);
            if (thanhVien != null) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(thanhVien);
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("ThanhVien with " + fieldName + " = " +value.toString() + " not found.");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThanhVien " + e.getMessage());
        }
        return response;
    }
    public int generateMaTV(){
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            return thanhVienDAO.generateNewMemberCode();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public Response<Boolean> add(ThanhVien thanhVien) {
        Response<Boolean> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            if(thanhVienDAO.getOne("MaTV", thanhVien.getMaTV())!=null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage(thanhVien.getMaTV()+ ": MaTV đã tồn tại");
            }
            boolean isSuccess = thanhVienDAO.add(thanhVien);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Thêm thành viên thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage()); // Trả về thông báo lỗi từ ngoại lệ
        }
        return response;
    }   
     
    public Response<Boolean> update(int oldId,ThanhVien thanhVien) {
        Response<Boolean> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            ThanhVien existingThanhVien = thanhVienDAO.getOne("MaTV", oldId);
            if(existingThanhVien==null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Không tìm thấy TV có Mã TV này!");
                return response;
            }
            boolean isSuccess = thanhVienDAO.update(thanhVien);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Cập nhật thành viên thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Cập nhật thành viên thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi cập nhật thành viên: " + e.getMessage());
        }
        return response;
    }

    public Response<Boolean> delete(int id) {
        Response<Boolean> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            ThanhVien thanhVien = thanhVienDAO.getOne("MaTV", id);
            if(thanhVien==null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage(id+ ": không tìm thấy Mã TV của người cần xóa");
            }
            boolean isSuccess = thanhVienDAO.delete(thanhVien);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Xóa thành viên thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Xóa thành viên thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi xóa thành viên: " + e.getMessage());
            response.setData(false);
        }
        return response;
    }
    public Response<Boolean> deleteWithCondition(int id) {
        Response<Boolean> response = new Response<>();
        try {
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            List<ThanhVien> thanhViens = thanhVienDAO.getAll();
            if(thanhViens==null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Có lỗi xảy ra");
            }
            boolean isSuccess=false;
            for(ThanhVien thanhVien : thanhViens){
                String MaTV = thanhVien.getMaTV()+"";
                String thirdAndFourthDigits = MaTV.substring(2, 4);
                int number = Integer.parseInt(thirdAndFourthDigits);
                if(number==id){
                    isSuccess = thanhVienDAO.delete(thanhVien);
                }
            }
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Xóa thành viên thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Xóa thành viên thất bại, một số id có thể chưa được xóa");
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
