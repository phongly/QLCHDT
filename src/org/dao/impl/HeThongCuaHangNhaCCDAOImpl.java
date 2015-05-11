/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.dao.api.HeThongCuaHangNhaCCDAO;
import org.dao.util.PostgreConnection;
import org.pojo.HethongCuaHangNhaCC;

/**
 *
 * @author ly.phong
 */
public class HeThongCuaHangNhaCCDAOImpl implements HeThongCuaHangNhaCCDAO{

    private HethongCuaHangNhaCC convert(ResultSet rs) throws SQLException {
        int cuaHangNhaCCID = rs.getInt("id");
        String ten = rs.getString("ten");
        String diaChi = rs.getString("dia_chi");
        String soDT = rs.getString("so_dt");
        int loaiCuaHang = rs.getInt("loai");
        HethongCuaHangNhaCC cuaHang = new HethongCuaHangNhaCC(cuaHangNhaCCID, ten, diaChi, soDT, loaiCuaHang);
        return cuaHang;
    }
    @Override
    public List<HethongCuaHangNhaCC> getAllKho() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HethongCuaHangNhaCC getKhoByID(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<HethongCuaHangNhaCC> list = new ArrayList<>();
        String sql = "SELECT * FROM cuahang_hethong_nhacc WHERE id="+id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        HethongCuaHangNhaCC Kho = convert(rs);
        rs.close();
        statement.close();
        return Kho;
    }

    @Override
    public void deleteKho(HethongCuaHangNhaCC Kho) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKho(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertCuaHang(HethongCuaHangNhaCC Kho) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCuaHang(HethongCuaHangNhaCC Kho) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
