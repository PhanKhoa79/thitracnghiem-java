/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.ThiSinhController;
import java.awt.Image;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Khoahihi79
 */
public class fThiSinh extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public fThiSinh() {
        initComponents();
        ThiSinhController thiSinhController = new ThiSinhController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_sex = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel_image = new javax.swing.JLabel();
        jComboBox_lop = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser_date = new com.toedter.calendar.JDateChooser();
        jTextField_sdt = new javax.swing.JTextField();
        jTextField_qq = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton_nam = new javax.swing.JRadioButton();
        jRadioButton_nu = new javax.swing.JRadioButton();
        jTextField_msv = new javax.swing.JTextField();
        jComboBox_khoa = new javax.swing.JComboBox<>();
        jTextField_sv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_export = new javax.swing.JButton();
        jButton_import = new javax.swing.JButton();
        jButton_refresh = new javax.swing.JButton();
        jButton_xoa = new javax.swing.JButton();
        jButton_them = new javax.swing.JButton();
        jButton_sua = new javax.swing.JButton();
        jButton_search = new javax.swing.JButton();
        jTextField_search = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ttSv = new javax.swing.JTable();

        setBackground(java.awt.SystemColor.activeCaption);

        jPanel1.setOpaque(false);

        jLabel_image.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_image.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel_image.setOpaque(true);

