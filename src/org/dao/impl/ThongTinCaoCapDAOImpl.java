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
import org.dao.api.ThongTinCaoCapDAO;
import org.dao.util.PostgreConnection;
import org.pojo.SanPham;
import org.pojo.ThongTinCaoCap;

/**
 *
 * @author ly.phong
 */
public class ThongTinCaoCapDAOImpl implements ThongTinCaoCapDAO{

    private ThongTinCaoCap convert(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int sanPhamID = rs.getInt("sanpham_id");
        String tenThongTin = rs.getString("ten");
        String moTa = rs.getString("mota");
        return new ThongTinCaoCap(id, tenThongTin, moTa, sanPhamID);
    }
    
    @Override
    public List<ThongTinCaoCap> getAllThongTin() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<ThongTinCaoCap> list = new ArrayList<>();
        String sql = "SELECT * FROM thong_tin_sp_cao_cap";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public ThongTinCaoCap getThongTinByID(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM FROM thong_tin_sp_cao_cap WHERE id="+id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        ThongTinCaoCap thongTinCC = convert(rs);
        rs.close();
        statement.close();
        return thongTinCC; 
    }

    @Override
    public List<ThongTinCaoCap> getAllThongTinBySanPhamID(int sanPhamID) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<ThongTinCaoCap> list = new ArrayList<>();
        String sql = "SELECT * FROM thong_tin_sp_cao_cap WHERE sanpham_id="+sanPhamID;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }
    
    @Override
    public void deleteThongTin(ThongTinCaoCap thongTin) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "DELETE FROM  thong_tin_sp_cao_cap WHERE id="+thongTin.getId();
        statement.executeUpdate(sql);
    }

    @Override
    public void deleteThongTin(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "DELETE FROM  FROM thong_tin_sp_cao_cap WHERE id="+id;
        statement.executeUpdate(sql);
    }

    @Override
    public int insertThongTin(ThongTinCaoCap thongTin) throws SQLException {
        String sql = "INSERT INTO thong_tin_sp_cao_cap(ten, mota, sanpham_id) values (?,?,?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, thongTin.getTenThongTin());
        ps.setString(2, thongTin.getMoTa());
        ps.setInt(3, thongTin.getSanPhamID());
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
    public void updateThongTin(ThongTinCaoCap thongTin) throws SQLException {
        String sql = " UPDATE thong_tin_sp_cao_cap " +
                     " SET ten=?, mota=? " +
                     " WHERE id=?";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, thongTin.getTenThongTin());
        ps.setString(2, thongTin.getMoTa());
        ps.setInt(3, thongTin.getId());
        ps.executeUpdate();        
    }
   
}
