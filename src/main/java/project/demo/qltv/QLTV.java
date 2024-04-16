/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package project.demo.qltv;

import bus.ThanhVienBUS;
import java.util.List;
import model.ThanhVien;
import utils.ExcelUtil;
import utils.Response;

/**
 *
 * @author Bum
 */
public class QLTV {

    public static void main(String[] args) {
        System.out.println("chán!");
List<ThanhVien> thanhViens = ExcelUtil.readExcelData("C:\\Users\\Son\\Documents\\NetBeansProjects\\QuanLyThanhVien-project2\\src\\main\\java\\xls\\Import_CSDL.xlsx", 0, ThanhVien.class);
        for (ThanhVien thanhVien : thanhViens) {
            System.out.println(thanhVien.getSDT());
        }
        System.out.println(Integer.parseInt("0911211300"));
    }
}
