/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;
@JsonIgnoreProperties(ignoreUnknown = true)

public class DeThi {

    private String idDeThi;

    private String tenDeThi;

    private Date ngayTao;

    private Integer diemToiDa;

    private String idMonThi;

    private Integer soLuongCauHoi;

    private Integer thoiGianThi;
    
    private String tenMonThi;
    
    public DeThi() {}

    public DeThi(String idDeThi, String tenDeThi, Date ngayTao, Integer diemToiDa, String idMonThi, Integer soLuongCauHoi, Integer thoiGianThi) {
        this.idDeThi = idDeThi;
        this.tenDeThi = tenDeThi;
        this.ngayTao = ngayTao;
        this.diemToiDa = diemToiDa;
        this.idMonThi = idMonThi;
        this.soLuongCauHoi = soLuongCauHoi;
        this.thoiGianThi = thoiGianThi;
    }

    public String getIdDeThi() {
        return idDeThi;
    }

    public void setIdDeThi(String idDeThi) {
        this.idDeThi = idDeThi;
    }

    public String getTenDeThi() {
        return tenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getDiemToiDa() {
        return diemToiDa;
    }

    public void setDiemToiDa(Integer diemToiDa) {
        this.diemToiDa = diemToiDa;
    }

    public String getIdMonThi() {
        return idMonThi;
    }

    public void setIdMonThi(String idMonThi) {
        this.idMonThi = idMonThi;
    }

    public Integer getSoLuongCauHoi() {
        return soLuongCauHoi;
    }

    public void setSoLuongCauHoi(Integer soLuongCauHoi) {
        this.soLuongCauHoi = soLuongCauHoi;
    }

    public Integer getThoiGianThi() {
        return thoiGianThi;
    }

    public void setThoiGianThi(Integer thoiGianThi) {
        this.thoiGianThi = thoiGianThi;
    }

    public String getTenMonThi() {
        return tenMonThi;
    }
    
    

}
