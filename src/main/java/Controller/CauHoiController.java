/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.CauHoiService;
import Api.ChuongService;
import Api.MonThiService;
import Api.MucDoService;
import Entity.CauHoi;
import Entity.Chuong;
import Entity.MonThi;
import Entity.MucDo;
import View.fCauHoi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Khoahihi79
 */
public class CauHoiController {
    private fCauHoi form;
    private CauHoiService cauHoiService;
    private MonThiService monThiService;
    private ChuongService chuongService;
    private MucDoService mucDoService;
    private DefaultTableModel tableModelCauHoi;

    public CauHoiController(fCauHoi form) {
        this.form = form;
        this.cauHoiService = new CauHoiService();
        this.monThiService = new MonThiService();
        this.mucDoService = new MucDoService();
        this.chuongService = new ChuongService();
        createModelTable();
        showComboBox();
        showTable();
        addListSelectionListener();
        showCauHoiByMonThi();
        showCauHoiByChuong();
        showCauHoiByMucDo();
        addCauHoi();
        updateCauHoi();
        searchCauHoi();
        deleteCauHoi();
        exportExcel();
        importExcel();
    }
    
    private void createModelTable() {
        tableModelCauHoi = new DefaultTableModel();
        tableModelCauHoi.addColumn("IdCauHoi");
        tableModelCauHoi.addColumn("CauHoi");
        tableModelCauHoi.addColumn("Dap_An_A");
        tableModelCauHoi.addColumn("Dap_An_B");
        tableModelCauHoi.addColumn("Dap_An_C");
        tableModelCauHoi.addColumn("Dap_An_D");
        tableModelCauHoi.addColumn("DapAnDung");
        tableModelCauHoi.addColumn("TenMonThi");
        tableModelCauHoi.addColumn("TenMucDo");
        tableModelCauHoi.addColumn("TenChuong");
    }
    
