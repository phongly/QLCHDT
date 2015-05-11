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
public interface CuaHangDAO {
    public List<HethongCuaHangNhaCC> getAllCuaHang() throws SQLException;
    public HethongCuaHangNhaCC getCuaHangByID(int id) throws SQLException;
    public void deleteCuaHang(HethongCuaHangNhaCC cuaHang) throws SQLException;
    public void deleteCuaHang(int id) throws SQLException;
    public void insertCuaHang(HethongCuaHangNhaCC cuaHang) throws SQLException;
    public void updateCuaHang(HethongCuaHangNhaCC cuaHang) throws SQLException;
}