        jComboBox_lop.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_lop.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_lop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn lớp" }));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Lớp:");

        jDateChooser_date.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser_date.setDateFormatString("dd/MM/yyyy");

        jTextField_sdt.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_sdt.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_qq.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_qq.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Quê quán:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("SDT: ");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Giới tính:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ngày sinh:");

        jRadioButton_nam.setBackground(java.awt.SystemColor.activeCaption);
        buttonGroup_sex.add(jRadioButton_nam);
        jRadioButton_nam.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_nam.setText("Nam");

        jRadioButton_nu.setBackground(java.awt.SystemColor.activeCaption);
        buttonGroup_sex.add(jRadioButton_nu);
        jRadioButton_nu.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton_nu.setText("Nữ");

        jTextField_msv.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_msv.setForeground(new java.awt.Color(0, 0, 0));

        jComboBox_khoa.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_khoa.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_khoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn khoa" }));

        jTextField_sv.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_sv.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Họ và tên:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã sinh viên:");

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Khoa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(198, 198, 198)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_qq, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton_nam)
                                .addGap(29, 29, 29)
                                .addComponent(jRadioButton_nu))
                            .addComponent(jTextField_msv, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_sv, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_image, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_lop, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_msv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_sv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButton_nam)
                            .addComponent(jRadioButton_nu))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField_qq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_image, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );

        jPanel2.setOpaque(false);

        jButton_export.setBackground(new java.awt.Color(255, 255, 255));
        jButton_export.setForeground(new java.awt.Color(0, 0, 0));
        jButton_export.setText("Xuất excel");

        jButton_import.setBackground(new java.awt.Color(255, 255, 255));
        jButton_import.setForeground(new java.awt.Color(0, 0, 0));
        jButton_import.setText("Nhập excel");

        jButton_refresh.setBackground(new java.awt.Color(255, 255, 255));
        jButton_refresh.setForeground(new java.awt.Color(0, 0, 0));
        jButton_refresh.setText("Refresh");

        jButton_xoa.setBackground(new java.awt.Color(255, 255, 255));
        jButton_xoa.setForeground(new java.awt.Color(0, 0, 0));
        jButton_xoa.setText("Xóa");

        jButton_them.setBackground(new java.awt.Color(255, 255, 255));
        jButton_them.setForeground(new java.awt.Color(0, 0, 0));
        jButton_them.setText("Thêm");

        jButton_sua.setBackground(new java.awt.Color(255, 255, 255));
        jButton_sua.setForeground(new java.awt.Color(0, 0, 0));
        jButton_sua.setText("Sửa");

        jButton_search.setBackground(new java.awt.Color(255, 255, 255));
        jButton_search.setForeground(new java.awt.Color(0, 0, 0));
        jButton_search.setText("Tìm kiếm");

        jTextField_search.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_search.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_export, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jButton_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jButton_import, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_search)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_search))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_export, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_import, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable_ttSv.setBackground(new java.awt.Color(255, 255, 255));
        jTable_ttSv.setForeground(new java.awt.Color(0, 0, 0));
        jTable_ttSv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_ttSv.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTable_ttSv);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getButtonRefresh() {
        return jButton_refresh;
    }
    
    public JButton getButtonThem() {
        return jButton_them;
    }
    
    public JButton getButtonSua() {
        return jButton_sua;
    }
    
    public JButton getButtonXoa() {
        return jButton_xoa;
    }
    
    public JButton getButtonTimKiem() {
        return jButton_search;
    }
    
    public JButton getButtonExport() {
        return jButton_export;
    }
    
    public JButton getButtonImport() {
        return jButton_import;
    }
    
    public JComboBox<String> getComboBoxKhoa() {
        return jComboBox_khoa;
    }
    
    public JComboBox<String> getComboBoxLop() {
        return jComboBox_lop;
    }
    
    public JTable getTableThiSinh() {
        return jTable_ttSv;
    }
    
    public String getTextFieldSearch() {
        return jTextField_search.getText().trim();
    }
    
    public void setTextFieldMaSV(String value) {
        jTextField_msv.setText(value);
    }
    
    public String getTextFieldMaSV() {
        return jTextField_msv.getText().trim();
    }
    
    public void setTextFieldTenSV(String value) {
        jTextField_sv.setText(value);
    }
    
    public String getTextFieldTenSV() {
        return jTextField_sv.getText().trim();
    }
    
    public void setTextFieldSDT(String value) {
        jTextField_sdt.setText(value);
    }
    
    public String getTextFieldSDT() {
        return jTextField_sdt.getText().trim();
    }
    
    public void setTextFieldQQ(String value) {
        jTextField_qq.setText(value);
    }
    
    public String getTextFieldQQ() {
        return jTextField_qq.getText().trim();
    }
    
    public void setValueJDateChoose(Date value) {
        jDateChooser_date.setDate(value);
    }
    
    public Date getValueJDateChooser() {
        java.util.Date utilDate = jDateChooser_date.getDate(); 
        return new Date(utilDate.getTime());
    }
    
    public void setComboBoxLop(String value) {
        jComboBox_lop.setSelectedItem(value);
    }
    
    public void setRadioButtonNam(boolean isSelected) {
        jRadioButton_nam.setSelected(isSelected);
    }

    public void setRadioButtonNu(boolean isSelected) {
        jRadioButton_nu.setSelected(isSelected);
    }
    
    public boolean getRadioButtonNamSelected() {
        return jRadioButton_nam.isSelected();
    }   

    public boolean getRadioButtonNuSelected() {
       return jRadioButton_nu.isSelected();
    }
    
    public ButtonGroup getRadioButtonGroupSex() {
        return buttonGroup_sex;
    }
    
    public void setStudentImage(byte[] imageData) {
        if(imageData != null) {
        // Chuyển dữ liệu byte thành ảnh và hiển thị trên JLabel
            ImageIcon imageIcon = new ImageIcon(imageData);
        // Resize ảnh nếu cần
            Image image = imageIcon.getImage();
            int width = 134;
            int height = 184;
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            // Hiển thị ảnh trên JLabel
            jLabel_image.setIcon(imageIcon);
        } else {
            jLabel_image.setIcon(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_sex;
    private javax.swing.JButton jButton_export;
    private javax.swing.JButton jButton_import;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_search;
    private javax.swing.JButton jButton_sua;
    private javax.swing.JButton jButton_them;
    private javax.swing.JButton jButton_xoa;
    private javax.swing.JComboBox<String> jComboBox_khoa;
    private javax.swing.JComboBox<String> jComboBox_lop;
    private com.toedter.calendar.JDateChooser jDateChooser_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton_nam;
    private javax.swing.JRadioButton jRadioButton_nu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ttSv;
    private javax.swing.JTextField jTextField_msv;
    private javax.swing.JTextField jTextField_qq;
    private javax.swing.JTextField jTextField_sdt;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JTextField jTextField_sv;
    // End of variables declaration//GEN-END:variables
}
