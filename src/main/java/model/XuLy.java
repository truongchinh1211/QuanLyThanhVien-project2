/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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
public class XuLy {
 @Id
    private int MaTT;
@ManyToMany
@JoinColumn(name = "MaTV")
private ThanhVien thanhVien;
@Column(name = "HinhThucXL")
private LocalDateTime HinhThucXL;
@Column(name = "SoTien")
private int SoTien;
@Column(name = "NgayXL")
private LocalDateTime NgayXL;
@Column (name = "TrangThaiXuLi")
private int TrangThaiXuLi;
}
