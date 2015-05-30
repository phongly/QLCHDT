/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gui;

import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.dao.impl.CuaHangDAOImpl;
import org.dao.impl.HeThongDAOImpl;
import org.dao.impl.SanPhamToDisplayDAOImpl;
import org.dao.impl.ThongTinCaoCapDAOImpl;
import org.dao.util.ComboItem;
import org.dao.util.SanPhamDisplayTableModel;
import org.dao.util.SanPhamTrongHoaDonTableModel;
import org.pojo.*;
import org.pojo.HethongCuaHangNhaCC;

/**
 *
 * @author Phong
 */
public class FrameBuyProduct extends javax.swing.JFrame {

    /**
     * Creates new form FramePickProduct
     */
    public FrameBuyProduct() throws SQLException {
        initComponents();
        initComboBoxCuaHang();
        initSelectRowEventListener();
        chooseCuahang();
    }

    public FrameBuyProduct(SanPhamTrongHoaDon sanPhamTrongHD) throws SQLException {
        initComponents();
        initComboBoxCuaHang();
        initSelectRowEventListener();
        chooseCuahang();
        this.sanPhamTrongHD = sanPhamTrongHD;
    }
    
    public FrameBuyProduct(List<SanPhamTrongHoaDon> sanPhamTrongHDs) throws SQLException {
        initComponents();
        initComboBoxCuaHang();
        initSelectRowEventListener();
        chooseCuahang();
        this.sanPhamTrongHDs = sanPhamTrongHDs;
    }

