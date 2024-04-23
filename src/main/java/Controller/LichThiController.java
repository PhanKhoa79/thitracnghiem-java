/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.LichThiService;
import Api.MonThiService;
import Entity.LichThi;
import Entity.MonThi;
import View.fLichThi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class LichThiController {
    private fLichThi form;
    private LichThiService lichThiService;
    private MonThiService monThiService;
    private DefaultTableModel tableModelLichThi;
    
    public LichThiController(fLichThi form) {
        this.form = form;
        this.lichThiService = new LichThiService();
        this.monThiService = new MonThiService();
        createTableModel();
        showComboBox();
        showLichThiByMonThi();
        jTableLichThi_CellClick();
        addLichThi();
        updateLichThi();
        deleteLichThi();
    }
    
    private void createTableModel() {
        tableModelLichThi = new DefaultTableModel();
        tableModelLichThi.addColumn("Mã lịch thi");
        tableModelLichThi.addColumn("Môn thi");
        tableModelLichThi.addColumn("Ngày làm bài");
        tableModelLichThi.addColumn("Giờ bắt đầu");
        tableModelLichThi.addColumn("Giờ kết thúc");
    }
    
    private void showComboBox() {
        //combobox monthi
        try {
            List<MonThi> listMonThi = monThiService.getAllMonThi();
            JComboBox comboBoxMonThi = form.getComboBoxMonThi();
            if(listMonThi != null) {
                for(MonThi monthi: listMonThi) {
                    comboBoxMonThi.addItem(monthi.getTenMonThi());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     }
    
    private void showLichThiByMonThi() {
        form.getComboBoxMonThi().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                    String idMonThi = monThiService.getIdByName((String)form.getComboBoxMonThi().getSelectedItem().toString());
                    List<LichThi> dsLichThi = lichThiService.getAllLichThiByIdMonThi(idMonThi);
                    if(dsLichThi != null) {
                        tableModelLichThi.setRowCount(0);
                        JTable tableLichThi = form.getTableLichThi();
                        for(LichThi lichThi : dsLichThi) {
                            Object[] row = {lichThi.getIdLichThi(), lichThi.getTenMonThi(), lichThi.getNgayLamBai(), lichThi.getGioBatDau(), lichThi.getGioKetThuc()};
                            tableModelLichThi.addRow(row);
                        }
                        tableLichThi.setModel(tableModelLichThi);
                    }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    
    int idLichThi = 0;
    private void jTableLichThi_CellClick() {
        form.getTableLichThi().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!(e.getValueIsAdjusting())) {
                    int selectedRow = form.getTableLichThi().getSelectedRow();
                    if(selectedRow != -1) {
                        idLichThi = Integer.parseInt(form.getTableLichThi().getValueAt(selectedRow, 0).toString());
                        form.setValueJDateChooser(Date.valueOf(form.getTableLichThi().getValueAt(selectedRow, 2).toString()));
                        form.setTextFieldTimeStart(form.getTableLichThi().getValueAt(selectedRow, 3).toString());
                        form.setTextFieldTimeEnd(form.getTableLichThi().getValueAt(selectedRow, 4).toString());
                    }
                }
            }
        });
    }
    
    private void addLichThi() {
        form.getButtonThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idMonThi = monThiService.getIdByName((String)form.getComboBoxMonThi().getSelectedItem());
                    Date ngayLamBai = form.getValueJDateChooser();
                    String gioBatDauStr = form.getTextFieldTimeStart();
                    String gioKetThucStr = form.getTextFieldTimeEnd();
                    if(!(gioBatDauStr.equals("") || gioKetThucStr.equals(""))) {
                        try {
                            LocalTime gioBatDau = LocalTime.parse(gioBatDauStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
                            LocalTime gioKetThuc = LocalTime.parse(gioKetThucStr, DateTimeFormatter.ofPattern("HH:mm:ss"));

                            Time gioBatDauSql = Time.valueOf(gioBatDau);
                            Time gioKetThucSql = Time.valueOf(gioKetThuc);
                                LichThi lichthi = new LichThi(idMonThi, gioBatDauSql, gioKetThucSql, ngayLamBai);
                                lichThiService.createLichThi(lichthi);
                                refreshDataTable(idMonThi);
                                JOptionPane.showMessageDialog(form, "Thêm thành công!");
                        } catch (DateTimeParseException ex) {
                            JOptionPane.showMessageDialog(form, "Định dạng thời gian không hợp lệ!");
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
    
    private void updateLichThi() {
        form.getButtonSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idMonThi = monThiService.getIdByName((String)form.getComboBoxMonThi().getSelectedItem());
                    Date ngayLamBai = form.getValueJDateChooser();
                    String gioBatDauStr = form.getTextFieldTimeStart();
                    String gioKetThucStr = form.getTextFieldTimeEnd();
                    if(!(gioBatDauStr.equals("") || gioKetThucStr.equals(""))) {
                        try {
                            LocalTime gioBatDau = LocalTime.parse(gioBatDauStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
                            LocalTime gioKetThuc = LocalTime.parse(gioKetThucStr, DateTimeFormatter.ofPattern("HH:mm:ss"));

                            Time gioBatDauSql = Time.valueOf(gioBatDau);
                            Time gioKetThucSql = Time.valueOf(gioKetThuc);
                             
                            LichThi lichThi = new LichThi();
                            lichThi.setIdMonThi(idMonThi);
                            lichThi.setGioBatDau(gioBatDauSql);
                            lichThi.setGioKetThuc(gioKetThucSql);
                            lichThi.setNgayLamBai(ngayLamBai);
                            if(lichThiService.updateLichThi(idLichThi, lichThi) != null) {
                                refreshDataTable(idMonThi);
                                JOptionPane.showMessageDialog(form, "Sửa thành công!");
                            } 
                        } catch (DateTimeParseException ex) {
                            JOptionPane.showMessageDialog(form, "Định dạng thời gian không hợp lệ!");
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
    
    private void deleteLichThi() {
        form.getButtonXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idMonThi = monThiService.getIdByName((String)form.getComboBoxMonThi().getSelectedItem());
                    int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá lịch thi", JOptionPane.YES_NO_OPTION);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                        if(lichThiService.deleteLichThi(idLichThi)) {
                            refreshDataTable(idMonThi);
                            JOptionPane.showMessageDialog(form, "Xóa thành công");
                        } else {
                            JOptionPane.showMessageDialog(form, "Không thể xóa lịch thi", "Error", JOptionPane.INFORMATION_MESSAGE);
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
    
    private void refreshDataTable(String idMonThi) {
        try {
         List<LichThi> dsLichThi = lichThiService.getAllLichThiByIdMonThi(idMonThi);
            tableModelLichThi.setRowCount(0);
            for (LichThi lichThi : dsLichThi) {
                Object[] row = {lichThi.getIdLichThi(), lichThi.getTenMonThi(), lichThi.getNgayLamBai(), lichThi.getGioBatDau(), lichThi.getGioKetThuc()};
                tableModelLichThi.addRow(row);
            }
            form.getTableLichThi().setModel(tableModelLichThi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
