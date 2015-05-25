/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.impl;

import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.dao.api.HoaDonDAO;
import org.dao.util.PostgreConnection;
import org.pojo.HoaDon;
import org.pojo.*;

/**
 *
 * @author ly.phong
 */
public class HoaDonDAOImpl implements HoaDonDAO{

    private HoaDon convert(ResultSet rs) throws SQLException {
        int hoaDonID = rs.getInt("id");
        Date ngayNhap = rs.getDate("ngay_nhap");
        double tongTien = rs.getDouble("tong_tien");
        int cuaHangID = rs.getInt("cuahang_id"); 
        int khachHangID = rs.getInt("khachhang_id");
        int nhanVienID = rs.getInt("nhanvien_id");
        int tinhTrang = rs.getInt("tinhtrang");
        HoaDon hoaDon = new HoaDon(hoaDonID, ngayNhap, tongTien, cuaHangID, khachHangID, nhanVienID, tinhTrang);
        return hoaDon;
    }
        
    @Override
    public List<HoaDon> getAllHoaDon() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM hoadon";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    public void deleteHoaDon(HoaDon hd) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteHoaDon(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertHoaDon(HoaDon hd) throws SQLException {
        String sql = "INSERT INTO hoadon(ngay_nhap, tong_tien, cuahang_id, khachhang_id, nhanvien_id, tinhtrang) values (?,?,?,?,?,?)";
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setDate (1, hd.getNgayNhap());
        ps.setDouble(2, hd.getTongTien());
        ps.setInt(3, hd.getCuaHangID());
        ps.setInt(4, hd.getKhachHangID());
        ps.setInt(5, hd.getNhanVienID());
        ps.setInt(6, hd.getTinhTrang());
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
    public void updateHoaDon(HoaDon hd) throws SQLException {
        String sql = "UPDATE hoadon" +
                    "   SET ngay_nhap=?, tong_tien=?, cuahang_id=?, khachhang_id=?," +
                    "       nhanvien_id=?, tinhtrang=?\n" +
                    " WHERE id"+hd.getId();
        PreparedStatement ps = PostgreConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setDate(1, hd.getNgayNhap());
        ps.setDouble(2, hd.getTongTien());
        ps.setInt(3, hd.getCuaHangID());
        ps.setInt(4, hd.getKhachHangID());
        ps.setInt(5, hd.getNhanVienID());
        ps.setInt(6, hd.getTinhTrang());
        ps.executeUpdate();
    }

    @Override
    public HoaDon getHoaDonByID(int id) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        String sql = "SELECT * FROM hoadon WHERE id="+id;
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        HoaDon hoaDon = convert(rs);
        rs.close();
        statement.close();
        return hoaDon;
    }

    @Override
    public List<HoaDon> getAllHoaDonByCuaHangID(int cuaHangID) throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM hoadon WHERE cuahang_id="+cuaHangID;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }
    
}
