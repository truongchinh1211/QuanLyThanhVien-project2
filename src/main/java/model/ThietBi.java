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
}
