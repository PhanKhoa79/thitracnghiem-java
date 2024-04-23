/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonThi {
    private String idMonThi;
    private String tenMonThi;
    
    public MonThi() {}
    
    public MonThi(String idMonThi, String tenMonThi) {
        this.idMonThi = idMonThi;
        this.tenMonThi = tenMonThi;
    }
    
    public String getIdMonThi() {
        return idMonThi;
    }

    public void setIdMonThi(String idMonThi) {
        this.idMonThi = idMonThi;
    }

    public String getTenMonThi() {
        return tenMonThi;
    }

    public void setTenMonThi(String tenMonThi) {
        this.tenMonThi = tenMonThi;
    }

    
    
}
