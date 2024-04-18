/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "thongtinsd")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThongTinSD {
    @Id
    private int MaTT;
    @ManyToOne
    @JoinColumn(name = "MaTV")
    private ThanhVien thanhVien;
    @ManyToOne
    @JoinColumn(name = "MaTB")
    private ThietBi thietBi;
    @Column(name = "TGVao")
    private LocalDateTime TGVao;
    @Column(name = "TGMuon")
    private LocalDateTime TGMuon;
    @Column(name = "TGTra")
    private LocalDateTime TGTra;
}
