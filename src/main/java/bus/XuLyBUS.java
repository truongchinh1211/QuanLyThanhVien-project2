/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import constants.ResponseStatus;
import dao.ThanhVienDAO;
import dao.XuLyDAO;
import java.util.List;
import model.XuLy;
import utils.Response;

/**
 *
 * @author Son
 */
public class XuLyBUS {
    public Response<List<XuLy>> getAll() {
        Response<List<XuLy>> response = new Response<>();
        List<XuLy> xuLys = null;
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            xuLys = xuLyDAO.getAll();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(xuLys);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public Response<List<XuLy>> getAll(String fieldName, Object value) {
        Response<List<XuLy>> response = new Response<>();
        List<XuLy> xuLys = null;
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            xuLys = xuLyDAO.getAll(fieldName, value);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(xuLys);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving XuLy list");
        }
        return response;
    }
    
    public Response<List<XuLy>> getByFilter(String fieldName, Object value) {
        Response<List<XuLy>> response = new Response<>();
        List<XuLy> xuLys = null;
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            xuLys = xuLyDAO.getByFilter(fieldName, value);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(xuLys);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving XuLy list");
        }
        return response;
    }

    public Response<XuLy> getOne(String fieldName, Object value) {
        Response<XuLy> response = new Response<>();
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            XuLy xuLy = xuLyDAO.getOne(fieldName, value);
            if (xuLy != null) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(xuLy);
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("XuLy with " + fieldName + " = " + value.toString() + " not found.");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving XuLy " + e.getMessage());
        }
        return response;
    }
    public Response<XuLy> getLatestRecordByMaTV(long MaTV ) {
        Response<XuLy> response = new Response<>();
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            XuLy xuLy = xuLyDAO.getLatestRecordByMaTV(MaTV);
            if (xuLy != null) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(xuLy);
            } else {
                response.setStatus(ResponseStatus.FAILURE);
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving XuLy " + e.getMessage());
        }
        return response;
    }
    public Response<Boolean> add(XuLy xuLy) {
        Response<Boolean> response = new Response<>();
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            if(thanhVienDAO.getOne("MaTV", xuLy.getThanhVien().getMaTV())==null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Không tìm thấy mã TV");
                return response;
            }
            xuLy.setMaXL(xuLyDAO.generateNewId());
            boolean isSuccess = xuLyDAO.add(xuLy);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Thêm xử lý thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage()); // Trả về thông báo lỗi từ ngoại lệ
        }
        return response;
    }   
     
    public Response<Boolean> update(XuLy xuLy) {
        Response<Boolean> response = new Response<>();
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
            if(thanhVienDAO.getOne("MaTV", xuLy.getThanhVien().getMaTV())==null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Không tìm thấy mã TV");
                return response;
            }
            boolean isSuccess = xuLyDAO.update(xuLy);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Cập nhật xử lý thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Cập nhật xử lý thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi cập nhật xử lý: " + e.getMessage());
        }
        return response;
    }

    public Response<Boolean> delete(long id) {
        Response<Boolean> response = new Response<>();
        try {
            XuLyDAO xuLyDAO = new XuLyDAO();
            XuLy xuLy = xuLyDAO.getOne("MaXL", id);
            if(xuLy==null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage(id+ ": không tìm thấy Mã XL của người cần xóa");
            }
            boolean isSuccess = xuLyDAO.delete(xuLy);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Xóa xử lý thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Xóa xử lý thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi xóa xử lý: " + e.getMessage());
            response.setData(false);
        }
        return response;
    }
    
}
