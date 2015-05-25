/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.dao.api.SanPhamTrongHoaDonDAO;
import org.dao.util.PostgreConnection;
import org.pojo.SanPham;
import org.pojo.SanPhamTrongHoaDon;

/**
 *
 * @author ly.phong
 */
public class SanPhamTrongHoaDonDAOImpl implements SanPhamTrongHoaDonDAO{

    private SanPhamTrongHoaDon convert(ResultSet rs) throws SQLException {
        
        int ID = rs.getInt("id");
        int hoaDonID = rs.getInt("hoadon_id");
        int sanPhamID = rs.getInt("sanpham_id");
        int soLuong = rs.getInt("so_luong_mua");

        SanPhamTrongHoaDon sanPham = new SanPhamTrongHoaDon(ID, hoaDonID, sanPhamID, soLuong);
        return sanPham;
    }
    @Override
    public List<SanPhamTrongHoaDon> getAllSanPhamTrongHoaDon() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<SanPhamTrongHoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham_trong_hoadon";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public SanPhamTrongHoaDon getSanPhamTrongHoaDonByID(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM sanpham_trong_hoadon WHERE id="+id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        SanPhamTrongHoaDon sanPham = convert(rs);
        rs.close();
        statement.close();
        return sanPham;  
    }

    @Override
    public void deleteSanPhamTrongHoaDon(SanPhamTrongHoaDon sp) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "DELETE FROM sanpham_trong_hoadon WHERE id="+sp.getId();
        statement.executeUpdate(sql);
    }

    @Override
    public void deleteSanPhamTrongHoaDon(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "DELETE FROM sanpham_trong_hoadon WHERE id="+id;
        statement.executeUpdate(sql);
    }

    @Override
    public int insertSanPhamTrongHoaDon(SanPhamTrongHoaDon sp) throws SQLException {
        String sql = "INSERT INTO sanpham_trong_hoadon( hoadon_id, sanpham_id, so_luong_mua) VALUES (?, ?, ?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, sp.getHoaDonID());
        ps.setInt(2, sp.getSanPhamID());
        ps.setInt(3, sp.getSoLuongMua());
        int result = 0;

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        while (rs.next()) {
            result = rs.getInt(1);
        }
        ps.close();
        return result;
    }

    @Override
    public void updateSanPhamTrongHoaDon(SanPhamTrongHoaDon sp) throws SQLException {
        String sql = " UPDATE sanpham_trong_hoadon " +
                     " SET hoadon_id=?, sanpham_id=?, so_luong_mua=? " +
                     " WHERE id=?";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, sp.getHoaDonID());
        ps.setInt(2, sp.getSanPhamID());
        ps.setInt(3, sp.getSoLuongMua());
        ps.executeUpdate();
    }

    @Override
    public void insertMultiSanPhamTrongHoaDon(List<SanPhamTrongHoaDon> SPs) throws SQLException {
        for (SanPhamTrongHoaDon sanPhamTrongHoaDon : SPs) {
            insertSanPhamTrongHoaDon(sanPhamTrongHoaDon);
        }
    }
    
}
