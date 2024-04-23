
package Controller;

import Api.CauHoiService;
import Api.DeThiService;
import Entity.CauHoi;
import View.fChiTietDeThi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class ChiTietDeThiController {
    private fChiTietDeThi form;
    private CauHoiService cauHoiService;
    private DefaultTableModel tableModelCauHoi;
    private String idDeThi;
    private String monThi;

    public ChiTietDeThiController(fChiTietDeThi form, String idDeThi, String monThi) {
        this.form = form;
        this.cauHoiService = new CauHoiService();
        this.idDeThi = idDeThi;
        this.monThi = monThi;
        createModelTable();
        showListCauHoi();
        exitFormChiTiet();
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
        tableModelCauHoi.addColumn("TenMucDo");
        tableModelCauHoi.addColumn("TenChuong");
    }
    
    private void showListCauHoi() {
        try {
            form.setTextFieldMaDe(idDeThi);
            form.setTextFieldMonThi(monThi);
            List<CauHoi> listCauHoi = cauHoiService.getAllCauHoiByIdDeThi(idDeThi);
            if(listCauHoi != null) {
                JTable tableCauHoi = form.getTableCauHoi();
                for(CauHoi cauHoi : listCauHoi) {
                    Object[] row = {cauHoi.getIdCauHoi(), cauHoi.getCauHoi(), cauHoi.getDapAnA(), cauHoi.getDapAnB(), cauHoi.getDapAnC(), cauHoi.getDapAnD(),
                                    cauHoi.getDapAnDung(), cauHoi.getTenMucDo(), cauHoi.getTenChuong()};
                    tableModelCauHoi.addRow(row);
                }
                tableCauHoi.setModel(tableModelCauHoi);
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void exitFormChiTiet() {
        form.getButtonBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setVisible(false);
            }
        });
    }
}
