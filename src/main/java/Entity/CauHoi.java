/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CauHoi {
    private int idCauHoi;

    private String cauHoi;

    private String dapAnA;

    private String dapAnB;

    private String dapAnC;

    private String dapAnD;

    private String dapAnDung;

    private String idMonThi;

    private String idMucDo;

    private String idChuong;
    
    private String tenChuong;
    
    private String tenMonThi;
    
    private String tenMucDo;
    
    public CauHoi() {}

    public CauHoi(String cauHoi, String dapAnA, String dapAnB, String dapAnC, String dapAnD, String dapAnDung, String idMonThi, String idMucDo, String idChuong) {
        this.cauHoi = cauHoi;
        this.dapAnA = dapAnA;
        this.dapAnB = dapAnB;
        this.dapAnC = dapAnC;
        this.dapAnD = dapAnD;
        this.dapAnDung = dapAnDung;
        this.idMonThi = idMonThi;
        this.idMucDo = idMucDo;
        this.idChuong = idChuong;
    }
    
    public int getIdCauHoi() {
        return idCauHoi;
    }

    public void setIdCauHoi(int idCauHoi) {
        this.idCauHoi = idCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDapAnA() {
        return dapAnA;
    }

    public void setDapAnA(String dapAnA) {
        this.dapAnA = dapAnA;
    }

    public String getDapAnB() {
        return dapAnB;
    }

    public void setDapAnB(String dapAnB) {
        this.dapAnB = dapAnB;
    }

    public String getDapAnC() {
        return dapAnC;
    }

    public void setDapAnC(String dapAnC) {
        this.dapAnC = dapAnC;
    }

    public String getDapAnD() {
        return dapAnD;
    }

    public void setDapAnD(String dapAnD) {
        this.dapAnD = dapAnD;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public String getIdMonThi() {
        return idMonThi;
    }

    public void setIdMonThi(String idMonThi) {
        this.idMonThi = idMonThi;
    }

    public String getIdMucDo() {
        return idMucDo;
    }

    public void setIdMucDo(String idMucDo) {
        this.idMucDo = idMucDo;
    }

    public String getIdChuong() {
        return idChuong;
    }

    public void setIdChuong(String idChuong) {
        this.idChuong = idChuong;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public String getTenMonThi() {
        return tenMonThi;
    }

    public String getTenMucDo() {
        return tenMucDo;
    }
    
    
    
}
