/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.PhanQuyenSerivce;
import Api.UserService;
import Entity.PhanQuyen;
import Entity.User;
import View.fQuanLyTaiKhoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class QuanLyTaiKhoanController {
    private fQuanLyTaiKhoan form;
    private UserService userService;
    private DefaultTableModel tableModelTaiKhoan;

    public QuanLyTaiKhoanController(fQuanLyTaiKhoan form) {
        this.form = form;
        this.userService = new UserService();
        createTableModelTaiKhoan();
        showComboBox();
        showTableTaiKhoan();
        addTaiKhoan();
        updateTaiKhoan();
        deleteTaiKhoan();
        searchTaiKhoan();
        jTable_taikhoan_cellClick();
    }
    
    private void createTableModelTaiKhoan() {
        tableModelTaiKhoan = new DefaultTableModel();
        tableModelTaiKhoan.addColumn("Tài Khoản");
        tableModelTaiKhoan.addColumn("Mật Khẩu");
        tableModelTaiKhoan.addColumn("Email");
        tableModelTaiKhoan.addColumn("Phân Quyền");
    }
    
    private void showComboBox() {
        try {
            List<PhanQuyen> listRole = new PhanQuyenSerivce().getAllRoles();
            if(listRole != null) {
                for(PhanQuyen role : listRole) {
                    String tenRole = role.getTenPhanQuyen();
                    form.getComboBoxPhanQuyen().addItem(tenRole);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String getTenPhanQuyen(int idPhanQuyen) {
        if(idPhanQuyen == 1) {
            return "Sinh Viên";
        } else if(idPhanQuyen == 2) {
            return "Giảng Viên";
        } else {
            return "Admin";
        }
    }
    
    private int getIdPhanQuyen(String tenPhanQuyen) {
        if(tenPhanQuyen.equals("Sinh Viên")) {
            return 1;
        } else if(tenPhanQuyen.equals("Giảng Viên")){
            return 2;
        } else {
            return 3;
        }
    }
    
    private void showTableTaiKhoan() {
        try {
        List<User> listTaiKhoan = userService.getAllUsers();
            if(listTaiKhoan != null) {
                for(User user : listTaiKhoan) {
                    int idPhanQuyen = user.getIdPhanQuyen();
                    String tenPhanQuyen = getTenPhanQuyen(idPhanQuyen);
                    Object[] row = {user.getTaiKhoan(), user.getMatKhau(), user.getEmail(), tenPhanQuyen};
                    tableModelTaiKhoan.addRow(row);
                }
                form.getTableTaiKhoan().setModel(tableModelTaiKhoan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private boolean enableComboBoxEvent = true;
    private void jTable_taikhoan_cellClick() {
        form.getTableTaiKhoan().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    int selectedRow = form.getTableTaiKhoan().getSelectedRow();
                    if(selectedRow != -1) {
                        enableComboBoxEvent = false;
                        form.setTextFieldUsername(form.getTableTaiKhoan().getValueAt(selectedRow, 0).toString());
                        form.setTextFieldPassword(form.getTableTaiKhoan().getValueAt(selectedRow, 1).toString());
                        Object value = form.getTableTaiKhoan().getValueAt(selectedRow, 2);
                        String email = "";
                        if (value != null) {
                            email = value.toString();
                        }
                        form.setTextFieldEmail(email);
                        form.getComboBoxPhanQuyen().setSelectedItem(form.getTableTaiKhoan().getValueAt(selectedRow, 3).toString());
                        enableComboBoxEvent = true;
                    }
                }
            }         
        });
    }    
    private void addTaiKhoan() {
        form.getButtonThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan = form.getTextFieldUsername();
                String matKhau = form.getTextFieldPassword();
                String email = form.getTextFieldEmail();
                int role = getIdPhanQuyen(form.getComboBoxPhanQuyen().getSelectedItem().toString());
                if(!(taiKhoan.equals("") || matKhau.equals("") || email.equals(""))) {
                    try {
                        if(userService.getUserById(taiKhoan) == null) {
                            User user = new User();
                            user.setTaiKhoan(taiKhoan);
                            user.setMatKhau(matKhau);
                            user.setEmail(email);
                            user.setIdPhanQuyen(role);
                            
                            userService.createUser(user);
                            refreshDataTable();
                            JOptionPane.showMessageDialog(form, "Thêm thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Tài khoản đã tồn tại!");
                        }
                    } catch (IOException ex){
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                }
            }   
        });
    }
    
    private void updateTaiKhoan() {
        form.getButtonSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan = form.getTextFieldUsername();
                String matKhau = form.getTextFieldPassword();
                String email = form.getTextFieldEmail();
                int role = getIdPhanQuyen(form.getComboBoxPhanQuyen().getSelectedItem().toString());
                if(!(taiKhoan.equals("") || matKhau.equals("") || email.equals(""))) {
                    try {
                        User user = new User();
                        user.setMatKhau(matKhau);
                        user.setEmail(email);
                        user.setIdPhanQuyen(role);
                        if(userService.updateUser(taiKhoan, user) != null) {
                            refreshDataTable();
                            JOptionPane.showMessageDialog(form, "Sửa thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Lỗi không thể sửa tài khoản");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                }
            }   
        });
    }
    
    private void deleteTaiKhoan() {
        form.getButtonXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan = form.getTextFieldUsername();
                int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá tài khoản", JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION) {
                    try {
                        if(userService.deleteUser(taiKhoan)) {
                            refreshDataTable();
                            JOptionPane.showMessageDialog(form, "Xóa thành công");
                        } else {
                            JOptionPane.showMessageDialog(form, "Không thể xóa tài khoản", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    return;
                }
            }   
        });
    }
    
    private void searchTaiKhoan() {
        form.getButtonTimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan = form.getTextFieldUsername();
                if(!(taiKhoan.equals(""))) {
                    try {
                        User user = userService.getUserById(taiKhoan);
                        if(user != null) {
                            tableModelTaiKhoan.setRowCount(0);
                            JTable tableCauHoi = form.getTableTaiKhoan();
                            String tenPhanQuyen = getTenPhanQuyen(user.getIdPhanQuyen());
                            Object[] row = {user.getTaiKhoan(), user.getMatKhau(), user.getEmail(), tenPhanQuyen};
                            tableModelTaiKhoan.addRow(row);
                            
                            tableCauHoi.setModel(tableModelTaiKhoan);
                        } 
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng thông tin cần tìm kiếm!");
                }
            }   
        });
    }
    
    public void refreshDataTable() {
        try {
            List<User> listTaiKhoan = userService.getAllUsers();
            tableModelTaiKhoan.setRowCount(0);
            if(listTaiKhoan != null) {
                for(User user : listTaiKhoan) {
                    String tenPhanQuyen = getTenPhanQuyen(user.getIdPhanQuyen());
                    Object[] row = {user.getTaiKhoan(), user.getMatKhau(), user.getEmail(), tenPhanQuyen};
                    tableModelTaiKhoan.addRow(row);
                }
                form.getTableTaiKhoan().setModel(tableModelTaiKhoan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
