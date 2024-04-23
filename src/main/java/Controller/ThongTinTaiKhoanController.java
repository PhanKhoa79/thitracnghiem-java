/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.KetQuaThiService;
import Api.SinhVienService;
import Entity.KetQuaThi;
import Entity.SinhVien;
import View.fThongTinTaiKhoan;
import com.mysql.cj.jdbc.Blob;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class ThongTinTaiKhoanController {
    private fThongTinTaiKhoan form;
    private SinhVienService sinhVienService;
    private KetQuaThiService kqThiService;
    private String username;
    private DefaultTableModel tableModelKqThi;

    public ThongTinTaiKhoanController(fThongTinTaiKhoan form, String username) {
        this.username = username;
        this.form = form;
        this.kqThiService = new KetQuaThiService();
        this.sinhVienService = new SinhVienService();
        createTableModelKqThi();
        showThongTinSv(username);
        showKetQuaThi();
        upLoadFile();
        updateImage();
    }
    
    private void createTableModelKqThi() {
        tableModelKqThi = new DefaultTableModel();
        tableModelKqThi.addColumn("Ngày thi");
        tableModelKqThi.addColumn("Môn thi");
        tableModelKqThi.addColumn("Điểm");
    }
    
    private void showThongTinSv(String username) { 
        try {
            List<SinhVien> listSinhVien = sinhVienService.getAllSinhVienByKeyword(username);
            if(listSinhVien != null) {
                for(SinhVien sinhvien : listSinhVien) {
                    form.setTextFieldMaSV(sinhvien.getIdSinhVien());
                    form.setTextFieldHoTen(sinhvien.getTenSinhVien());
                    String gioiTinh = "";
                    if(sinhvien.getGioiTinh()) {
                        gioiTinh = "Nam";
                    } else {
                        gioiTinh = "Nữ";
                    }
                    form.setTextFieldGioiTinh(gioiTinh);
                    form.setTextFieldNgaySinh(sinhvien.getNgaySinh().toString());
                    form.setTextFieldLop(sinhvien.getTenLop());
                    form.setTextFieldDiaChi(sinhvien.getDiaChi());
                    form.setTextFieldSDT(sinhvien.getSdt());

                    byte[] imageBytes = (byte[])sinhvien.getAnhSinhVien();
                    if(imageBytes != null) {
                        form.setImage(imageBytes);
                    } 
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void showKetQuaThi() {
        try {
        List<KetQuaThi> dsKetQua = kqThiService.getAllByIdSinhVien(username);
            if(dsKetQua != null) {
                JTable tableKetQua = form.getTableKQThi();
                for(KetQuaThi diem : dsKetQua) {
                    double diemValue = ((Double)diem.getDiemThi()).doubleValue();
                    String diemFormat = String.format("%.1f", diemValue);
                    Object[] row = {diem.getNgayThi(), diem.getTenMonThi(), diemFormat};
                    tableModelKqThi.addRow(row);
                }
                tableKetQua.setModel(tableModelKqThi);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void upLoadFile() {
        form.getButtonChoose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file_upload = new JFileChooser();
                int result = file_upload.showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file_upload.getSelectedFile();
                    showImage(selectedFile);
                }
            }
        });
    }
    
    private void showImage(File file) {
        try {
            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
            Image scaledImage = imageIcon.getImage().getScaledInstance(form.getLabelImage().getWidth(), form.getLabelImage().getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            form.getLabelImage().setIcon(scaledIcon);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateImage() {
        form.getButtonUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // String idSinhVien = form.getTextFieldMaSv();
                Icon icon = form.getLabelImage().getIcon();
                if (icon != null) {
                    try {
                        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        form.getLabelImage().paint(bufferedImage.getGraphics());
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
                        byte[] imageBytes = byteArrayOutputStream.toByteArray();
                        if(sinhVienService.updateAnhSinhVien(username, imageBytes)) {
                            JOptionPane.showMessageDialog(form, "Cập nhật ảnh thành công !");
                        } else {
                            JOptionPane.showMessageDialog(form, "Cập nhật ảnh không thành công !");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(form, "Lỗi khi chuyển đổi ảnh !");
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng chọn ảnh trước khi cập nhật !");
                }
            }
        }); 
    } 
}
