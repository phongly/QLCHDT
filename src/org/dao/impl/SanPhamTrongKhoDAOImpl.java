/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.dao.api.SanPhamTrongKhoDAO;
import org.dao.util.PostgreConnection;
import org.pojo.SanPham;
import org.pojo.SanPhamToDisplay;
import org.pojo.SanPhamTrongKho;
/**
 *
 * @author ly.phong
 */
public class SanPhamTrongKhoDAOImpl implements SanPhamTrongKhoDAO{

    private SanPhamTrongKho convert(ResultSet rs) throws SQLException {
        int sanPhamTrongKhoID = rs.getInt("id");
        int sanPhamID = rs.getInt("id_sp");
        int khoID = rs.getInt("kho_id");
        int soLuongTon = rs.getInt("so_luong_ton");
        Date ngayNhap = rs.getDate("ngay_nhap");
        Date ngayXuat = rs.getDate("ngay_xuat");
        SanPhamTrongKho sanPhamTrongKho = new SanPhamTrongKho(sanPhamTrongKhoID, khoID, sanPhamID, soLuongTon, ngayNhap, ngayXuat);
        return sanPhamTrongKho;
    }
    
    @Override
    public List<SanPhamTrongKho> getAllSanPhamTrongKho() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<SanPhamTrongKho> list = new ArrayList<>();
        String sql = "SELECT * FROM sanpham_trong_kho";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;         
    }

    @Override
    public List<SanPhamTrongKho> getAllSanPhamTrongKhoByKhoID(int khoID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SanPhamTrongKho getSanPhamTrongKhoByID(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM sanpham_trong_kho WHERE id="+id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        SanPhamTrongKho sanPhamTrongKho = convert(rs);
        rs.close();
        statement.close();
        return sanPhamTrongKho; 
    }

    @Override
    public void deleteSanPhamTrongKho(SanPhamTrongKho sp) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "DELETE FROM sanpham_trong_kho WHERE id="+sp.getSanPhamTrongKhoID();
        statement.executeUpdate(sql);
    }

    @Override
    public void deleteSanPhamTrongKho(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "DELETE FROM sanpham_trong_kho WHERE id="+id;
        statement.executeUpdate(sql);
    }

    @Override
    public int insertSanPhamTrongKho(SanPhamTrongKho sp) throws SQLException {
        String sql = "INSERT INTO sanpham_trong_kho(id_sp, id_kho, so_luong_ton, ngay_nhap, ngay_xuat, nhacc_id) values (?,?,?,?,?,?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, sp.getSanPhamID());
        ps.setInt(2, sp.getKhoID());
        ps.setInt(3, sp.getSoLuongTon());
        ps.setDate(4, sp.getNgayNhap());
        ps.setDate(5, sp.getNgayXuat());
        ps.setInt(6, sp.getNhaCCID());
        
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
    public void updateSanPhamTrongKho(SanPhamTrongKho sp) throws SQLException {
        String sql = " UPDATE sanpham_trong_kho\n" +
                    "  SET id_sp=?, id_kho=?, so_luong_ton=?, ngay_nhap=?, ngay_xuat=?," +
                    "   nhacc_id=?" +
                    "  WHERE id=?";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setInt(1, sp.getSanPhamID());
        ps.setInt(2, sp.getKhoID());
        ps.setInt(3, sp.getSoLuongTon());
        ps.setDate(4, sp.getNgayNhap());
        ps.setDate(5, sp.getNgayXuat());
        ps.setInt(6, sp.getNhaCCID());
        ps.setInt(7, sp.getSanPhamTrongKhoID());
        ps.executeUpdate();
        
    }


    
}
