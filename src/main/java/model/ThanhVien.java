/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
    private long MaTV;
    @Column(name="HoTen")
    private String HoTen;
    @Column(name="Khoa")
    private String Khoa;
    @Column(name="Nganh")
    private String Nganh;
    @Column(name="SDT")
    private String SDT;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "thanhVien", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ThongTinSD> thongTinSDs;

    public ThanhVien(long MaTV, String HoTen, String Khoa, String Nganh, String SDT) {
        this.MaTV = MaTV;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
    }
    
    
    
}
