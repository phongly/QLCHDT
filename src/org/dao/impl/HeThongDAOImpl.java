/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.dao.api.HeThongDAO;
import org.dao.util.PostgreConnection;
import org.pojo.HethongCuaHangNhaCC;
import org.pojo.SanPhamTrongKho;

/**
 *
 * @author Chan
 */
public class HeThongDAOImpl implements HeThongDAO{

    private int loai = 1; // he thong loai la 1
        private HethongCuaHangNhaCC convert(ResultSet rs) throws SQLException {
        int cuaHangNhaCCID = rs.getInt("id");
        String ten = rs.getString("ten");
        String diaChi = rs.getString("dia_chi");
        String soDT = rs.getString("so_dt");
        int loaiCuaHang = rs.getInt("loai");
        HethongCuaHangNhaCC heThong = new HethongCuaHangNhaCC(cuaHangNhaCCID, ten, diaChi, soDT, loaiCuaHang);
        return heThong;
    }
        
    @Override
    public HethongCuaHangNhaCC getHeThong() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM cuahang_hethong_nhacc WHERE loai="+this.loai;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        HethongCuaHangNhaCC heThong = convert(rs);
        rs.close();
        statement.close();
        return heThong;
    }

    @Override
    public void deleteHeThong() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertCuaHang(HethongCuaHangNhaCC heThong) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCuaHang(HethongCuaHangNhaCC heThong) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
