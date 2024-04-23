/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Api.KhoaService;
import Api.LopService;
import Api.SinhVienService;
import Entity.Khoa;
import Entity.Lop;
import Entity.SinhVien;
import View.fThiSinh;
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
import java.sql.Date;
import java.util.List;
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

public class ThiSinhController {
    private fThiSinh form;
    private SinhVienService sinhVienService;
    private LopService lopSerivce;
    private KhoaService khoaService;
    private DefaultTableModel tableModelThiSinh;

    public ThiSinhController(fThiSinh form) {
        this.form = form;
        this.sinhVienService = new SinhVienService();
        this.lopSerivce = new LopService();
        this.khoaService = new KhoaService();
        createTableModel();
        showComboBoxKhoa();
        comboBox_khoa_SelectedValueChanged();
        comboBox_lop_SelectedValueChanged();
        jTable_ttSv_CellClick();
        addThiSinh();
        updateThiSinh();
        deleteThiSinh();
        searchThiSinh();
        clearTextField();
        exportExcel();
        importExcel();
    }
    
    private void createTableModel() {
        tableModelThiSinh = new DefaultTableModel();
        tableModelThiSinh.addColumn("Mã sinh viên");
        tableModelThiSinh.addColumn("Họ và tên");
        tableModelThiSinh.addColumn("Lớp");
        tableModelThiSinh.addColumn("Khoa");
        tableModelThiSinh.addColumn("Ngày sinh");
        tableModelThiSinh.addColumn("Giới tính");
        tableModelThiSinh.addColumn("Số điện thoại");
        tableModelThiSinh.addColumn("Quê quán");
    }
    
