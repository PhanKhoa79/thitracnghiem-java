/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Khoahihi79
 */
public class User {
    private String taiKhoan;
    private String matKhau;
    private String email;
    private int idPhanQuyen;

    public User() {}

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdPhanQuyen() {
        return idPhanQuyen;
    }

    public void setIdPhanQuyen(int id_PhanQuyen) {
        this.idPhanQuyen = id_PhanQuyen;
    }
    
    
}
