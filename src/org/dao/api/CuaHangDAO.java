/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.api;

import java.sql.SQLException;
import java.util.List;
import org.pojo.CuaHang;
/**
 *
 * @author ly.phong
 */
public interface CuaHangDAO {
    public List<CuaHang> getAllCuaHang() throws SQLException;
    public CuaHang getCuaHangByID(int id) throws SQLException;
    public void deleteCuaHang(CuaHang cuaHang) throws SQLException;
    public void deleteCuaHang(int id) throws SQLException;
    public void insertCuaHang(CuaHang cuaHang) throws SQLException;
    public void updateCuaHang(CuaHang cuaHang) throws SQLException;
}
