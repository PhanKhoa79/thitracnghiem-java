/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.MonThiService;
import Entity.MonThi;
import View.fMonThi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
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
public class MonThiController {
    private fMonThi form;
    private MonThiService monThiService;
    private DefaultTableModel tableModelMonThi;

    public MonThiController(fMonThi form) {
        this.form = form;
        this.monThiService = new MonThiService();
        createModelTable();
        showMonThi();
        jTable_monthi_CellClick();
        addMonThi();
        updateMonThi();
        deleteMonThi();
    }
    
    private void createModelTable() {
        tableModelMonThi = new DefaultTableModel();
        tableModelMonThi.addColumn("Mã môn thi");
        tableModelMonThi.addColumn("Tên môn thi");
    }
    
    private void showMonThi() {
        try {
            List<MonThi> listMonThi = monThiService.getAllMonThi();
            if(listMonThi != null) {
                JTable tableMonThi = form.getTableMonThi();
                for(MonThi monThi : listMonThi) {
                    Object[] row = {monThi.getIdMonThi(), monThi.getTenMonThi()};
                    tableModelMonThi.addRow(row);
                }
                tableMonThi.setModel(tableModelMonThi);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void jTable_monthi_CellClick() {
         form.getTableMonThi().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             @Override
             public void valueChanged(ListSelectionEvent e) {
                 if(!e.getValueIsAdjusting()) {
                     int selectedRow = form.getTableMonThi().getSelectedRow();
                     if(selectedRow != -1) {
                         form.setTextFieldMaMon(form.getTableMonThi().getValueAt(selectedRow, 0).toString());
                         form.setTextFieldTenMon(form.getTableMonThi().getValueAt(selectedRow, 1).toString());
                     }
                 }
             }
         });
     }
    
    private void addMonThi() {
        form.getButtonThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idMonThi = form.getTextFieldMaMon();
                    String tenMonThi = form.getTextFieldTenMon();
                    MonThi monThi = new MonThi(idMonThi, tenMonThi);
                    if(!(idMonThi.equals("") || tenMonThi.equals(""))) {
                        if(monThiService.createMonThi(monThi) != null) {
                            refreshTableData();
                            JOptionPane.showMessageDialog(form, "Thêm thành công!"); 
                        } else {
                            JOptionPane.showMessageDialog(form, "Môn thi đã tồn tại!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void updateMonThi() {
        form.getButtonSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idMonThi = form.getTextFieldMaMon();
                    String tenMonThi = form.getTextFieldTenMon();
                    if(!(idMonThi.equals("") || tenMonThi.equals(""))) {
                        MonThi monthi = new MonThi();
                        monthi.setTenMonThi(tenMonThi);
                        if(monThiService.updateMonThi(idMonThi, monthi) != null) {
                            refreshTableData();
                            JOptionPane.showMessageDialog(form, "Sửa thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Không thể sửa môn thi!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void deleteMonThi() {
        form.getButtonXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idMonThi = form.getTextFieldMaMon();
                    int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá câu hỏi", JOptionPane.YES_NO_OPTION);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                        if(monThiService.deleteMonThi(idMonThi)) {
                            refreshTableData();
                            JOptionPane.showMessageDialog(form, "Xóa thành công");
                        } else {
                            JOptionPane.showMessageDialog(form, "Không thể xóa môn thi", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        return;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void refreshTableData() {
        DefaultTableModel model = (DefaultTableModel)form.getTableMonThi().getModel();
        model.setRowCount(0);
        showMonThi();
    }
}
