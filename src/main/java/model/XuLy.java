/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "XuLy")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class XuLy {
 @Id
private int MaXL;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "MaTV")
private ThanhVien thanhVien;
@Column(name = "HinhThucXL")
private String HinhThucXL;
@Column(name = "SoTien")
private Integer SoTien;
@Column(name = "NgayXL")
private LocalDateTime NgayXL;
@Column (name = "TrangThaiXL")
private int TrangThaiXuLi;
}
