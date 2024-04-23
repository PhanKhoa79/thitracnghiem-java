/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SinhVien {

    private String idSinhVien;

    private String tenSinhVien;

    private String idLop;

    private String idKhoa;

    private Date ngaySinh;

    private Boolean gioiTinh;

    private String diaChi;

    private String sdt;

    private String taiKhoan;

    private byte[] anhSinhVien;
    
    private String tenLop;
    
    private String tenKhoa;
    
    public SinhVien() {}

    public SinhVien(String idSinhVien, String tenSinhVien, String idLop, String idKhoa, Date ngaySinh, Boolean gioiTinh, String diaChi, String sdt) {
        this.idSinhVien = idSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.idLop = idLop;
        this.idKhoa = idKhoa;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public byte[] getAnhSinhVien() {
        return anhSinhVien;
    }

    public void setAnhSinhVien(byte[] anhSinhVien) {
        this.anhSinhVien = anhSinhVien;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }
    
    
    
}
