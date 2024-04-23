package Controller;

import Api.CauHoiService;
import Api.DeThiService;
import Api.MonThiService;
import Entity.CauHoi;
import Entity.ChiTietDeThi;
import Entity.DeThi;
import Entity.MonThi;
import View.fChiTietDeThi;
import View.fDeThi;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Khoahihi79
 */
public class DeThiController {
    private fDeThi form;
    private DeThiService deThiService;
    private MonThiService monThiService;
    private CauHoiService cauHoiService;
    private DefaultTableModel tableModelDeThi;
    
    public DeThiController(fDeThi form) {
        this.form = form;
        this.deThiService = new DeThiService();
        this.monThiService = new MonThiService();
        this.cauHoiService = new CauHoiService();
        createModelTable();
        showComboBox();
        jTableDeThi_addCellListener();
        showDeThiByMonThi();
        jTable_dethi_CellClick();
        addDeThi();
        updateDeThi();
        deleteDeThi();
        clearTextFied();
        searchDeThi();
        randomCauHoi();
        showFormChiTetDeThi();
    }
    
     private void createModelTable() {
        tableModelDeThi = new DefaultTableModel();
        tableModelDeThi.addColumn("Mã đề thi");
        tableModelDeThi.addColumn("Tên đề");
        tableModelDeThi.addColumn("Ngày tạo");
        tableModelDeThi.addColumn("Điểm tối đa");
        tableModelDeThi.addColumn("Môn thi");
        tableModelDeThi.addColumn("Số lượng câu");
        tableModelDeThi.addColumn("Thời gian thi");
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
     
     private void showDeThiByMonThi() {
         form.getComboBoxMonThi().addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 if(e.getStateChange() == ItemEvent.SELECTED) {
                     try {
                        String tenMonThi = (String)form.getComboBoxMonThi().getSelectedItem();
                        String idMonThi = monThiService.getIdByName(tenMonThi);
                        List<DeThi> listDeThi = deThiService.getAllDeThiByIdMonThi(idMonThi);
                        if(listDeThi != null) {
                            tableModelDeThi.setRowCount(0);
                            JTable tableDeThi = form.getTableDeThi();      
                            for(DeThi dethi: listDeThi) {
                                Object[] row= {dethi.getIdDeThi(), dethi.getTenDeThi(), dethi.getNgayTao(), dethi.getDiemToiDa(), 
                                                        dethi.getTenMonThi(), dethi.getSoLuongCauHoi(), dethi.getThoiGianThi()};
                                tableModelDeThi.addRow(row);
                            }
                            tableDeThi.setModel(tableModelDeThi);
                        }
                        showCauHoiByMonThi();
                     } catch (IOException ex) {
                         ex.printStackTrace();
                     }
                 }
             }
         });
     }
     
     private void showCauHoiByMonThi() {
         try {
            String tenMon = (String)form.getComboBoxMonThi().getSelectedItem();
            String idMonThi = monThiService.getIdByName(tenMon);
            List<CauHoi> listCauHoi = cauHoiService.getAllCauHoiByIdMonThi(idMonThi);
            if(listCauHoi != null) {
               JTable tableCauHoi = form.getTableCauHoi();
               DefaultTableModel model = new DefaultTableModel() {
                   public Class<?> getColumnClass(int column) {
                       switch(column) {
                           case 0: 
                               return Boolean.class;
                           case 1: 
                               return String.class;
                           case 2: 
                               return String.class;
                           case 3: 
                               return String.class;
                           case 4: 
                               return String.class;
                           case 5: 
                               return String.class;
                           case 6: 
                               return String.class;
                           case 7: 
                               return String.class;
                           case 8: 
                               return String.class;
                           case 9: 
                               return String.class;
                           case 10: 
                               return String.class;

                           default:
                               return String.class;
                       }
                   }
               };
               model.addColumn("Chọn câu hỏi");
               model.addColumn("IdCauHoi");
               model.addColumn("CauHoi");
               model.addColumn("Dap_An_A");
               model.addColumn("Dap_An_B");
               model.addColumn("Dap_An_C");
               model.addColumn("Dap_An_D");
               model.addColumn("DapAnDung");
               model.addColumn("TenMonThi");
               model.addColumn("TenMucDo");
               model.addColumn("TenChuong");
               for(int i = 0; i < listCauHoi.size(); i++) {
                   CauHoi cauhoi = listCauHoi.get(i);
                   model.addRow(new Object[0]);
                   model.setValueAt(false, i, 0);
                   model.setValueAt(cauhoi.getIdCauHoi(), i, 1);
                   model.setValueAt(cauhoi.getCauHoi(), i, 2);
                   model.setValueAt(cauhoi.getDapAnA(), i, 3);
                   model.setValueAt(cauhoi.getDapAnB(), i, 4);
                   model.setValueAt(cauhoi.getDapAnC(), i, 5);
                   model.setValueAt(cauhoi.getDapAnD(), i, 6);
                   model.setValueAt(cauhoi.getDapAnDung(), i, 7);
                   model.setValueAt(cauhoi.getTenMonThi(), i, 8);
                   model.setValueAt(cauhoi.getTenMucDo(), i, 9);
                   model.setValueAt(cauhoi.getTenChuong(), i, 10);
               }
               tableCauHoi.setModel(model);
           } 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     }
     
     List<Integer> listCauHoi = new ArrayList<>();
     private void jTable_dethi_CellClick() {
         form.getTableDeThi().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             @Override
             public void valueChanged(ListSelectionEvent e) {
                 if(!e.getValueIsAdjusting()) {
                     int selectedRow = form.getTableDeThi().getSelectedRow();
                     if(selectedRow != -1) {
                         String idDeThi = form.getTableDeThi().getValueAt(selectedRow, 0).toString();
                         form.setTextFieldMaDe(idDeThi);
                         form.setTextFieldTenDe(form.getTableDeThi().getValueAt(selectedRow, 1).toString());
                         form.setValueJSpinnerTime(Integer.parseInt(form.getTableDeThi().getValueAt(selectedRow, 6).toString()));
                         form.setTextFieldDiem(form.getTableDeThi().getValueAt(selectedRow, 3).toString());
                         form.setValueJSpinnerCount(Integer.parseInt(form.getTableDeThi().getValueAt(selectedRow, 5).toString()));
                         form.setValueJDateChoose(Date.valueOf(form.getTableDeThi().getValueAt(selectedRow, 2).toString()));
                         listCauHoi = getListCauHoi(idDeThi);
                         updateCheckBoxCauHoi(listCauHoi);
                     }
                 }
             }
         });
     }
     
     
     private void showFormChiTetDeThi() {
         form.getTableDeThi().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Sự kiện click đơn
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    if (row != -1) {
                        String idDeThi = (String) target.getValueAt(row, 0);
                        String monThi = (String) form.getComboBoxMonThi().getSelectedItem();
                        fChiTietDeThi form = new fChiTietDeThi(idDeThi, monThi);
                        form.setVisible(true);
                    }
                }
            }
        });
     }
     private List<Integer> getListCauHoi(String idDeThi) {
         List<Integer> listCauHoi = new ArrayList<>();
         try {
            List<ChiTietDeThi> listCTDT = deThiService.getAllByIdDeThi(idDeThi);  
            for(ChiTietDeThi ctdt : listCTDT) {
                listCauHoi.add(ctdt.getIdCauHoi());
            }
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         return listCauHoi;
     }
     
     private void updateCheckBoxCauHoi(List<Integer> listCauHoi) {
         DefaultTableModel model = (DefaultTableModel)form.getTableCauHoi().getModel();
         int selectedCount = 0;
         for(int i = 0; i < model.getRowCount(); i++) {
             if(model.getValueAt(i, 1) != null) {
                 int cauHoi = Integer.parseInt(model.getValueAt(i, 1).toString());
                 if(listCauHoi.contains(cauHoi)) {
                     model.setValueAt(true, i, 0);
                     selectedCount++;
                 } else {
                     model.setValueAt(false, i, 0);
                 }
             }
         }
         form.setTextFieldSoLgCauHoi(String.valueOf(selectedCount));
     }
     
     private void randomCauHoi() {
         form.getButtonRandom().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 int selectedCount = 0;
                 int randomCount = Integer.parseInt(form.getValueJSpinnerCount());
                 //Lặp qua tất cả các hàng trong jTable_cauhoi
                 for(int i = 0; i < form.getTableCauHoi().getRowCount(); i++) {
                     //Nếu ô checkbox được chọn thì tăng biến đếm
                     if ((boolean) form.getTableCauHoi().getValueAt(i, 0)) {
                         selectedCount++;
                     }
                 }
                 //Nếu đã chọn đủ số câu hỏi thì dừng lại
                 if(selectedCount >= randomCount) {
                     return;
                 }
              
                 //Nếu chưa đủ số câu thì tiếp tục random
                 Random rand = new Random();
                 while(selectedCount < randomCount) {
                     int rowInedx = rand.nextInt(form.getTableCauHoi().getRowCount() - 1);
                     if(!(boolean) form.getTableCauHoi().getValueAt(rowInedx, 0)) {
                         form.getTableCauHoi().setValueAt(true, rowInedx, 0);
                         selectedCount++;
                         form.setTextFieldSoLgCauHoi(String.valueOf(selectedCount));
                     }
                 }
             }
         });
     }
     //Xử lý khi các ô checkbox thay đổi trạng thái
     private void jTableDeThi_addCellListener() {
         JTable tableCauHoi = form.getTableCauHoi();
         TableColumnModel columnModel = tableCauHoi.getColumnModel();
         TableColumn columnCheck = columnModel.getColumn(0);
         columnCheck.setCellEditor(tableCauHoi.getDefaultEditor(Boolean.class));
         columnCheck.getCellEditor().addCellEditorListener(new CellEditorListener() {
             @Override
             public void editingStopped(ChangeEvent e) {
                 updateSelectedCount();
             }

             @Override
             public void editingCanceled(ChangeEvent e) {
             }
         });
     }
     
     private void updateSelectedCount() {
        int selectedCount = 0;
        DefaultTableModel model = (DefaultTableModel) form.getTableCauHoi().getModel();
        for(int i = 0; i < model.getRowCount(); i++) {
            if((boolean)model.getValueAt(i, 0)) {
                selectedCount++;
            }
        }
        if(selectedCount <= Integer.parseInt(form.getValueJSpinnerCount())) {
            form.setTextFieldSoLgCauHoi(String.valueOf(selectedCount));
        } else {
            JOptionPane.showMessageDialog(form, "Số lượng câu hỏi đã chọn vượt quá số câu cho phép!");
            int index = form.getTableCauHoi().getSelectedRow();
            model.setValueAt(false, index, 0);
        }
     }
     
     private void addDeThi() {
         form.getButtonThem().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                    String idDeThi = form.getTextFieldMaDe();
                    String tenDeThi = form.getTextFieldTenDe();
                    Date ngayTao = form.getValueJDateChooser();
                    int diemToiDa = Integer.parseInt(form.getTextFieldDiem());
                    String tenMonThi = (String)form.getComboBoxMonThi().getSelectedItem();
                    String idMonThi = monThiService.getIdByName(tenMonThi);
                    int soLuongCau = Integer.parseInt(form.getValueJSpinnerCount());
                    int thoiGianThi = Integer.parseInt(form.getValueJSpinnerTime());
                    if(!(idDeThi.equals("") || tenDeThi.equals(""))) {
                        DeThi dethi = new DeThi(idDeThi, tenDeThi, ngayTao, diemToiDa, idMonThi, soLuongCau, thoiGianThi);
                        if(deThiService.createDeThi(dethi) != null) {
                            refreshDataTable(idMonThi);
                            for(int i = 0; i < form.getTableCauHoi().getRowCount(); i++) {
                                if((boolean)form.getTableCauHoi().getValueAt(i, 0)) {
                                    String idCauHoi = form.getTableCauHoi().getValueAt(i, 1).toString();
                                    int idCauHoii = Integer.parseInt(idCauHoi);
                                    ChiTietDeThi ctdt = new ChiTietDeThi(idCauHoii, idDeThi);
                                    deThiService.createChiTietDeThi(ctdt);
                                }
                            }
                            JOptionPane.showMessageDialog(form, "Thêm thành công!");
                        } else {
                           JOptionPane.showMessageDialog(form, "Mã đề đã tồn tại!");
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
     
     private void updateDeThi() {
         form.getButtonSua().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                    String idDeThi = form.getTextFieldMaDe();
                    String tenDeThi = form.getTextFieldTenDe();
                    Date ngayTao = form.getValueJDateChooser();
                    int diemToiDa = Integer.parseInt(form.getTextFieldDiem());
                    String tenMonThi = (String)form.getComboBoxMonThi().getSelectedItem();
                    String idMonThi = monThiService.getIdByName(tenMonThi);
                    int soLuongCau = Integer.parseInt(form.getValueJSpinnerCount());
                    int thoiGianThi = Integer.parseInt(form.getValueJSpinnerTime());
                    if(!(idDeThi.equals("") || tenDeThi.equals(""))) {
                        DeThi dethi = new DeThi();
                        dethi.setTenDeThi(tenDeThi);
                        dethi.setNgayTao(ngayTao);
                        dethi.setDiemToiDa(diemToiDa);
                        dethi.setIdMonThi(idMonThi);
                        dethi.setSoLuongCauHoi(soLuongCau);
                        dethi.setThoiGianThi(thoiGianThi);
                        updateCauHoi(idDeThi);
                        if(deThiService.updateDeThi(idDeThi, dethi) != null) {
                            refreshDataTable(idMonThi);
                           JOptionPane.showMessageDialog(form, "Sửa thành công!");
                        } else {
                           JOptionPane.showMessageDialog(form, "Lỗi không thể sửa đề thi!");
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
     
     private void updateCauHoi(String idDeThi) {
         try {
            deThiService.deleteChiTietDeThi(idDeThi);
            for(int i = 0; i < form.getTableCauHoi().getRowCount(); i++) {
               if((boolean)form.getTableCauHoi().getValueAt(i, 0)) {
                   String idCauHoi = form.getTableCauHoi().getValueAt(i, 1).toString();
                   int idCauHoii = Integer.parseInt(idCauHoi);
                   ChiTietDeThi ctdt = new ChiTietDeThi(idCauHoii, idDeThi);
                   deThiService.createChiTietDeThi(ctdt);
               }
           }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     }
     
     private void deleteDeThi() {
         form.getButtonXoa().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                try {
                    String idMonThi = monThiService.getIdByName((String)form.getComboBoxMonThi().getSelectedItem());
                    String idDeThi = form.getTextFieldMaDe();
                    int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá đề thi", JOptionPane.YES_NO_OPTION);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                        if(deThiService.deleteDeThi(idDeThi)) {
                            refreshDataTable(idMonThi);
                            JOptionPane.showMessageDialog(form, "Xóa thành công");
                        } else {
                            JOptionPane.showMessageDialog(form, "Không thể xóa đề thi", "Error", JOptionPane.INFORMATION_MESSAGE);
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
     
     private void clearTextFied() {
        form.getButtonRefresh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setTextFieldMaDe("");
                form.setTextFieldTenDe("");
                form.setTextFieldDiem("");
                form.setValueJDateChoose(null);
                form.setValueJSpinnerCount(0);
                form.setValueJSpinnerTime(0);
                for(int i = 0; i < form.getTableCauHoi().getRowCount(); i++) {
                    if((boolean)form.getTableCauHoi().getValueAt(i, 0)) {
                        form.getTableCauHoi().setValueAt(false, i, 0);
                    }
                }
            } 
        });
     }
     
     private void searchDeThi() {
         form.getButtonTimKiem().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                 String idDeThi = form.getTextFieldSearch();
                    if(!idDeThi.equals("")) {
                       DeThi dethi = deThiService.getDeThiById(idDeThi);
                       if(dethi != null) {
                           tableModelDeThi.setRowCount(0);
                           JTable tableDeThi = form.getTableDeThi();
                           
                           Object[] row= {dethi.getIdDeThi(), dethi.getTenDeThi(), dethi.getNgayTao(), dethi.getDiemToiDa(), 
                                            dethi.getTenMonThi(), dethi.getSoLuongCauHoi(), dethi.getThoiGianThi()};
                           
                           tableModelDeThi.addRow(row);
                           tableDeThi.setModel(tableModelDeThi);
                       }
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập thông tin cần tìm kiếm!");
                    }
                 } catch(IOException ex) {
                     ex.printStackTrace();
                 }
             }
         });
     }
     
    private void refreshDataTable(String idMonThi) {
        try {
         List<DeThi> dsDeThi = deThiService.getAllDeThiByIdMonThi(idMonThi);
            tableModelDeThi.setRowCount(0);
            for (DeThi dethi : dsDeThi) {
                Object[] row= {dethi.getIdDeThi(), dethi.getTenDeThi(), dethi.getNgayTao(), dethi.getDiemToiDa(), 
                                dethi.getTenMonThi(), dethi.getSoLuongCauHoi(), dethi.getThoiGianThi()};
                tableModelDeThi.addRow(row);
            }
            form.getTableDeThi().setModel(tableModelDeThi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
