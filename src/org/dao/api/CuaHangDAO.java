/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.api;

import java.sql.SQLException;
import java.util.List;
import org.pojo.CuaHangNhaCC;
/**
 *
 * @author ly.phong
 */
public interface CuaHangDAO {
    public List<CuaHangNhaCC> getAllCuaHang() throws SQLException;
    public CuaHangNhaCC getCuaHangByID(int id) throws SQLException;
    public void deleteCuaHang(CuaHangNhaCC cuaHang) throws SQLException;
    public void deleteCuaHang(int id) throws SQLException;
    public void insertCuaHang(CuaHangNhaCC cuaHang) throws SQLException;
    public void updateCuaHang(CuaHangNhaCC cuaHang) throws SQLException;
}
