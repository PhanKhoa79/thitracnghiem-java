/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.DeThiService;
import Api.LichThiService;
import Api.MonThiService;
import Api.SinhVienService;
import Entity.DeThi;
import Entity.LichThi;
import Entity.MonThi;
import Entity.SinhVien;
import View.fBaiThi;
import View.fGiangVien;
import View.fSinhVien;
import View.fThi;
import com.mysql.cj.jdbc.Blob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Khoahihi79
 */
public class BaiThiController {
    private fBaiThi form;
    private MonThiService monThiService;
    private DeThiService deThiService;
    private SinhVienService sinhVienService;
    private LichThiService lichThiService;
    private String username;
    private String maDeThi;

    public BaiThiController() {}
    
    public BaiThiController(fBaiThi form, String username) {
        this.username = username;
        this.form = form;
        this.lichThiService = new LichThiService();
        this.monThiService = new MonThiService();
        this.sinhVienService = new SinhVienService();
        this.deThiService = new DeThiService();
        showComboBox();
        showThongTinSv();
        comboBox_monthi_selectedValue();
        button_vaothi_actionPerformed();
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
     
    public void showThongTinSv() {
        try {
            List<SinhVien> listSinhSien = sinhVienService.getAllSinhVienByKeyword(username);
            if(listSinhSien != null) {
                for(SinhVien sinhvien : listSinhSien) {
                    form.setTextFieldMaSV(sinhvien.getIdSinhVien());
                    form.setTextFieldTenSV(sinhvien.getTenSinhVien());
                    form.setTextFieldLop(sinhvien.getTenLop());
                     // Ép kiểu và hiển thị ảnh
                    if(form.getJLabelImage().getIcon() != null) {
                        form.setImage(null);
                    }
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
   
    public void comboBox_monthi_selectedValue() {
        form.getComboBoxMonThi().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                   try {
                    String idMonThi = monThiService.getIdByName((String)form.getComboBoxMonThi().getSelectedItem().toString());
                    List<String> danhSachIdDeThi = danhSachIdDeThi(idMonThi);
                    maDeThi = randomDeThi(danhSachIdDeThi);
                   } catch (IOException ex) {
                       ex.printStackTrace();
                   }
                }
            }
        });
    }
    
    public List<String> danhSachIdDeThi(String idMonThi) {
        List<String> listIdDeThi = new ArrayList<>();
        try {
            List<DeThi> listDeThi = deThiService.getAllDeThiByIdMonThi(idMonThi);
            if(listDeThi != null) {
                for(DeThi deThi : listDeThi) {
                    listIdDeThi.add(deThi.getIdDeThi());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return listIdDeThi;
    }
    
    public String randomDeThi(List<String> danhSachDeThi) {
        if(danhSachDeThi == null) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(danhSachDeThi.size());
        return danhSachDeThi.get(index);
    }
    
    private void button_vaothi_actionPerformed() {
        form.getButtonStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
               try {
                String tenMonThi = (String)form.getComboBoxMonThi().getSelectedItem().toString();
                String idMonThi = monThiService.getIdByName(tenMonThi);
                List<LichThi> dsLichThi = lichThiService.getAllLichThiByIdMonThi(idMonThi);
                if(dsLichThi != null) {
                    LichThi lichthi = dsLichThi.get(0);

                    LocalDate ngayThi = ((java.sql.Date) lichthi.getNgayLamBai()).toLocalDate();

                     // Lấy ra phần giờ từ giờ bắt đầu và giờ kết thúc
                     LocalTime gioBatDau = ((java.sql.Time) lichthi.getGioBatDau()).toLocalTime();
                     LocalTime gioKetThuc = ((java.sql.Time) lichthi.getGioKetThuc()).toLocalTime();

                     // Lấy ngày hiện tại
                     LocalDate ngayHienTai = LocalDate.now();
                     // Lấy giờ hiện tại
                     LocalTime gioHienTai = LocalTime.now();

                    if(ngayHienTai.compareTo(ngayThi) < 0) {
                        JOptionPane.showMessageDialog(form, "Chưa đến ngày thi!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else if (ngayHienTai.compareTo(ngayThi) > 0) {
                       JOptionPane.showMessageDialog(form, "Đã quá ngày làm bài thi. Vui lòng thi lại đợt khác!", "Thông báo", JOptionPane.INFORMATION_MESSAGE); 
                    } else {
                        if(gioHienTai.compareTo(gioBatDau) < 0) {
                             JOptionPane.showMessageDialog(form, "Chưa đến giờ thi! Vui lòng quay lại vào " + gioBatDau.toString(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        } else if (gioHienTai.compareTo(gioKetThuc) > 0) {
                             JOptionPane.showMessageDialog(form, "Đã hết giờ làm bài thi trong hôm nay!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        } else {

                            fThi formThi = new fThi(username, idMonThi , tenMonThi, maDeThi);
                            formThi.setVisible(true);
                        }
                    }
                 }
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
            }
        });
    }
}
