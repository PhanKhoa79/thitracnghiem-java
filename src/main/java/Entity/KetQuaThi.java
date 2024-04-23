/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KetQuaThi {

    private int id;

    private String idSinhVien;

    private String idMonThi;

    private Date ngayThi;

    private Double diemThi;

    private String idLop;

    private String idDeThi;

    private String tenSinhVien;

    private String tenMonThi;

    private String tenLop;

    private String tenDeThi;
    
    public KetQuaThi() {}

    public KetQuaThi(String idSinhVien, String idMonThi, Date ngayThi, Double diemThi, String idLop, String idDeThi) {
        this.idSinhVien = idSinhVien;
        this.idMonThi = idMonThi;
        this.ngayThi = ngayThi;
        this.diemThi = diemThi;
        this.idLop = idLop;
        this.idDeThi = idDeThi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getIdMonThi() {
        return idMonThi;
    }

    public void setIdMonThi(String idMonThi) {
        this.idMonThi = idMonThi;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public Double getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(Double diemThi) {
        this.diemThi = diemThi;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getIdDeThi() {
        return idDeThi;
    }

    public void setIdDeThi(String idDeThi) {
        this.idDeThi = idDeThi;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public String getTenMonThi() {
        return tenMonThi;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getTenDeThi() {
        return tenDeThi;
    }
    
    
}