    private void showComboBox() {
        //combobox monthi
        try {
        List<MonThi> listMonThi = monThiService.getAllMonThi();    
        if(listMonThi != null) {
            for(MonThi monthi: listMonThi) {
                form.getComboBoxMonThi().addItem(monthi.getTenMonThi());
            }
        }
        
        //combox muc do
        List<MucDo> listMucDo = mucDoService.getAllMucDo();
            if(listMucDo != null) {
                for(MucDo mucDo: listMucDo) {
                    form.getComboBoxMucDo().addItem(mucDo.getTenMucDo());
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    } 
    
    //Hiển thị các chương theo môn thi
    private void showChuongByMonThi(String idMonThi) {
        try {
            List<Chuong> listChuong = chuongService.getAllChuongByIdMonThi(idMonThi);
            if(listChuong != null) {
                JComboBox comboBoxChuong = form.getComboBoxChuong();
                int index = 0;
                for(int i = comboBoxChuong.getItemCount() - 1; i > index; i--) {
                    comboBoxChuong.removeItemAt(i);
                }
                for(Chuong chuong : listChuong) {
                    comboBoxChuong.addItem(chuong.getTenChuong());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //Hiển thị danh sách các câu hỏi
    private void showTable() {
        try {
            List<CauHoi> listCauHoi = cauHoiService.getAllCauHoi();
            if(listCauHoi != null) {
                JTable tableCauHoi = form.getTableMonThi();           
                for(CauHoi cauHoi : listCauHoi) {
                    Object[] row = {cauHoi.getIdCauHoi(), cauHoi.getCauHoi(), cauHoi.getDapAnA(), cauHoi.getDapAnB(), cauHoi.getDapAnC(),
                        cauHoi.getDapAnD(), cauHoi.getDapAnDung(), cauHoi.getTenMonThi(), cauHoi.getTenMucDo(), cauHoi.getTenChuong()};
                    tableModelCauHoi.addRow(row);
                }
                tableCauHoi.setModel(tableModelCauHoi);
            }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //Hiển thị danh sách câu hỏi theo môn thi
    private void showCauHoiByMonThi() {      
        form.getComboBoxMonThi().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    //Hiển thị câu hỏi theo môn
                    try {
                        String tenMon = (String)form.getComboBoxMonThi().getSelectedItem();
                        String idMonThi = monThiService.getIdByName(tenMon);
                        //Hiển thị chương theo môn
                        showChuongByMonThi(idMonThi);
                        List<CauHoi> rows = cauHoiService.getAllCauHoiByIdMonThi(idMonThi); 
                        if(rows != null) {
                            tableModelCauHoi.setRowCount(0);
                            JTable tableCauHoi = form.getTableMonThi();
                            for(CauHoi cauHoi : rows) {
                                Object[] row = {cauHoi.getIdCauHoi(), cauHoi.getCauHoi(), cauHoi.getDapAnA(), cauHoi.getDapAnB(), cauHoi.getDapAnC(),
                                        cauHoi.getDapAnD(), cauHoi.getDapAnDung(), cauHoi.getTenMonThi(), cauHoi.getTenMucDo(), cauHoi.getTenChuong()};
                                tableModelCauHoi.addRow(row);
                            }
                            tableCauHoi.setModel(tableModelCauHoi);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    } 
    
    //Hiển thị danh sách câu hỏi theo mức độ
    private void showCauHoiByMucDo() {
        form.getComboBoxMucDo().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(enableComboBoxEvent && e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        String tenMon = (String)form.getComboBoxMonThi().getSelectedItem();
                        String idMonThi = monThiService.getIdByName(tenMon);
                        String idMucDo = mucDoService.getIdByName((String)form.getComboBoxMucDo().getSelectedItem());
                        List<CauHoi> rows = cauHoiService.getAllCauHoiIdMonThiAndIdMucDo(idMonThi, idMucDo);
                        if(rows != null) {
                            tableModelCauHoi.setRowCount(0);
                            JTable tableCauHoi = form.getTableMonThi();
                            for(CauHoi cauHoi : rows) {
                                Object[] row = {cauHoi.getIdCauHoi(), cauHoi.getCauHoi(), cauHoi.getDapAnA(), cauHoi.getDapAnB(), cauHoi.getDapAnC(),
                                        cauHoi.getDapAnD(), cauHoi.getDapAnDung(), cauHoi.getTenMonThi(), cauHoi.getTenMucDo(), cauHoi.getTenChuong()};
                                tableModelCauHoi.addRow(row);
                            }
                            tableCauHoi.setModel(tableModelCauHoi);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    
    //Hiển thị danh sách câu hỏi theo chương
    private void showCauHoiByChuong() {
        form.getComboBoxChuong().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(enableComboBoxEvent && e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        String tenMon = (String)form.getComboBoxMonThi().getSelectedItem();
                        String idMonThi = monThiService.getIdByName(tenMon);
                        String tenChuong = (String)form.getComboBoxChuong().getSelectedItem();
                        String idChuong = chuongService.getIdByName(tenChuong, idMonThi);
                        List<CauHoi> rows = cauHoiService.getAllCauHoiByIdMonThiAndIdChuong(idMonThi, idChuong);
                        if(rows != null) {
                            tableModelCauHoi.setRowCount(0);
                            JTable tableCauHoi = form.getTableMonThi();
                            for(CauHoi cauHoi : rows) {
                                Object[] row = {cauHoi.getIdCauHoi(), cauHoi.getCauHoi(), cauHoi.getDapAnA(), cauHoi.getDapAnB(), cauHoi.getDapAnC(),
                                        cauHoi.getDapAnD(), cauHoi.getDapAnDung(), cauHoi.getTenMonThi(), cauHoi.getTenMucDo(), cauHoi.getTenChuong()};
                                tableModelCauHoi.addRow(row);
                            }
                            tableCauHoi.setModel(tableModelCauHoi);
                        }                     
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    
    private boolean enableComboBoxEvent = true;
    int idCauHoi = 0;
    //Hiển thị dữ các cột vào các components
    private void addListSelectionListener() {
        form.getTableMonThi().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    int selectedRow = form.getTableMonThi().getSelectedRow();
                    if(selectedRow != -1) {
                        enableComboBoxEvent = false;
                        idCauHoi = Integer.parseInt(form.getTableMonThi().getValueAt(selectedRow, 0).toString());
                        form.setTextAreaCauHoi(form.getTableMonThi().getValueAt(selectedRow, 1).toString());
                        form.setTextfieldDaA(form.getTableMonThi().getValueAt(selectedRow, 2).toString());
                        form.setTextfieldDaB(form.getTableMonThi().getValueAt(selectedRow, 3).toString());
                        form.setTextfieldDaC(form.getTableMonThi().getValueAt(selectedRow, 4).toString());
                        form.setTextfieldDaD(form.getTableMonThi().getValueAt(selectedRow, 5).toString());
                        form.setTextfieldDaDung(form.getTableMonThi().getValueAt(selectedRow, 6).toString());
                        form.setComboBoxMonThi(form.getTableMonThi().getValueAt(selectedRow, 7).toString());
                        form.setComboBoxMucDo(form.getTableMonThi().getValueAt(selectedRow, 8).toString());
                        form.setComboBoxChuong(form.getTableMonThi().getValueAt(selectedRow, 9).toString());
                        enableComboBoxEvent = true; 
                    }
                }
            }
        });
    }
    
    //Thêm câu hỏi
    private void addCauHoi() {
        form.getButtonThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cauHoi = form.getTextAreaCauHoi();
                    String dapAnA = form.getTextfieldDaA();
                    String dapAnB = form.getTextfieldDaB();
                    String dapAnC = form.getTextfieldDaC();
                    String dapAnD = form.getTextfieldDaD();
                    String dapAnDung = form.getTextfieldDaDung();
                    String tenMonThi = form.getTextComboBoxMonThi(); 
                    String tenMucDo = form.getTextComboBoxMucDo(); 
                    String tenChuong = form.getTextComboBoxChuong(); 
                    String idMonThi = monThiService.getIdByName(tenMonThi);
                    String idMucDo = mucDoService.getIdByName(tenMucDo);
                    String idChuong = chuongService.getIdByName(tenChuong, idMonThi);
                    if(!(cauHoi.equals("") || dapAnA.equals("") || dapAnB.equals("") || dapAnC.equals("") || dapAnD.equals("") || dapAnDung.equals(""))) {
                            CauHoi cauhoi = new CauHoi(cauHoi, dapAnA, dapAnB, dapAnC, dapAnD, dapAnDung, idMonThi, idMucDo, idChuong);
                            cauHoiService.createCauHoi(cauhoi);
                            refreshDataTable(idMonThi);
                            JOptionPane.showMessageDialog(form, "Thêm thành công!");
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    //Sửa câu hỏi
    private void updateCauHoi() {
        form.getButtonSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cauHoi = form.getTextAreaCauHoi();
                    String dapAnA = form.getTextfieldDaA();
                    String dapAnB = form.getTextfieldDaB();
                    String dapAnC = form.getTextfieldDaC();
                    String dapAnD = form.getTextfieldDaD();
                    String dapAnDung = form.getTextfieldDaDung();
                    String tenMonThi = form.getTextComboBoxMonThi();
                    String tenMucDo = form.getTextComboBoxMucDo();
                    String tenChuong = form.getTextComboBoxChuong();
                    String idMonThi = monThiService.getIdByName(tenMonThi);
                    String idMucDo = mucDoService.getIdByName(tenMucDo);
                    String idChuong = chuongService.getIdByName(tenChuong, idMonThi);
                     if(!(cauHoi.equals("") || dapAnA.equals("") || dapAnB.equals("") || dapAnC.equals("") || dapAnD.equals("") || dapAnDung.equals(""))) {
                        CauHoi cauhoi = new CauHoi();
                        cauhoi.setCauHoi(cauHoi);
                        cauhoi.setDapAnA(dapAnA);
                        cauhoi.setDapAnB(dapAnB);
                        cauhoi.setDapAnC(dapAnC);
                        cauhoi.setDapAnD(dapAnD);
                        cauhoi.setDapAnDung(dapAnDung);
                        cauhoi.setIdMonThi(idMonThi);
                        cauhoi.setIdMucDo(idMucDo);
                        cauhoi.setIdChuong(idChuong);
                        if(cauHoiService.updateCauHoi(idCauHoi, cauhoi) != null) {
                            refreshDataTable(idMonThi);
                            JOptionPane.showMessageDialog(form, "Sửa thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Lỗi không thể sửa câu hỏi!");
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
    
    private void searchCauHoi() {
        form.getButtonTimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cauhoi = form.getTextAreaCauHoi();
                    if(!(cauhoi.equals(""))) {
                        List<CauHoi> rows = cauHoiService.getAllCauHoiByKeyWord(cauhoi);
                        if(rows != null) {
                            tableModelCauHoi.setRowCount(0);
                            JTable tableCauHoi = form.getTableMonThi();
                            for(CauHoi cauHoi : rows) {
                                Object[] row = {cauHoi.getIdCauHoi(), cauHoi.getCauHoi(), cauHoi.getDapAnA(), cauHoi.getDapAnB(), cauHoi.getDapAnC(),
                                    cauHoi.getDapAnD(), cauHoi.getDapAnDung(), cauHoi.getTenMonThi(), cauHoi.getTenMucDo(), cauHoi.getTenChuong()};
                                tableModelCauHoi.addRow(row);
                            }
                            tableCauHoi.setModel(tableModelCauHoi);
                        }            
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập câu hỏi!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void deleteCauHoi() {
        form.getButtonXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tenMonThi = (String)form.getComboBoxMonThi().getSelectedItem();
                    String idMonThi = monThiService.getIdByName(tenMonThi);
                    int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá câu hỏi", JOptionPane.YES_NO_OPTION);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                        if(cauHoiService.deleteCauHoi(idCauHoi)) {
                            refreshDataTable(idMonThi);
                            JOptionPane.showMessageDialog(form, "Xóa thành công");
                        } else {
                            JOptionPane.showMessageDialog(form, "Không thể xóa câu hỏi", "Error", JOptionPane.INFORMATION_MESSAGE);
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
            List<CauHoi> dsCauHoi = cauHoiService.getAllCauHoiByIdMonThi(idMonThi);
            tableModelCauHoi.setRowCount(0);
            for (CauHoi cauHoi : dsCauHoi) {
                Object[] row = {cauHoi.getIdCauHoi(), cauHoi.getCauHoi(), cauHoi.getDapAnA(), cauHoi.getDapAnB(), cauHoi.getDapAnC(),
                        cauHoi.getDapAnD(), cauHoi.getDapAnDung(), cauHoi.getTenMonThi(), cauHoi.getTenMucDo(), cauHoi.getTenChuong()};
                tableModelCauHoi.addRow(row);
            }
            form.getTableMonThi().setModel(tableModelCauHoi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void exportExcel() {
        form.getButtonExport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutputStream excelFOU = null;
                BufferedOutputStream excelBOU = null;
                XSSFWorkbook excelJTableExporter = null;
                
                //Hộp thoại sẽ được mở tại thư mục ThiTracNghiem
                JFileChooser excelFile = new JFileChooser("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem");
                excelFile.setDialogTitle("Save As");
                //chỉ cho phép hộp thoại hiển thị các tệp excel có phần mở rộng .xls, .xlsx, .xlxs
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel files", "xls", "xlsx", "xlxs");
                excelFile.setFileFilter(fnef);
                int excelChooser = excelFile.showSaveDialog(null);
                
                if(excelChooser == JFileChooser.APPROVE_OPTION) {
                    try {
                        //tạo ra đối tượng XSSFWorkbook đại diện cho 1 file excel
                        excelJTableExporter = new XSSFWorkbook();
                        // tạo 1 sheet trong workbook
                        XSSFSheet excelSheet = excelJTableExporter.createSheet(form.getComboBoxMonThi().getSelectedItem().toString());
                        //Tạo dòng tiêu đề
                        //format cho dòng tiêu đề
                        CellStyle cellStyle = excelSheet.getWorkbook().createCellStyle();
                        XSSFFont font = excelSheet.getWorkbook().createFont();
                        font.setBold(true);
                        font.setFontHeightInPoints((short) 14);
                        font.setColor(IndexedColors.RED.getIndex());
                        cellStyle.setFont(font);
                        
                        XSSFRow headerRow = excelSheet.createRow(0);
                        for(int j = 0;  j < tableModelCauHoi.getColumnCount(); j++) {
                            XSSFCell headerCell = headerRow.createCell(j);
                            headerCell.setCellValue(tableModelCauHoi.getColumnName(j));
                            headerCell.setCellStyle(cellStyle);
                        }
                        //lặp qua các hàng và cột của tableModelDiem để tạo ra các hàng và ô trong excel
                        for(int i = 0; i < form.getTableMonThi().getRowCount(); i++) {
                            XSSFRow excelRow = excelSheet.createRow(i + 1);
                            for(int j = 0; j < form.getTableMonThi().getColumnCount(); j++) {
                                XSSFCell excelCell = excelRow.createCell(j);
                                //gán dữ liệu từ các cột trong JTable vào các cell
                                excelCell.setCellValue(form.getTableMonThi().getValueAt(i, j).toString());
                            }
                        }
                        excelFOU = new FileOutputStream(excelFile.getSelectedFile() + ".xlsx");
                        excelBOU = new BufferedOutputStream(excelFOU);
                        excelJTableExporter.write(excelBOU);
                        JOptionPane.showMessageDialog(form, "Export data thành công!");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            if (excelBOU != null) {
                                excelBOU.close();
                            }
                            if (excelFOU != null) {
                                excelFOU.close();
                            }
                            if (excelJTableExporter != null) {
                                excelJTableExporter.close();
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }           
        });
    }
    
    private void importExcel() {
        form.getButtonImport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileInputStream excelFIS = null;
                BufferedInputStream excelBIS = null;
                XSSFWorkbook excelImport = null;
                
                JFileChooser excelFileChooser = new JFileChooser("C:\\Javaa\\NetBeansProjects\\ThiTracNghiem");
                excelFileChooser.setDialogTitle("Select Excel File");
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel files", "xls", "xlsx", "xlxs");
                excelFileChooser.setFileFilter(fnef);
                int excelChooser = excelFileChooser.showOpenDialog(null);
                
                if(excelChooser == JFileChooser.APPROVE_OPTION) {
                    try {
                        excelFIS = new FileInputStream(excelFileChooser.getSelectedFile());
                        excelBIS = new BufferedInputStream(excelFIS);
                        excelImport = new XSSFWorkbook(excelBIS);
                        XSSFSheet excelSheet = excelImport.getSheetAt(0);
                        
                        XSSFCell[] excelCells = new XSSFCell[9];
                        for(int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                            XSSFRow excelRow = excelSheet.getRow(row);
                            //lấy ra dữ liệu các ô tại từng hàng
                            for(int col = 0; col < 9; col++) {
                                excelCells[col] = excelRow.getCell(col + 1);
                            }
                            
                            try {
                                String idMonThi = monThiService.getIdByName(excelCells[6].toString());
                                String idMucDo = mucDoService.getIdByName(excelCells[7].toString());
                                String idChuong = chuongService.getIdByName(excelCells[8].toString(), idMonThi);
                                CauHoi cauhoi = new CauHoi(excelCells[0].toString(), excelCells[1].toString(), excelCells[2].toString(), excelCells[3].toString(), excelCells[4].toString(),
                                                    excelCells[5].toString(), idMonThi, idMucDo, idChuong);
                                cauHoiService.createCauHoi(cauhoi);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                            JOptionPane.showMessageDialog(form, "Nhập dữ liệu thành công");
                            refreshDataTable(monThiService.getIdByName(form.getTextComboBoxMonThi()));
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            if (excelFIS != null) {
                                excelFIS.close();
                            }
                            if (excelBIS != null) {
                                excelBIS.close();
                            }
                            if (excelImport != null) {
                                excelImport.close();
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } 
                    }
                }
            }           
        });
    }
}
