/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import com.sun.source.tree.ForLoopTree;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Khoahihi79
 */
public class fGiangVien extends javax.swing.JFrame {

    /**
     * Creates new form fGiangVien
     */
    public fGiangVien() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelParent = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        btn_cauhoi = new javax.swing.JButton();
        btn_dethi = new javax.swing.JButton();
        btn_monthi = new javax.swing.JButton();
        btn_thisinh = new javax.swing.JButton();
        btn_lichthi = new javax.swing.JButton();
        btn_ketqua = new javax.swing.JButton();
        btn_dangxuat = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelHome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        panelTop = new javax.swing.JPanel();
        label_home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setLocationByPlatform(true);

        panelParent.setBackground(new java.awt.Color(255, 255, 255));
        panelParent.setOpaque(false);

        panelLeft.setBackground(new java.awt.Color(54, 33, 89));

        buttonPanel.setBackground(new java.awt.Color(85, 65, 118));
        buttonPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(7, 1));

        btn_cauhoi.setBackground(new java.awt.Color(85, 65, 118));
        btn_cauhoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cauhoi.setForeground(new java.awt.Color(204, 204, 204));
        btn_cauhoi.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-question-18.png")); // NOI18N
        btn_cauhoi.setText("Câu Hỏi");
        btn_cauhoi.setBorder(null);
        btn_cauhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cauhoiActionPerformed(evt);
            }
        });
        buttonPanel.add(btn_cauhoi);

        btn_dethi.setBackground(new java.awt.Color(85, 65, 118));
        btn_dethi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_dethi.setForeground(new java.awt.Color(204, 204, 204));
        btn_dethi.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-exam-18.png")); // NOI18N
        btn_dethi.setText("Đề Thi");
        btn_dethi.setBorder(null);
        btn_dethi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dethiActionPerformed(evt);
            }
        });
        buttonPanel.add(btn_dethi);

        btn_monthi.setBackground(new java.awt.Color(85, 45, 118));
        btn_monthi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_monthi.setForeground(new java.awt.Color(204, 204, 204));
        btn_monthi.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-physics-book-18.png")); // NOI18N
        btn_monthi.setText("Môn Thi");
        btn_monthi.setBorder(null);
        btn_monthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_monthiActionPerformed(evt);
            }
        });
        buttonPanel.add(btn_monthi);

        btn_thisinh.setBackground(new java.awt.Color(85, 45, 118));
        btn_thisinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thisinh.setForeground(new java.awt.Color(204, 204, 204));
        btn_thisinh.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-user-18.png")); // NOI18N
        btn_thisinh.setText("Thí Sinh");
        btn_thisinh.setBorder(null);
        btn_thisinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thisinhActionPerformed(evt);
            }
        });
        buttonPanel.add(btn_thisinh);

        btn_lichthi.setBackground(new java.awt.Color(85, 45, 118));
        btn_lichthi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_lichthi.setForeground(new java.awt.Color(204, 204, 204));
        btn_lichthi.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-schedule-18.png")); // NOI18N
        btn_lichthi.setText("Lịch Thi");
        btn_lichthi.setBorder(null);
        btn_lichthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lichthiActionPerformed(evt);
            }
        });
        buttonPanel.add(btn_lichthi);

        btn_ketqua.setBackground(new java.awt.Color(54, 33, 89));
        btn_ketqua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ketqua.setForeground(new java.awt.Color(204, 204, 204));
        btn_ketqua.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-score-18.png")); // NOI18N
        btn_ketqua.setText("Kết Quả Thi");
        btn_ketqua.setBorder(null);
        btn_ketqua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ketquaActionPerformed(evt);
            }
        });
        buttonPanel.add(btn_ketqua);

        btn_dangxuat.setBackground(new java.awt.Color(54, 33, 89));
        btn_dangxuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_dangxuat.setForeground(new java.awt.Color(204, 204, 204));
        btn_dangxuat.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-log-out-18.png")); // NOI18N
        btn_dangxuat.setText("Đăng Xuất");
        btn_dangxuat.setBorder(null);
        btn_dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangxuatActionPerformed(evt);
            }
        });
        buttonPanel.add(btn_dangxuat);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelHome.setBackground(new java.awt.Color(255, 255, 255));
        panelHome.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Lectures");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem\\src\\main\\java\\icons\\icons8-teacher-48.png")); // NOI18N

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cardPanel.setName(""); // NOI18N
        cardPanel.setLayout(new java.awt.CardLayout());

        panelTop.setBackground(new java.awt.Color(0, 150, 136));

        label_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_home.setForeground(new java.awt.Color(208, 208, 208));
        label_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_home.setText("Trang Chủ");

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopLayout.createSequentialGroup()
                .addContainerGap(448, Short.MAX_VALUE)
                .addComponent(label_home)
                .addGap(385, 385, 385))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(label_home)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelParentLayout = new javax.swing.GroupLayout(panelParent);
        panelParent.setLayout(panelParentLayout);
        panelParentLayout.setHorizontalGroup(
            panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParentLayout.createSequentialGroup()
                .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelParentLayout.setVerticalGroup(
            panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParentLayout.createSequentialGroup()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
            .addComponent(panelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cauhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cauhoiActionPerformed
        cardPanel.removeAll();
        cardPanel.add(loadForm(new fCauHoi(), "CauHoi"));
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "CauHoi");
        label_home.setText(btn_cauhoi.getText());
    }//GEN-LAST:event_btn_cauhoiActionPerformed

    private void btn_dethiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dethiActionPerformed
        cardPanel.removeAll();
        cardPanel.add(loadForm(new fDeThi(), "DeThi"));
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "DeThi");
        label_home.setText(btn_dethi.getText());
    }//GEN-LAST:event_btn_dethiActionPerformed

    private void btn_monthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_monthiActionPerformed
        cardPanel.removeAll();
        cardPanel.add(loadForm(new fMonThi(), "MonThi"));
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "MonThi");
        label_home.setText(btn_monthi.getText());
    }//GEN-LAST:event_btn_monthiActionPerformed

    private void btn_thisinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thisinhActionPerformed
        cardPanel.removeAll();
        cardPanel.add(loadForm(new fThiSinh(), "ThiSinh"));
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "ThiSinh");
        label_home.setText(btn_thisinh.getText());
    }//GEN-LAST:event_btn_thisinhActionPerformed

    private void btn_lichthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lichthiActionPerformed
        cardPanel.removeAll();
        cardPanel.add(loadForm(new fLichThi(), "LichThi"));
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "LichThi");
        label_home.setText(btn_lichthi.getText());
    }//GEN-LAST:event_btn_lichthiActionPerformed

    private void btn_ketquaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ketquaActionPerformed
        cardPanel.removeAll();
        cardPanel.add(loadForm(new fKetQuaThi(), "KetQua"));
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "KetQua");
        label_home.setText(btn_ketqua.getText());
    }//GEN-LAST:event_btn_ketquaActionPerformed

    private void btn_dangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangxuatActionPerformed
        this.setVisible(false);
        this.dispose();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }//GEN-LAST:event_btn_dangxuatActionPerformed
    
    
    private JPanel loadForm(JPanel form, String name) {
        cardPanel.add(form, name);
        cardPanel.revalidate();
        cardPanel.repaint();
        return form;
    }

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fGiangVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cauhoi;
    private javax.swing.JButton btn_dangxuat;
    private javax.swing.JButton btn_dethi;
    private javax.swing.JButton btn_ketqua;
    private javax.swing.JButton btn_lichthi;
    private javax.swing.JButton btn_monthi;
    private javax.swing.JButton btn_thisinh;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_home;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables
}
