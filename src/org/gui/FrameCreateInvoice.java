/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gui;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import org.dao.impl.HoaDonDAOImpl;
import org.dao.impl.NguoiDungDAOImpl;
import org.dao.util.Helper;
import org.dao.util.SanPhamTrongHoaDonTableModel;
import org.pojo.HoaDon;
import org.pojo.NguoiDung;
import org.pojo.SanPhamTrongHoaDon;
import org.pojo.SanPhamTrongKho;
/**
 *
 * @author ly.phong
 */
public class FrameCreateInvoice extends javax.swing.JFrame {

    /**
     * Creates new form ManageReceipt
     */
    private NguoiDung nhanVien;
    private NguoiDung KhachHang;
    public FrameCreateInvoice() throws SQLException, ParseException {
//        tbSanPhamTrongHD = new JTable();         
        initComponents();
        
        int loaiNhanVien = 0;
        int loaiKhachHang = 1;
        nhanVien = getRandomNguoiDungTheo(loaiNhanVien);
        KhachHang = getRandomNguoiDungTheo(loaiKhachHang);       
        lblKhachHang.setText(KhachHang.getTen());
        txtNhanvien.setText(nhanVien.getTen());

        setupDateFields();
        frameBP = new FrameBuyProduct(tbSanPhamTrongHD); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNhanvien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        btBuyMore = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPhamTrongHD = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btDone = new javax.swing.JButton();
        txtNgayNhap = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Invoice");

        jLabel2.setText("Staff");

        txtNhanvien.setEditable(false);
        txtNhanvien.setBackground(new java.awt.Color(0, 153, 153));
        txtNhanvien.setEnabled(false);

        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Customer:");

        lblKhachHang.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(0, 102, 102));
        lblKhachHang.setText("Somebody");

        jLabel6.setText("Buy Products:");

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btBuyMore.setText("Buy More...");
        btBuyMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuyMoreActionPerformed(evt);
            }
        });

        tbSanPhamTrongHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Unit Number", "Price Per Unit", "Final Price"
            }
        ));
        jScrollPane1.setViewportView(tbSanPhamTrongHD);

        jLabel7.setText("Total:");

        lblTotal.setText("0");

        btDone.setText("Done");
        btDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblTotal)
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btDone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuyMore))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblKhachHang))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btDelete)
                    .addComponent(btBuyMore)
                    .addComponent(btDone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuyMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuyMoreActionPerformed

            
            frameBP.setVisible(true);

    }//GEN-LAST:event_btBuyMoreActionPerformed

    private void btDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoneActionPerformed
        try {
            // TODO add your handling code here:
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            DateFormatter df = new DateFormatter(formatter);      
            ngayNhap = (Date)formatter.parse(txtNgayNhap.getText());
            double tongTien = 0;
            HoaDon hoaDon = new HoaDon(ngayNhap, tongTien, cuaHangID, KhachHang.getId(), nhanVien.getId(), 0);
        } catch (ParseException ex) {
            Logger.getLogger(FrameCreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }

//        HoaDon hoaDon = new HoaDon((Date)ftfNgayNhap, WIDTH, HEIGHT, WIDTH, ICONIFIED, WIDTH);
//        hoaDonDAO.insertHoaDon(null);
    }//GEN-LAST:event_btDoneActionPerformed

    private NguoiDung getRandomNguoiDungTheo(int loai) throws SQLException {       
        NguoiDungDAOImpl  nguoiDungDAO = new NguoiDungDAOImpl();
        List<NguoiDung> nguoiDungs = nguoiDungDAO.getNguoiDungTheoLoai(loai);
        
        int ranDomNumber = Helper.randInt(1, nguoiDungs.size());
        NguoiDung ranDomNguoiDung = nguoiDungs.get(ranDomNumber);
        return ranDomNguoiDung;
    } 
    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRowInd = tbSanPhamTrongHD.getSelectedRow();
        spTHDModel = (SanPhamTrongHoaDonTableModel) tbSanPhamTrongHD.getModel();
        spTHDModel.removeSanPhamTHD(selectedRowInd);
        tbSanPhamTrongHD.setModel(spTHDModel);
        
    }//GEN-LAST:event_btDeleteActionPerformed

    private void setupDateFields() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ngayNhap = Calendar.getInstance().getTime();        
        String strDate = formatter.format(ngayNhap);
        txtNgayNhap.setText(strDate);
    }
    private void loadTableSanPhamTrongHD() {
//        DefaultTableModel model = (DefaultTableModel) tbSanPhamTrongHD.getModel();
        removeAllRows(spTHDModel);
//        List<SanPhamToDisplay> sanPhamToDisPlays = new SanPhamToDisplayDAOImpl().getAllSanPhamToDisPlayByCuaHangID(khoID);
        
        spTHDModel = new SanPhamTrongHoaDonTableModel(sanPhamTrongHDs);
        
        tbSanPhamTrongHD.setModel(spTHDModel);
    }
    
    private void removeAllRows(SanPhamTrongHoaDonTableModel model) {  
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeSanPhamTHD(i);
        }
    }
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
            java.util.logging.Logger.getLogger(FrameCreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCreateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameCreateInvoice().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrameCreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(FrameCreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private List<SanPhamTrongKho> sanPhamTrongKhos = new ArrayList<>();
    private List<SanPhamTrongHoaDon> sanPhamTrongHDs = new ArrayList<SanPhamTrongHoaDon>();
    private SanPhamTrongHoaDonTableModel spTHDModel = new SanPhamTrongHoaDonTableModel();
    private FrameBuyProduct frameBP;
    private Date ngayNhap = null;
    private SanPhamTrongHoaDon spTHD = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuyMore;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btDone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tbSanPhamTrongHD;
    private javax.swing.JTextField txtNgayNhap;
    public javax.swing.JTextField txtNhanvien;
    // End of variables declaration//GEN-END:variables
}