    public FrameBuyProduct(JTable tblSanPhamTHDon, double tongTien, JLabel lbTongTien) throws SQLException {
        initComponents();
        initComboBoxCuaHang();
        initSelectRowEventListener();
//        cuaHangID = cuaHangID;
        this.cuaHangID = 5;
        tongTien = tongTien;
        lblTongtien = lbTongTien;
        chooseCuahang();
        tblSanPhamTHD = tblSanPhamTHDon;
        txtBuyNumber.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    updateText();
                } catch (Exception ev) {
                }
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateText();
            }
            
            public void updateText() {
                soLuogMuaHienTai = Integer.parseInt(txtBuyNumber.getText());
                lblMsg.setText("Only "+ soLuogTon +" left");
                sanPhamTrongHD.setSoLuongMua(Integer.parseInt(txtBuyNumber.getText()));
            }
        });

        spTHDModel.addTableModelListener(new TableModelListener() {
                @Override
                public final void tableChanged(TableModelEvent e) {
                    switch(e.getType()) {
                        case TableModelEvent.INSERT: System.out.println("table insert");
                                                         double tong = updateTongTien();
//                                                      lbTongTien;
//                                                        cuaHangID = 0;
                                                      
                                                        break;
                        case TableModelEvent.UPDATE: System.out.println("table update");
                                                           lbTongTien.setText("table update");
                                                        break;
                        case TableModelEvent.DELETE: System.out.println("table delete");
                                                        updateTongTien();
                                                        break;
                            
                            
                    }
                    
                }
                public  final double updateTongTien() {
                    List<SanPhamTrongHoaDon> SPTHDs = spTHDModel.getAllSPTrongHD();
                    double tongTien = 0;
                    if(SPTHDs.size() > 0)
                        for (SanPhamTrongHoaDon SPTHD : SPTHDs) {
                            tongTien += SPTHD.getThanhTien();
                        }
                    lbTongTien.setText(tongTien+"");
                    return tongTien;
                }
                
            });
        tblSanPhamTHD.setModel(spTHDModel);
    }    
    /**SanPhamTrongHoaDonTableModel spModel
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbCuaHang = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btOK = new javax.swing.JButton();
        txtBuyNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaDetail = new javax.swing.JTextArea();
        btCancel = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        lbTest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Buy Product");

        cbCuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuaHangActionPerformed(evt);
            }
        });

        jLabel2.setText("Store:");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Price Per Unit", "Stock"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        txtBuyNumber.setText("1");
        txtBuyNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtBuyNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuyNumberActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantity:");

        txtAreaDetail.setEditable(false);
        txtAreaDetail.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txtAreaDetail.setColumns(20);
        txtAreaDetail.setRows(5);
        txtAreaDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail"));
        jScrollPane3.setViewportView(txtAreaDetail);

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        lblMsg.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(261, 261, 261))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTest)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMsg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btOK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCancel)))
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(lbTest)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOK)
                    .addComponent(btCancel)
                    .addComponent(lblMsg))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuaHangActionPerformed
        // TODO add your handling code here:
        chooseCuahang();
    }//GEN-LAST:event_cbCuaHangActionPerformed

    private void txtBuyNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuyNumberActionPerformed
        // TODO add your handling code here:
//        evt.getSource().get
//        txtBuyNumber.setText(null);
    }//GEN-LAST:event_txtBuyNumberActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        // TODO add your handling code here:
        try {
            int flag = 0;
            if(soLuogMuaHienTai > soLuogTon) {               
                flag = 1;
            }
            if(sanPhamTrongHDs.size() == 0)
                lblMsg.setText("Please choose a product!");
            else {

                
                List<SanPhamTrongHoaDon> sanPhamTHDs = spTHDModel.getAllSPTrongHD();
                for (SanPhamTrongHoaDon sanPhamTrongHoaDon : sanPhamTHDs) {
                    if(sanPhamTrongHoaDon.getTen().equals(sanPhamTrongHD.getTen()))
                        flag = 2;
                }

                if(flag == 1)
                    lblMsg.setText("Only "+ soLuogTon +" left");
                else if(flag == 2) 
                    lblMsg.setText("You've chosen this product");                
                else {
                    
//                    tongTien += sanPhamTrongHD.getThanhTien();
//                    lblTongtien.setText(tongTien+"");
                    spTHDModel.addSanPhamTHD(sanPhamTrongHD);
                    tblSanPhamTHD.setModel(spTHDModel);
                    //            this.dispose();  
                }

            }            
        } catch (Exception e) {
        }

//        txtBuyNumber.setText(" get from child frame");
    }//GEN-LAST:event_btOKActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        sanPhamTrongHD = null;
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private int soLuogMuaHienTai = 0;
    private int soLuogTon = 0;
    private void initSelectRowEventListener() {
        tblSanPham.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String detail = "";
                    //                txtAreaDetail.setText(tblSanPham.ygetValueAt(tblSanPham.getSelectedRow(), 0).toString());
                    if(tblSanPham.getSelectedRow() != -1) {
                        SanPhamToDisplay sanPham = spModel.getSanPham(tblSanPham.getSelectedRow());
                        ThongTinCaoCapDAOImpl thongTinCCDAO = new ThongTinCaoCapDAOImpl();
                        List<ThongTinCaoCap> thongTinCCs = thongTinCCDAO.getAllThongTinBySanPhamID(sanPham.getSanPhamID());
                        detail = "";
                        for (ThongTinCaoCap thongTinCC : thongTinCCs) {
                            detail += thongTinCC.getTenThongTin() + ": \n";
                            detail += "  - "+thongTinCC.getMoTa() + "\n";
                            
                        }
//                        sanPhamTrongKho = (SanPhamTrongKho) sanPham;
                        txtAreaDetail.setText(detail);
                        soLuogTon = sanPham.getSoLuongTon();

                        soLuogMuaHienTai = Integer.parseInt(txtBuyNumber.getText());
                        soLuogTon = sanPham.getSoLuongTon();
                        if(soLuogMuaHienTai > soLuogTon)
                        {                  
                            lblMsg.setText("Only "+sanPham.getSoLuongTon()+ " units left!");
                        } else {
                            sanPhamTrongHD = new SanPhamTrongHoaDon(sanPham.getTen(), sanPham.getDonGia(), sanPham.getSanPhamID(), 
                                                                    Integer.parseInt(txtBuyNumber.getText()));                            
                            sanPhamTrongHDs.add(sanPhamTrongHD);
                        }
                        lblMsg.setText("change "+ thongTinCCs.size()+"");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(FrameBuyProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
            java.util.logging.Logger.getLogger(FrameBuyProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameBuyProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameBuyProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameBuyProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameBuyProduct().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrameBuyProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void chooseCuahang() {
        try {
            // TODO add your handling code here:
            Object item = cbCuaHang.getSelectedItem();
            cuaHangID = Integer.parseInt(((ComboItem)item).getValue());
            lbTest.setText(cuaHangID+"");
            loadTableSanPham(cuaHangID);

        } catch (SQLException ex) {
            Logger.getLogger(FrameManageProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadTableSanPham(int khoID) throws SQLException {               
        removeAllRows(spModel);
        List<SanPhamToDisplay> sanPhamToDisPlays = new SanPhamToDisplayDAOImpl().getAllSanPhamToDisPlayByCuaHangID(khoID);
        spModel = new SanPhamDisplayTableModel(sanPhamToDisPlays);
        
        tblSanPham.setModel(spModel);
    }
    
    private void initComboBoxCuaHang() throws SQLException {
        
        List<HethongCuaHangNhaCC> cuaHangs = new CuaHangDAOImpl().getAllCuaHang();
        String maCuaHang;
        for (HethongCuaHangNhaCC cuaHang : cuaHangs) {
            maCuaHang = String.valueOf(cuaHang.getCuaHangID());           
            cbCuaHang.addItem(new ComboItem(cuaHang.getTen(), maCuaHang));
        }
    }
    
    private void removeAllRows(SanPhamDisplayTableModel model) {        
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeSanPham(i);
        }
    }

    public int getCuaHangID() {
        return cuaHangID;
    }
    
    
    private SanPhamDisplayTableModel spModel = new SanPhamDisplayTableModel();
    private SanPhamTrongHoaDonTableModel spTHDModel = new SanPhamTrongHoaDonTableModel();
    public SanPhamTrongHoaDon sanPhamTrongHD = null;
    private List<SanPhamTrongHoaDon> sanPhamTrongHDs = new ArrayList<SanPhamTrongHoaDon>();
    private SanPhamTrongKho sanPhamTrongKho = null;
    private JTable tblSanPhamTHD;
    private int cuaHangID;
    private Double tongTien;
    private JLabel lblTongtien;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JComboBox cbCuaHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbTest;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtAreaDetail;
    public javax.swing.JTextField txtBuyNumber;
    // End of variables declaration//GEN-END:variables
}
