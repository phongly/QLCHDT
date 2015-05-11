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
import org.dao.api.SanPhamDAO;
import org.dao.util.PostgreConnection;
import org.pojo.HethongCuaHangNhaCC;
import org.pojo.SanPham;
/**
 *
 * @author ly.phong
 */
public class SanPhamDAOImpl implements SanPhamDAO{

    private SanPham convert(ResultSet rs) throws SQLException {
        int sanPhamID = rs.getInt("id");
        String ten = rs.getString("ten");
        String diaChi = rs.getString("don_gia");
        SanPham sanPham = new SanPham(sanPhamID, ten, sanPhamID);
        return sanPham;
    }
    
    @Override
    public List<SanPham> getAllSanPham() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public SanPham getSanPhamByID(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM sanpham WHERE id="+id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        SanPham sanPham = convert(rs);
        rs.close();
        statement.close();
        return sanPham;       
    }

    @Override
    public SanPham getLastSanPham() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void deleteSanPham(SanPham sp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSanPham(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "DELETE FROM sanpham WHERE id="+id;
        statement.executeUpdate(sql);
    }

    @Override
    public int insertSanPham(SanPham sp) throws SQLException {
        String sql = "INSERT INTO sanpham(ten, don_gia) values (?,?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, sp.getTen());
        ps.setInt(2, sp.getDonGia().intValue());
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
    public void updateSanPham(SanPham sp) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
