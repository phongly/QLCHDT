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
import org.dao.api.CuaHangDAO;
import org.dao.util.PostgreConnection;
import org.pojo.HethongCuaHangNhaCC;
/**
 *
 * @author ly.phong
 */
public class CuaHangDAOImpl implements CuaHangDAO{

    private int loai = 2; // loai cua hang la` 2 
    private HethongCuaHangNhaCC convert(ResultSet rs) throws SQLException {
        int cuaHangNhaCCID = rs.getInt("id");
        String ten = rs.getString("ten");
        String diaChi = rs.getString("dia_chi");
        String soDT = rs.getString("so_dt");
        String loaiCuaHang = rs.getString("loai");
        HethongCuaHangNhaCC cuaHang = new HethongCuaHangNhaCC(cuaHangNhaCCID, ten, diaChi, soDT, loaiCuaHang);
        return cuaHang;
    }
    
    @Override
    public List<HethongCuaHangNhaCC> getAllCuaHang() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<HethongCuaHangNhaCC> list = new ArrayList<>();
        String sql = "SELECT * FROM cuahang_hethong_nhacc WHERE loai="+this.loai;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public HethongCuaHangNhaCC getCuaHangByID(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCuaHang(HethongCuaHangNhaCC cuaHang) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCuaHang(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertCuaHang(HethongCuaHangNhaCC cuaHang) throws SQLException {
        String sql = "INSERT INTO cuahang_hethong_nhacc(ten, dia_chi, so_dt, loai) values (?,?,?,?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, cuaHang.getTen());
        ps.setString(2, cuaHang.getDiaChi());
        ps.setString(3 , cuaHang.getSoDT());
                ps.setInt(3 , this.loai);
        ps.executeUpdate();
        ps.close(); 
    }

    @Override
    public void updateCuaHang(HethongCuaHangNhaCC cuaHang) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
