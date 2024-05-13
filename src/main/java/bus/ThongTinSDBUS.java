/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import constants.ResponseStatus;
import dao.ThongTinSDDAO;
import java.time.LocalDateTime;
import java.util.List;
import model.ThanhVien;
import model.ThietBi;
import model.ThongTinSD;
import utils.Response;

/**
 *
 * @author Son
 */
public class ThongTinSDBUS {
    private ThongTinSDDAO thongTinSDDAO;
    private ThanhVienBUS thanhVienBUS;
    private ThietBiBUS thietBiBUS;
    public ThongTinSDBUS(){
        thongTinSDDAO = new ThongTinSDDAO();
        thanhVienBUS = new ThanhVienBUS();
        thietBiBUS = new ThietBiBUS();
    }
    
    public Response<List<ThongTinSD>> getAll() {
        Response<List<ThongTinSD>> response = new Response<>();
        List<ThongTinSD> thongTinSDs = null;
        try {
             
            thongTinSDs = thongTinSDDAO.getAll();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thongTinSDs);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD list: " + e.getMessage());
        }
        return response;
    }
    
    
    public Response<List<ThongTinSD>> getAll(String fieldName, Object value) {
        Response<List<ThongTinSD>> response = new Response<>();
        List<ThongTinSD> thongTinSDs = null;
        try {
             
            thongTinSDs = thongTinSDDAO.getAll(fieldName, value);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thongTinSDs);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD list: " + e.getMessage());
        }
        return response;
    }
    public Response<List<ThongTinSD>> getCheckInByFilter(String sort) {
        Response<List<ThongTinSD>> response = new Response<>();
        List<ThongTinSD> thongTinSDs = null;
        try {
             
            thongTinSDs = thongTinSDDAO.getCheckinByFilter(sort);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thongTinSDs);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD list: " + e.getMessage());
        }
        return response;
    }
    public Response<List<ThongTinSD>> getAllCheckin() {
        Response<List<ThongTinSD>> response = new Response<>();
        List<ThongTinSD> thongTinSDs = null;
        try {
             
            thongTinSDs = thongTinSDDAO.getAllCheckin();
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thongTinSDs);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD list: " + e.getMessage());
        }
        return response;
    }
        public Response<List<ThongTinSD>> getAllBorrow() {
        Response<List<ThongTinSD>> response = new Response<>();
        List<ThongTinSD> thongTinSDs = null;
        try {
             
            thongTinSDs = thongTinSDDAO.getAllBorrow();
            System.out.println(thongTinSDs==null);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thongTinSDs);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD list: " + e.getMessage());
        }
        return response;
    }
    public Response<List<ThongTinSD>> getAllReserve() {
        Response<List<ThongTinSD>> response = new Response<>();
        List<ThongTinSD> thongTinSDs = null;
        try {
             
            thongTinSDs = thongTinSDDAO.getAllReserve();
            System.out.println(thongTinSDs==null);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thongTinSDs);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD list: " + e.getMessage());
        }
        return response;
    }
    public Response<List<ThongTinSD>> getCheckInByTimeRange(LocalDateTime startTime, LocalDateTime endTime,String sort) {
        Response<List<ThongTinSD>> response = new Response<>();
        List<ThongTinSD> thongTinSDs = null;
        try {
             
            thongTinSDs = thongTinSDDAO.getCheckInByTimeRange(startTime, endTime,sort);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setData(thongTinSDs);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD list: " + e.getMessage());
        }
        return response;
    }
    
    public Response<ThongTinSD> getOne(String fieldName, Object value) {
        Response<ThongTinSD> response = new Response<>();
        try {
             
            ThongTinSD thongTinSD = thongTinSDDAO.getOne(fieldName, value);
            if (thongTinSD != null) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setData(thongTinSD);
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("ThongTinSD with " + fieldName + " = " + value.toString() + " not found.");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Error while retrieving ThongTinSD: " + e.getMessage());
        }
        return response;
    }
    public Response<Boolean> add(ThongTinSD thongTinSD) {
        Response<Boolean> response = new Response<>();
        try {
             
            thongTinSD.setMaTT(thongTinSDDAO.generateId());
            boolean isSuccess = thongTinSDDAO.add(thongTinSD);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Thêm thông tin sử dụng thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Thêm thông tin sử dụng thất bại");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thêm thông tin sử dụng: " + e.getMessage());
        }
        return response;
    }
    public Response<Boolean> borrowDevice(ThongTinSD thongTinSD) {
        Response<Boolean> response = new Response<>();
        try {
            Response<ThanhVien> thanhVienRes = thanhVienBUS.getOne("MaTV", thongTinSD.getThanhVien().getMaTV());
            if(thanhVienRes.getStatus()!=ResponseStatus.SUCCESS){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage(thanhVienRes.getMessage());
                return response;
            }
            thongTinSD.setThanhVien(thanhVienRes.getData());
            Response<ThietBi> thietBiRes = thietBiBUS.getOne("MaTB",thongTinSD.getThietBi().getMaTB());
            if(thietBiRes.getStatus()!=ResponseStatus.SUCCESS){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage(thietBiRes.getMessage());
                return response;
            }
            thongTinSD.setThietBi(thietBiRes.getData());
            List<ThongTinSD> thongTinSDs =thongTinSDDAO.findConflictingRecords(thongTinSD.getThietBi().getMaTB(),thongTinSD.getTGMuon());
            if(!thongTinSDs.isEmpty()){
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Thiết bị đã có người mượn hoặc đặt chỗ trong khoảng thời gian này");
                return response;
            }
            thongTinSD.setMaTT(thongTinSDDAO.generateId());
            boolean isSuccess = thongTinSDDAO.add(thongTinSD);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Thêm thông tin sử dụng thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Thêm thông tin sử dụng thất bại");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi thêm thông tin sử dụng: " + e.getMessage());
        }
        return response;
    }
    
    public Response<Boolean> update(ThongTinSD thongTinSD) {
        Response<Boolean> response = new Response<>();
        try {
             
            ThongTinSD existingThongTinSD = thongTinSDDAO.getOne("MaTT", thongTinSD.getMaTT());
            if (existingThongTinSD == null) {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Không tìm thấy thông tin sử dụng có Mã TT này!");
                return response;
            }
            boolean isSuccess = thongTinSDDAO.update(thongTinSD);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Cập nhật thông tin sử dụng thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Cập nhật thông tin sử dụng thất bại");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi cập nhật thông tin sử dụng: " + e.getMessage());
        }
        return response;
    }
    
    public Response<Boolean> delete(int id) {
        Response<Boolean> response = new Response<>();
        try {
             
            ThongTinSD thongTinSD = thongTinSDDAO.getOne("MaTT", id);
            if (thongTinSD == null) {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Không tìm thấy thông tin sử dụng có Mã TT này!");
                return response;
            }
            boolean isSuccess = thongTinSDDAO.delete(thongTinSD);
            if (isSuccess) {
                response.setStatus(ResponseStatus.SUCCESS);
                response.setMessage("Xóa thông tin sử dụng thành công");
            } else {
                response.setStatus(ResponseStatus.FAILURE);
                response.setMessage("Xóa thông tin sử dụng thất bại");
            }
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage("Lỗi khi xóa thông tin sử dụng: " + e.getMessage());
        }
        return response;
    }
    
}