    private void showComboBoxKhoa() {
        try {
            List<Khoa> listKhoa = khoaService.getAllKhoa();
            JComboBox comboBoxKhoa = form.getComboBoxKhoa();
            if(listKhoa != null) {
                for(Khoa khoa: listKhoa) {
                    comboBoxKhoa.addItem(khoa.getTenKhoa());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     }
    
    //sự kiện khi giá trị trong comboxBox thay đổi
    private void comboBox_khoa_SelectedValueChanged() {
        form.getComboBoxKhoa().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        String tenKhoa = (String)form.getComboBoxKhoa().getSelectedItem();
                        String idKhoa = khoaService.getIdByName(tenKhoa);
                        List<Lop> dsLop = lopSerivce.getAllLopByIdKhoa(idKhoa);
                        if(dsLop != null) {
                            int index = 0;
                            for(int i = form.getComboBoxLop().getItemCount() - 1; i > index; i--) {
                                form.getComboBoxLop().removeItemAt(i);
                            }
                            for(Lop lop : dsLop) {
                                form.getComboBoxLop().addItem(lop.getTenLop());
                            }
                        }

                        List<SinhVien> dsSinhVien = sinhVienService.getAllSinhVienByIdKhoa(idKhoa);
                        if(dsSinhVien != null) {
                            tableModelThiSinh.setRowCount(0);
                            JTable tableThiSinh = form.getTableThiSinh();
                            String gioiTinh = "";
                            for(SinhVien sinhVien : dsSinhVien) {
                                if(sinhVien.getGioiTinh()) {
                                    gioiTinh = "Nam";
                                } else {
                                    gioiTinh = "Nữ"; 
                                }
                                Object[] row = {sinhVien.getIdSinhVien(), sinhVien.getTenSinhVien(), sinhVien.getTenLop(), sinhVien.getTenKhoa(), 
                                    sinhVien.getNgaySinh(), gioiTinh, sinhVien.getSdt(), sinhVien.getDiaChi()};
                                                
                                tableModelThiSinh.addRow(row);
                            }
                            tableThiSinh.setModel(tableModelThiSinh);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    
    private void comboBox_lop_SelectedValueChanged() {
        form.getComboBoxLop().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        String tenLop = (String)form.getComboBoxLop().getSelectedItem();
                        String idLop = lopSerivce.getIdByName(tenLop);
                        List<SinhVien> dsSinhVien = sinhVienService.getAllSinhVienByIdLop(idLop);
                        if(dsSinhVien != null) {
                            tableModelThiSinh.setRowCount(0);
                            JTable tableThiSinh = form.getTableThiSinh();
                            String gioiTinh = "";
                            for(SinhVien sinhVien : dsSinhVien) {
                                if(sinhVien.getGioiTinh()) {
                                    gioiTinh = "Nam";
                                } else {
                                    gioiTinh = "Nữ"; 
                                }
                                Object[] row = {sinhVien.getIdSinhVien(), sinhVien.getTenSinhVien(), sinhVien.getTenLop(), sinhVien.getTenKhoa(), 
                                    sinhVien.getNgaySinh(), gioiTinh, sinhVien.getSdt(), sinhVien.getDiaChi()};

                                tableModelThiSinh.addRow(row);
                            }
                            tableThiSinh.setModel(tableModelThiSinh);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    
    private void jTable_ttSv_CellClick() {
        form.getTableThiSinh().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!(e.getValueIsAdjusting())) {
                    int selectedRow = form.getTableThiSinh().getSelectedRow();
                    if(selectedRow != -1) {
                        String idSinhVien = form.getTableThiSinh().getValueAt(selectedRow, 0).toString();
                        form.setTextFieldMaSV(idSinhVien);
                        form.setTextFieldTenSV(form.getTableThiSinh().getValueAt(selectedRow, 1).toString());
                        form.setComboBoxLop(form.getTableThiSinh().getValueAt(selectedRow, 2).toString());
                        form.setValueJDateChoose(Date.valueOf(form.getTableThiSinh().getValueAt(selectedRow, 4).toString()));
                        form.setTextFieldSDT(form.getTableThiSinh().getValueAt(selectedRow, 6).toString());
                        form.setTextFieldQQ(form.getTableThiSinh().getValueAt(selectedRow, 7).toString());
                        String gioiTinh = form.getTableThiSinh().getValueAt(selectedRow, 5).toString();
                        if(gioiTinh.equals("Nam")) {
                            form.setRadioButtonNam(true);
                        } else {
                            form.setRadioButtonNu(true);
                        }
                        form.setStudentImage(null);
                        try {
                            byte[] imageData = null;
                            List<SinhVien> listSinhVien = sinhVienService.getAllSinhVienByKeyword(idSinhVien);
                            for(SinhVien sinhvien : listSinhVien) {
                                 imageData = sinhvien.getAnhSinhVien();
                            }
                            if(!(imageData == null)) {
                                form.setStudentImage(imageData);
                            } else {
                                JOptionPane.showMessageDialog(form, "Sinh viên chưa cập nhật ảnh thẻ!");
                            } 
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
    }
    
    private void addThiSinh() {
        form.getButtonThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idSinhVien = form.getTextFieldMaSV();
                    String tenSinhVien = form.getTextFieldTenSV();
                    String tenLop = (String)form.getComboBoxLop().getSelectedItem();
                    String idLop = lopSerivce.getIdByName(tenLop);
                    String tenKhoa = (String)form.getComboBoxKhoa().getSelectedItem();
                    String idKhoa = khoaService.getIdByName(tenKhoa);
                    Date ngaySinh = form.getValueJDateChooser();
                    boolean gioiTinh;
                    if(form.getRadioButtonNamSelected()) {
                        gioiTinh = true;
                    } else {
                        gioiTinh = false;
                    }
                    String diaChi = form.getTextFieldQQ();
                    String sdt = form.getTextFieldSDT();
                    SinhVien sinhVien = new SinhVien(idSinhVien, tenSinhVien, idLop, idKhoa, ngaySinh, gioiTinh, diaChi, sdt);
                    if(!(idSinhVien.equals("") || tenSinhVien.equals("") || diaChi.equals("") || sdt.equals(""))) {
                         if(sinhVienService.createSinhVien(sinhVien) != null) {
                             refreshDataTable(idLop);
                            JOptionPane.showMessageDialog(form, "Thêm thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Mã sinh viên đã tồn tại!");
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
    
    private void updateThiSinh() {
        form.getButtonSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idSinhVien = form.getTextFieldMaSV();
                    String tenSinhVien = form.getTextFieldTenSV();
                    String tenLop = (String)form.getComboBoxLop().getSelectedItem();
                    String idLop = lopSerivce.getIdByName(tenLop);
                    String tenKhoa = (String)form.getComboBoxKhoa().getSelectedItem();
                    String idKhoa =khoaService.getIdByName(tenKhoa);
                    Date ngaySinh = form.getValueJDateChooser();
                    boolean gioiTinh;
                    if(form.getRadioButtonNamSelected()) {
                        gioiTinh = true;
                    } else {
                        gioiTinh = false;
                    }
                    String diaChi = form.getTextFieldQQ();
                    String sdt = form.getTextFieldSDT();
                    SinhVien sinhVien = new SinhVien(idSinhVien, tenSinhVien, idLop, idKhoa, ngaySinh, gioiTinh, diaChi, sdt);
                    if(!(idSinhVien.equals("") || tenSinhVien.equals("") || diaChi.equals("") || sdt.equals(""))) {
                         if(sinhVienService.updateSinhVien(idSinhVien, sinhVien) != null) {
                             refreshDataTable(idLop);
                            JOptionPane.showMessageDialog(form, "Sửa thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Lỗi không thể sửa!");
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
    
    private void deleteThiSinh() {
        form.getButtonXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idSinhVien = form.getTextFieldMaSV();
                    String idLop = lopSerivce.getIdByName((String)form.getComboBoxLop().getSelectedItem());
                    int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá thí sinh", JOptionPane.YES_NO_OPTION);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                        if(sinhVienService.deleteSinhVien(idSinhVien)) {
                            refreshDataTable(idLop);
                            JOptionPane.showMessageDialog(form, "Xóa thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Không thể xóa sinh viên!", "Error", JOptionPane.INFORMATION_MESSAGE);
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
    
    private void searchThiSinh() {
        form.getButtonTimKiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String keyword = form.getTextFieldSearch();
                 if(!(keyword.equals(""))) {
                    try {
                        List<SinhVien> dsSinhVien = sinhVienService.getAllSinhVienByKeyword(keyword);
                        if(dsSinhVien != null) {
                                tableModelThiSinh.setRowCount(0);
                                JTable tableThiSinh = form.getTableThiSinh();
                                String gioiTinh = "";
                                for(SinhVien sinhVien : dsSinhVien) {
                                    if(sinhVien.getGioiTinh()) {
                                        gioiTinh = "Nam";
                                    } else {
                                        gioiTinh = "Nữ"; 
                                    }
                                    Object[] row = {sinhVien.getIdSinhVien(), sinhVien.getTenSinhVien(), sinhVien.getTenLop(), sinhVien.getTenKhoa(), 
                                        sinhVien.getNgaySinh(), gioiTinh, sinhVien.getSdt(), sinhVien.getDiaChi()};

                                    tableModelThiSinh.addRow(row);
                                }
                                tableThiSinh.setModel(tableModelThiSinh);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                 } else {
                     JOptionPane.showMessageDialog(form, "Vui lòng nhập thông tin cần tìm kiếm!");
                 }
            }
        });
    }
    
    private void clearTextField() {
        form.getButtonRefresh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setTextFieldMaSV("");
                form.setTextFieldTenSV("");
                form.setTextFieldSDT("");
                form.setTextFieldQQ("");
                if(form.getRadioButtonGroupSex().getSelection() != null) {
                       form.getRadioButtonGroupSex().clearSelection();
                }
                form.setStudentImage(null);
            }
        });
    }
    
    private void refreshDataTable(String idLop) {
        try {
         List<SinhVien> dsSinhVien = sinhVienService.getAllSinhVienByIdLop(idLop);
            tableModelThiSinh.setRowCount(0);
            String gioiTinh = "";
            for (SinhVien sinhVien : dsSinhVien) {
                if(sinhVien.getGioiTinh()) {
                    gioiTinh = "Nam";
                } else {
                    gioiTinh = "Nữ"; 
                }
                Object[] row = {sinhVien.getIdSinhVien(), sinhVien.getTenSinhVien(), sinhVien.getTenLop(), sinhVien.getTenKhoa(), 
                                       sinhVien.getNgaySinh(), gioiTinh, sinhVien.getSdt(), sinhVien.getDiaChi()};
                tableModelThiSinh.addRow(row);
            }
            form.getTableThiSinh().setModel(tableModelThiSinh);
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
                        XSSFSheet excelSheet = excelJTableExporter.createSheet(form.getComboBoxLop().getSelectedItem().toString());
                        //Tạo dòng tiêu đề
                        //format cho dòng tiêu đề
                        CellStyle cellStyle = excelSheet.getWorkbook().createCellStyle();
                        XSSFFont font = excelSheet.getWorkbook().createFont();
                        font.setBold(true);
                        font.setFontHeightInPoints((short) 14);
                        font.setColor(IndexedColors.RED.getIndex());
                        cellStyle.setFont(font);
                        
                        XSSFRow headerRow = excelSheet.createRow(0);
                        for(int j = 0;  j < tableModelThiSinh.getColumnCount(); j++) {
                            XSSFCell headerCell = headerRow.createCell(j);
                            headerCell.setCellValue(tableModelThiSinh.getColumnName(j));
                            headerCell.setCellStyle(cellStyle);
                        } 
                        //lặp qua các hàng và cột của tableModelDiem để tạo ra các hàng và ô trong excel
                        for(int i = 0; i < form.getTableThiSinh().getRowCount(); i++) {
                            XSSFRow excelRow = excelSheet.createRow(i + 1);
                            for(int j = 0; j < form.getTableThiSinh().getColumnCount(); j++) {
                                XSSFCell excelCell = excelRow.createCell(j);
                                //gán dữ liệu từ các cột trong JTable vào các cell
                                excelCell.setCellValue(form.getTableThiSinh().getValueAt(i, j).toString());
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
                        
                        XSSFCell[] excelCells = new XSSFCell[8];
                        for(int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                            XSSFRow excelRow = excelSheet.getRow(row);
                            //lấy ra dữ liệu các ô tại từng hàng
                            for(int col = 0; col < 8; col++) {
                                excelCells[col] = excelRow.getCell(col);
                            }
                            
                            try {
                                String idLop = lopSerivce.getIdByName(excelCells[2].toString());
                                String idKhoa = khoaService.getIdByName(excelCells[3].toString());
                                boolean gioiTinh = false;
                                if(excelCells[5].toString().equals("Nam")) {
                                    gioiTinh = true;
                                } else {
                                    gioiTinh = false;
                                }
                                SinhVien sinhvien = new SinhVien(excelCells[0].toString(), excelCells[1].toString(), idLop, idKhoa, Date.valueOf(excelCells[4].toString()),
                                                                gioiTinh, excelCells[7].toString(), excelCells[6].toString());
                                sinhVienService.createSinhVien(sinhvien);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                            JOptionPane.showMessageDialog(form, "Nhập dữ liệu thành công");
                            refreshDataTable(lopSerivce.getIdByName(form.getComboBoxLop().getSelectedItem().toString()));
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
