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
import org.dao.api.NguoiDungDAO;
import org.dao.util.PostgreConnection;
import org.pojo.HoaDon;
import org.pojo.NguoiDung;
import org.pojo.SanPham;

/**
 *
 * @author ly.phong
 */
public class NguoiDungDAOImpl implements NguoiDungDAO{

    private NguoiDung convert(ResultSet rs) throws SQLException {
        int nguoiDungID = rs.getInt("id");
        String ten = rs.getString("ten");
        String diaChi = rs.getString("dia_chi");
        String soDT = rs.getString("so_dt"); //so_dt mat_khau loai
        String matKhau = rs.getString("mat_khau");
        int loai = rs.getInt("loai");
        NguoiDung nguoiDung = new NguoiDung(nguoiDungID, ten, diaChi, soDT, matKhau, loai);
        return nguoiDung;
    }
       
    @Override
    public List<NguoiDung> getAllNguoiDung() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<NguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM nguoi_dung";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public NguoiDung getNguoiDungByID(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM nguoi_dung WHERE id="+id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        NguoiDung nguoiDung = convert(rs);
        rs.close();
        statement.close();
        return nguoiDung;  
    }

    @Override
    public void deleteNguoiDung(NguoiDung ngDung) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNguoiDung(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertNguoiDung(NguoiDung ngDung) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateNguoiDung(NguoiDung ngDung) throws SQLException {
        String sql = "UPDATE nguoi_dung\n" +
                        "   SET ten=?, dia_chi=?, so_dt=?, mat_khau=?, loai=?\n" +
                        " WHERE id="+ngDung.getId();
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, ngDung.getTen());
        ps.setString(2, ngDung.getDiaChi());
        ps.setString(3, ngDung.getSoDT());
        ps.setString(4, ngDung.getMatKhau());
        ps.setInt(5, ngDung.getLoai());
        ps.executeUpdate();
        
    }

    @Override
    public List<NguoiDung> getNguoiDungTheoLoai(int loai) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<NguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM nguoi_dung WHERE loai="+loai;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }
    
}
