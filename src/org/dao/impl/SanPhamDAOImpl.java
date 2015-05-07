/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.dao.api.SanPhamDAO;
import org.dao.util.PostgreConnection;
import org.pojo.SanPham;
/**
 *
 * @author ly.phong
 */
public class SanPhamDAOImpl implements SanPhamDAO{

    @Override
    public List<SanPham> getAllSanPham() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SanPham getSanPhamByID(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSanPham(SanPham sp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSanPham(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertSanPham(SanPham sp) throws SQLException {
        String sql = "INSERT INTO sanpham(ten, don_gia) values (?,?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, sp.getTen());
        ps.setInt(2, sp.getDonGia().intValue());
        ps.executeUpdate();
        ps.close(); 
    }

    @Override
    public void updateSanPham(SanPham sp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
