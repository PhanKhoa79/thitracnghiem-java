/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.SinhVienService;
import Entity.SinhVien;
import View.fKQ;
import View.fSinhVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Khoahihi79
 */
public class KetQuaController {
    private fKQ form;
    private String username;
    private String tenMonThi;
    private double score;
    private String message;
    private SinhVienService sinhVienService;

    public KetQuaController(fKQ form, String username, String tenMonThi, double score, String message) {
        this.form = form;
        this.username = username;
        this.tenMonThi = tenMonThi;
        this.score = score;
        this.message = message;
        this.sinhVienService = new SinhVienService();
        loadKetQuaSV();
        button_back_actionPerformed();
    }
    
    private void loadKetQuaSV() {
        try {
            List<SinhVien> listSinhVien = sinhVienService.getAllSinhVienByKeyword(username);
            if(listSinhVien != null) {
                for(SinhVien sinhVien : listSinhVien) {
                    form.setTextFieldMaSV(sinhVien.getIdSinhVien());
                    form.setTextFieldHoTen(sinhVien.getTenSinhVien());
                    form.setTextFieldLop(sinhVien.getTenLop());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        form.setTextFieldMonThi(tenMonThi);
        form.setTextFieldDiem(String.format("%.1f", score));
        form.setTextAreaDapAn(message);
    }
    
    private void button_back_actionPerformed() {
        form.getButtonBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setVisible(false);
                fSinhVien fSV = new fSinhVien(username);
                fSV.setVisible(true);
            }
        });
    }
    
    
}
