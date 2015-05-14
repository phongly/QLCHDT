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
import java.util.List;
import org.dao.api.ThongTinCaoCapDAO;
import org.dao.util.PostgreConnection;
import org.pojo.ThongTinCaoCap;

/**
 *
 * @author ly.phong
 */
public class ThongTinCaoCapDAOImpl implements ThongTinCaoCapDAO{

    @Override
    public List<ThongTinCaoCap> getAllThongTin() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ThongTinCaoCap getThongTinByID(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteThongTin(ThongTinCaoCap thongTin) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteThongTin(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertThongTin(ThongTinCaoCap thongTin) throws SQLException {
        String sql = "INSERT INTO thong_tin_cao_cap(ten, mota, sanpham_id) values (?,?,?)";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }
    
}
