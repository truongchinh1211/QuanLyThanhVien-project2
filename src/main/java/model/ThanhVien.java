/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Bum
 */

@Entity
@Table(name = "thanhvien")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThanhVien {
    @Id
    private int MaTV;
    @Column(name="HoTen")
    private String HoTen;
    @Column(name="Khoa")
    private String Khoa;
    @Column(name="Nganh")
    private String Nganh;
    @Column(name="SDT")
    private int SDT;
}
