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
@Table(name = "thietbi")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThietBi {
    @Id
    private int MaTB;
    @Column (name = "TenTB")
    private String TenTB;
    @Column (name = "MoTaTB")
    private String MoTaTB;
    @OneToMany(mappedBy = "thietBi", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ThongTinSD> thongTinSDs;

    public ThietBi(int MaTB, String TenTB, String MoTaTB) {
        this.MaTB = MaTB;
        this.TenTB = TenTB;
        this.MoTaTB = MoTaTB;
    }
    
    
}
