/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.MonThiController;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Khoahihi79
 */
public class fMonThi extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public fMonThi() {
        initComponents();
        MonThiController monThiController = new MonThiController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_monthi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_tenmon = new javax.swing.JTextField();
        jTextField_mamon = new javax.swing.JTextField();
        jButton_them = new javax.swing.JButton();
        jButton_xoa = new javax.swing.JButton();
        jButton_refresh = new javax.swing.JButton();
        jButton_sua = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.activeCaption);

        jPanel1.setOpaque(false);

        jTable_monthi.setBackground(new java.awt.Color(255, 255, 255));
        jTable_monthi.setForeground(new java.awt.Color(0, 0, 0));
        jTable_monthi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã môn thi", "Môn thi"
            }
        ));
        jTable_monthi.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTable_monthi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mã môn thi:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Môn thi: ");

        jTextField_tenmon.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_tenmon.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_mamon.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_mamon.setForeground(new java.awt.Color(0, 0, 0));

        jButton_them.setBackground(new java.awt.Color(255, 255, 255));
        jButton_them.setForeground(new java.awt.Color(0, 0, 0));
        jButton_them.setText("Thêm");

        jButton_xoa.setBackground(new java.awt.Color(255, 255, 255));
        jButton_xoa.setForeground(new java.awt.Color(0, 0, 0));
        jButton_xoa.setText("Xóa");

        jButton_refresh.setBackground(new java.awt.Color(255, 255, 255));
        jButton_refresh.setForeground(new java.awt.Color(0, 0, 0));
        jButton_refresh.setText("Refresh");
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        jButton_sua.setBackground(new java.awt.Color(255, 255, 255));
        jButton_sua.setForeground(new java.awt.Color(0, 0, 0));
        jButton_sua.setText("Sửa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_mamon, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_xoa)
                    .addComponent(jButton_them))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_sua)
                    .addComponent(jButton_refresh))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_mamon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_them)
                    .addComponent(jButton_sua))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton_xoa)
                    .addComponent(jButton_refresh))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        this.setTextFieldMaMon("");
        this.setTextFieldTenMon("");
    }//GEN-LAST:event_jButton_refreshActionPerformed

    public JButton getButtonThem() {
        return jButton_them;
    }
    
    public JButton getButtonSua() {
        return jButton_sua;
    }
    
    public JButton getButtonXoa() {
        return jButton_xoa;
    }
    
    public JButton getButtonRefresh() {
        return jButton_refresh;
    }
    
    public JTable getTableMonThi() {
        return jTable_monthi;
    }
    
    public void setTextFieldMaMon(String value) {
        jTextField_mamon.setText(value);
    }
    
    public void setTextFieldTenMon(String value) {
        jTextField_tenmon.setText(value);
    }
    
    public String getTextFieldMaMon() {
        return jTextField_mamon.getText().trim();
    }
    
    public String getTextFieldTenMon() {
        return jTextField_tenmon.getText().trim();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_sua;
    private javax.swing.JButton jButton_them;
    private javax.swing.JButton jButton_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_monthi;
    private javax.swing.JTextField jTextField_mamon;
    private javax.swing.JTextField jTextField_tenmon;
    // End of variables declaration//GEN-END:variables
}
