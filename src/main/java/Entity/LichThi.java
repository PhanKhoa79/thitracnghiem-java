/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;
import java.sql.Time;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LichThi {

    private int idLichThi;

    private String idMonThi;

    private Time gioBatDau;

    private Time gioKetThuc;

    private Date ngayLamBai;
    
    private String tenMonThi;
    
    public LichThi() {}

    public LichThi( String idMonThi, Time gioBatDau, Time gioKetThuc, Date ngayLamBai) {
        this.idMonThi = idMonThi;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.ngayLamBai = ngayLamBai;
    }

    public int getIdLichThi() {
        return idLichThi;
    }

    public void setIdLichThi(int idLichThi) {
        this.idLichThi = idLichThi;
    }

    public String getIdMonThi() {
        return idMonThi;
    }

    public void setIdMonThi(String idMonThi) {
        this.idMonThi = idMonThi;
    }

    public Time getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Date getNgayLamBai() {
        return ngayLamBai;
    }

    public void setNgayLamBai(Date ngayLamBai) {
        this.ngayLamBai = ngayLamBai;
    }

    public String getTenMonThi() {
        return tenMonThi;
    }
    
    
    
}
