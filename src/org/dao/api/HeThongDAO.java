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
 * @author Chan
 */
public interface HeThongDAO {
    public HethongCuaHangNhaCC getHeThong() throws SQLException;
    public void deleteHeThong() throws SQLException;
    public void insertCuaHang(HethongCuaHangNhaCC heThong) throws SQLException;
    public void updateCuaHang(HethongCuaHangNhaCC heThong) throws SQLException;    
}
