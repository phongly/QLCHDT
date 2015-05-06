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
import org.dao.api.NhaCCDAO;
import org.dao.util.PostgreConnection;
import org.pojo.CuaHangNhaCC;

/**
 *
 * @author ly.phong
 */
public class NhaCCDAOImpl implements NhaCCDAO{
    
    private int loai = 3; // loai nha cung cap la` 3

    private CuaHangNhaCC convert(ResultSet rs) throws SQLException {
        int cuaHangNhaCCID = rs.getInt("id");
        String ten = rs.getString("ten");
        String diaChi = rs.getString("dia_chi");
        String soDT = rs.getString("so_dt");
        
        CuaHangNhaCC nhaCC = new CuaHangNhaCC(cuaHangNhaCCID, ten, diaChi, soDT);
        return nhaCC;
    }
    @Override
    public List<CuaHangNhaCC> getAllNhaCC() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<CuaHangNhaCC> list = new ArrayList<>();
        String sql = "SELECT * FROM cuahang_hethong WHERE loai="+this.loai;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public CuaHangNhaCC getNhaCCByID(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNhaCC(CuaHangNhaCC nhaCC) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNhaCC(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertNhaCC(CuaHangNhaCC nhaCC) throws SQLException {
        String sql = "INSERT INTO cuahang_hethong_nhacc(ten, dia_chi, so_dt, loai) values (?,?,?,?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, nhaCC.getTen());
        ps.setString(2, nhaCC.getDiaChi());
        ps.setString(3 , nhaCC.getSoDT());
        ps.setInt(3 , this.loai);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void updateNhaCC(CuaHangNhaCC nhaCC) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
