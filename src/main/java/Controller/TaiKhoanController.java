/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.UserService;
import View.LoginForm;
import java.io.IOException;
import javax.swing.JOptionPane;


public class TaiKhoanController {
    private LoginForm loginForm;
    private UserService userService;
    
    public TaiKhoanController(LoginForm loginForm) {
        this.loginForm = loginForm;
        this.userService = new UserService();
        addLoginListener();
    }
    
    public void login(String username, String password) {
        try {
            if(userService.login(username, password)) {
                int i = userService.phanQuyen(username);
                JOptionPane.showMessageDialog(loginForm, "Đăng nhập thành công");
                loginForm.hideLoginForm();
                loginForm.showNewForm(i, username);
            } else {
                JOptionPane.showMessageDialog(loginForm, "Sai tài khoản hoặc mật khẩu!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void addLoginListener() {
        loginForm.addLoginListener(e -> {
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            login(username, password);
        });
    }
    
   
}
