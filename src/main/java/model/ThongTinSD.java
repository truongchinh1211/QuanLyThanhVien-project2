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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Bum
 */
@Entity
@Table(name = "thongtinsd")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThongTinSD {
    @Id
    private int MaTT;
    @ManyToMany
    @JoinColumn(name = "MaTV")
    private ThanhVien thanhVien;
    @ManyToMany
    @JoinColumn(name = "MaTB")
    private ThietBi ThietBi;
    @Column(name = "TGVao")
    private LocalDateTime TGVao;
    @Column(name = "TGMuon")
    private LocalDateTime TGMuon;
    @Column(name = "TGTra")
    private LocalDateTime TGTra;
    
}
