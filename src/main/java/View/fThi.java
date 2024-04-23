/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ThiTracNghiemController;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author Khoahihi79
 */
public class fThi extends javax.swing.JFrame {

    private static String username;
    private static String idMonThi;
    private static String tenMonThi;
    private static String maDeThi;
    
    public fThi(String username, String idMonThi, String tenMonThi, String maDeThi) {
        this.username = username;
        this.idMonThi = idMonThi;
        this.tenMonThi = tenMonThi;
        this.maDeThi = maDeThi;
        initComponents();
        this.pack();
        ThiTracNghiemController controller = new ThiTracNghiemController(this, username, idMonThi, tenMonThi, maDeThi);
    }

    public JButton getButtonPrevious() {
        return jButton_previous;
    }
    
    public JButton getButtonNext() {
        return jButton_next;
    }
    
    public JButton getButtonNopBai() {
        return jButton_nopbai;
    }
    
    public JList getJListCauHoi() {
        return jList_cauHoi;
    }
    
    public JRadioButton getRadioButtonDaA() {
        return jRadioButton_daA;
    }
    
    public JRadioButton getRadioButtonDaB() {
        return jRadioButton_daB;
    }
    
    public JRadioButton getRadioButtonDaC() {
        return jRadioButton_daC;
    }
    
    public JRadioButton getRadioButtonDaD() {
        return jRadioButton_daD;
    }
   
    public ButtonGroup getButtonGroup() {
        return buttonGroup_choose;
    }
    
    public void setTextAreaCauHoi(String value) {
        jTextArea_cauhoi.setText(value);
    }
    public void setTextLabelSttCauHoi(String value) {
        jLabel_stt.setText(value);
    }
    
    public void setTextLabelCountDown(String value) {
        jLabel_countdown.setText(value);
    }
    
    public void setTextLabelMaSv(String value) {
        jLabel_masv.setText(value);
    }
    
    public void setTextLabelHoTen(String value) {
        jLabel_hoten.setText(value);
    }
    
    public void setTextLabelLop(String value) {
        jLabel_lop.setText(value);
    }
    
    public void setTextLabelMaDe(String value) {
        jLabel_made.setText(value);
    }
    
    public void setTextLabelDeThi(String value) {
        jLabel_dethi.setText(value);
    }
    
    public void setTextLabelMonThi(String value) {
        jLabel_monthi.setText(value);
    }
    
    public void setTextLabelSoLgCauHoi(String value) {
        jLabel_solgcauhoi.setText(value);
    }
    
    public void setTextLabelTimeLamBai(String value) {
        jLabel_tglambai.setText(value);
    }
    
    public String getTextLabelTimeLamBai() {
        return jLabel_tglambai.getText().trim();
    }
    
    public String getTextLabelDiem() {
        return jLabel_diem.getText().trim();
    }
    
    public String getTextLabelSLCH() {
        return jLabel_solgcauhoi.getText().trim();
    }
    
    public String getTextLabelLop() {
        return jLabel_lop.getText().trim();
    }
    
    public void setTextLabelDiem(String value) {
        jLabel_diem.setText(value);
    }
    
    public void setLabelImage(byte[] imageData) {
        if(imageData != null) {
            ImageIcon imageIcon = new ImageIcon(imageData);
            Image scaledImage = imageIcon.getImage().getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            jLabel_image.setIcon(imageIcon);
        } else {
            jLabel_image.setIcon(null);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_choose = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_cauHoi = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel_countdown = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_masv = new javax.swing.JLabel();
        jLabel_hoten = new javax.swing.JLabel();
        jLabel_lop = new javax.swing.JLabel();
        jLabel_image = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel_made = new javax.swing.JLabel();
        jLabel_dethi = new javax.swing.JLabel();
        jLabel_solgcauhoi = new javax.swing.JLabel();
        jLabel_monthi = new javax.swing.JLabel();
        jLabel_diem = new javax.swing.JLabel();
        jLabel_tglambai = new javax.swing.JLabel();
        jLabel_stt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_cauhoi = new javax.swing.JTextArea();
        jRadioButton_daA = new javax.swing.JRadioButton();
        jRadioButton_daC = new javax.swing.JRadioButton();
        jRadioButton_daB = new javax.swing.JRadioButton();
        jRadioButton_daD = new javax.swing.JRadioButton();
        jButton_previous = new javax.swing.JButton();
        jButton_next = new javax.swing.JButton();
        jButton_nopbai = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jList_cauHoi.setBackground(new java.awt.Color(255, 255, 255));
        jList_cauHoi.setForeground(new java.awt.Color(0, 0, 0));
        jList_cauHoi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList_cauHoi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 280, 485));

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách câu hỏi");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 14, 268, 42));

