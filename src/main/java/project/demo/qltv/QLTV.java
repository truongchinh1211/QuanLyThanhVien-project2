/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package project.demo.qltv;

import bus.ThanhVienBUS;
import java.util.List;
import model.ThanhVien;
import utils.Response;

/**
 *
 * @author Bum
 */
public class QLTV {

    public static void main(String[] args) {
        System.out.println("chán!");
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        Response<List<ThanhVien>> thanhViens= thanhVienBUS.getAll();
        for(ThanhVien c:thanhViens.getData()){
            System.out.println(c.toString());
        }
    }
}
