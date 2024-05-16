/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import constants.ResponseStatus;
import dao.ThietBiDAO;
import java.util.List;
import model.ThietBi;
import utils.Response;

/**
 *
 * @author Son
 */
public class ThietBiBUS {
    public Response<List<ThietBi>> getAll() {
        Response<List<ThietBi>> response = new Response<>();
        List<ThietBi> thietBis = null;
        try {
            ThietBiDAO thietBiDAO = new ThietBiDAO();
            thietBis = thietBiDAO.getAll();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thietBis);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThietBi list: " + e.getMessage());
        }
        return response;
    }

    public Response<List<ThietBi>> getAll(String fieldName, Object value) {
        Response<List<ThietBi>> response = new Response<>();
        List<ThietBi> thietBis = null;
        try {
            ThietBiDAO thietBiDAO = new ThietBiDAO();
            thietBis = thietBiDAO.getAll(fieldName, value);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thietBis);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThietBi list: " + e.getMessage());
        }
        return response;
    }
    
    public Response<List<ThietBi>> getByFilter(String fieldName, Object value) {
        Response<List<ThietBi>> response = new Response<>();
        List<ThietBi> thietBis = null;
        try {
            ThietBiDAO thietBiDAO = new ThietBiDAO();
            thietBis = thietBiDAO.getByFilter(fieldName, value);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thietBis);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThietBi list: " + e.getMessage());
        }
        return response;
    }
    
    
    public Response<ThietBi> getOne(String fieldName, Object value) {
        Response<ThietBi> response = new Response<>();
        try {
            ThietBiDAO thietBiDAO = new ThietBiDAO();
            ThietBi thietBi = thietBiDAO.getOne(fieldName, value);
            if (thietBi != null) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(thietBi);
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("ThietBi with " + fieldName + " = " + value.toString() + " not found.");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThietBi: " + e.getMessage());
        }
        return response;
    }
    
    public Response<Boolean> add(ThietBi thietBi) {
    Response<Boolean> response = new Response<>();
    try {
        ThietBiDAO thietBiDAO = new ThietBiDAO();
        if (thietBiDAO.getOne("MaTB", thietBi.getMaTB()) != null) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(thietBi.getMaTB()+ ": MaTB đã tồn tại");
        } else {
            boolean isSuccess = thietBiDAO.add(thietBi);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Thêm thiết bị thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage(thietBi.getMaTB()+": Thêm thiết bị thất bại");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(ResponseStatus.FAILURE);
        response.setMessage(e.getMessage()); // Trả về thông báo lỗi từ ngoại lệ
    }
    return response;
}
    
    public Response<Boolean> update(ThietBi thietBi) {
        Response<Boolean> response = new Response<>();
        try {
            ThietBiDAO thietBiDAO = new ThietBiDAO();
            boolean isSuccess = thietBiDAO.update(thietBi);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Cập nhật thiết bị thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Cập nhật thiết bị thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi cập nhật thiết bị: " + e.getMessage());
        }
        return response;
    }

    public Response<Boolean> delete(long id) {
        Response<Boolean> response = new Response<>();
        try {
            ThietBiDAO thietBiDAO = new ThietBiDAO();
            ThietBi thietBi = thietBiDAO.getOne("MaTB", id);
            if (thietBi == null) {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Lỗi xảy ra: không tìm thấy Mã TB của thiết bị cần xóa");
            } else {
                boolean isSuccess = thietBiDAO.delete(thietBi);
                if (isSuccess) {
                    response.setStatus(ResponseStatus.SUCCESS);
                    response.setMessage("Xóa thiết bị thành công");
                } else {
                    response.setStatus(ResponseStatus.FAILURE);
                    response.setMessage("Xóa thiết bị thất bại");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi xóa thiết bị: " + e.getMessage());
            response.setData(false);
        }
        return response;
    }
    public Response<Boolean> deleteWithCondition(int id) {
        Response<Boolean> response = new Response<>();
        try {
            ThietBiDAO thietBiDAO = new ThietBiDAO();
            List<ThietBi> thietBis = thietBiDAO.getAll();
            if(thietBis==null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Có lỗi xảy ra");
            }
            boolean isSuccess=false;
            for(ThietBi thietBi : thietBis){
                String MaTV = thietBi.getMaTB()+"";
                char firstDigits = MaTV.charAt(0);
                int number = Character.getNumericValue(firstDigits);
                if(number==id){
                    isSuccess = thietBiDAO.delete(thietBi);
                }
            }
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Xóa thiết bị thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Xóa thiết bị thất bại, một số id có thể chưa được xóa");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi xóa thiết bị: " + e.getMessage());
            response.setData(false);
        }
        return response;
    }
}
