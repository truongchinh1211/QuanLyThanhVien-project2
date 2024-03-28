/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package project.demo.qltv;

import bus.ThanhVienBUS;

/**
 *
 * @author Bum
 */
public class QLTV {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ThanhVienBUS thanhVienBUS = new ThanhVienBUS();
        thanhVienBUS.getAll();
    }
}