        jLabel_countdown.setBackground(new java.awt.Color(51, 204, 255));
        jLabel_countdown.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_countdown.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_countdown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_countdown.setOpaque(true);
        jPanel1.add(jLabel_countdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 14, 245, 42));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thí sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã sinh viên:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Họ tên:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Lớp:");

        jLabel_masv.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_masv.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_hoten.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_hoten.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_lop.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_lop.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_image.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_image.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel_image.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_hoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_lop, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel_image, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_lop, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đề thi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Mã đề:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Đề thi:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Môn thi:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Số lượng câu hỏi:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Thời gian làm bài:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Điểm tối đa:");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("phút");

        jLabel_made.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_made.setLabelFor(jLabel_made);
        jLabel_made.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_dethi.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_dethi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_solgcauhoi.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_solgcauhoi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_monthi.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_monthi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_diem.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_diem.setToolTipText("");
        jLabel_diem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel_tglambai.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_tglambai.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_dethi, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_made, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_monthi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_diem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_solgcauhoi, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_tglambai)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel_made, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel_solgcauhoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel_dethi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_tglambai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel_monthi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_diem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 450, 172));

        jLabel_stt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_stt.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_stt.setText("Câu 1");
        jPanel1.add(jLabel_stt, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 264, -1, -1));

        jTextArea_cauhoi.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea_cauhoi.setColumns(20);
        jTextArea_cauhoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea_cauhoi.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea_cauhoi.setRows(5);
        jTextArea_cauhoi.setText("mbnm");
        jTextArea_cauhoi.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea_cauhoi.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea_cauhoi);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 307, 739, 131));

        jRadioButton_daA.setBackground(java.awt.SystemColor.activeCaption);
        buttonGroup_choose.add(jRadioButton_daA);
        jRadioButton_daA.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_daA.setText("jRadioButton_daA");
        jRadioButton_daA.setOpaque(true);
        jPanel1.add(jRadioButton_daA, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 467, -1, -1));

        jRadioButton_daC.setBackground(java.awt.SystemColor.activeCaption);
        buttonGroup_choose.add(jRadioButton_daC);
        jRadioButton_daC.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_daC.setText("jRadioButton_daC");
        jRadioButton_daC.setOpaque(true);
        jPanel1.add(jRadioButton_daC, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 538, -1, -1));

        jRadioButton_daB.setBackground(java.awt.SystemColor.activeCaption);
        buttonGroup_choose.add(jRadioButton_daB);
        jRadioButton_daB.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_daB.setText("jRadioButton_daB");
        jRadioButton_daB.setOpaque(true);
        jPanel1.add(jRadioButton_daB, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 467, -1, -1));

        jRadioButton_daD.setBackground(java.awt.SystemColor.activeCaption);
        buttonGroup_choose.add(jRadioButton_daD);
        jRadioButton_daD.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_daD.setText("jRadioButton_daD");
        jRadioButton_daD.setToolTipText("");
        jRadioButton_daD.setOpaque(true);
        jPanel1.add(jRadioButton_daD, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 538, -1, -1));

        jButton_previous.setBackground(new java.awt.Color(255, 255, 255));
        jButton_previous.setForeground(new java.awt.Color(0, 0, 0));
        jButton_previous.setText("Câu trước");
        jButton_previous.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 577, 88, 38));

        jButton_next.setBackground(new java.awt.Color(255, 255, 255));
        jButton_next.setForeground(new java.awt.Color(0, 0, 0));
        jButton_next.setText("Câu tiếp theo");
        jButton_next.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 577, 88, 38));

        jButton_nopbai.setBackground(new java.awt.Color(255, 255, 255));
        jButton_nopbai.setForeground(new java.awt.Color(0, 0, 0));
        jButton_nopbai.setText("Nộp bài");
        jButton_nopbai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton_nopbai, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 580, 88, 38));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(fThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fThi(username, idMonThi, tenMonThi, maDeThi).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_choose;
    private javax.swing.JButton jButton_next;
    private javax.swing.JButton jButton_nopbai;
    private javax.swing.JButton jButton_previous;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_countdown;
    private javax.swing.JLabel jLabel_dethi;
    private javax.swing.JLabel jLabel_diem;
    private javax.swing.JLabel jLabel_hoten;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JLabel jLabel_lop;
    private javax.swing.JLabel jLabel_made;
    private javax.swing.JLabel jLabel_masv;
    private javax.swing.JLabel jLabel_monthi;
    private javax.swing.JLabel jLabel_solgcauhoi;
    private javax.swing.JLabel jLabel_stt;
    private javax.swing.JLabel jLabel_tglambai;
    private javax.swing.JList<String> jList_cauHoi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton_daA;
    private javax.swing.JRadioButton jRadioButton_daB;
    private javax.swing.JRadioButton jRadioButton_daC;
    private javax.swing.JRadioButton jRadioButton_daD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_cauhoi;
    // End of variables declaration//GEN-END:variables
}
