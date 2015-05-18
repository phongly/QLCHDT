/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gui;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.dao.impl.CuaHangDAOImpl;
import org.dao.impl.HeThongDAOImpl;
import org.dao.impl.ThongTinCaoCapDAOImpl;
import org.dao.impl.SanPhamToDisplayDAOImpl;
import org.dao.util.ComboItem;
import org.dao.util.SanPhamDisplayTableModel;
import org.pojo.HethongCuaHangNhaCC;
import org.pojo.*;

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

    public FrameBuyProduct(SanPham sanPham) throws SQLException {
        initComponents();
        initComboBoxCuaHang();
        initSelectRowEventListener();
        chooseCuahang();
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
        cbCuaHang = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btOK = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaDetail = new javax.swing.JTextArea();
        btCancel = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();

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

        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Number to Buy:");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMsg)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancel)))
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(261, 261, 261))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblMsg))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOK)
                    .addComponent(btCancel))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuaHangActionPerformed
        // TODO add your handling code here:
        chooseCuahang();
    }//GEN-LAST:event_cbCuaHangActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        // TODO add your handling code here:
        if(sanPhamTrongKho == null)
            lblMsg.setText("Please choose a product!");
        else
            this.dispose();
    }//GEN-LAST:event_btOKActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        sanPhamTrongKho = null;
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

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
                            detail += thongTinCC.getMoTa() + "\n";
                            
                        }
                        sanPhamTrongKho = sanPham;
                    }
                    txtAreaDetail.setText(detail);
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
            int cuaHangHeThongID = Integer.parseInt(((ComboItem)item).getValue());
            loadTableSanPham(cuaHangHeThongID);
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
    private SanPhamDisplayTableModel spModel = new SanPhamDisplayTableModel();
    public SanPhamTrongKho sanPhamTrongKho = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JComboBox cbCuaHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtAreaDetail;
    // End of variables declaration//GEN-END:variables
}