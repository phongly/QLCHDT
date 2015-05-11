/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.api;

import java.sql.SQLException;
import java.util.List;
import org.pojo.HethongCuaHangNhaCC;

/**
 *
 * @author ly.phong
 */
public interface HeThongCuaHangNhaCCDAO {
    public List<HethongCuaHangNhaCC> getAllKho() throws SQLException;
    public HethongCuaHangNhaCC getKhoByID(int id) throws SQLException;
    public void deleteKho(HethongCuaHangNhaCC Kho) throws SQLException;
    public void deleteKho(int id) throws SQLException;
    public void insertCuaHang(HethongCuaHangNhaCC Kho) throws SQLException;
    public void updateCuaHang(HethongCuaHangNhaCC Kho) throws SQLException;    
}
