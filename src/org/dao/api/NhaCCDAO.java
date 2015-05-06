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
public interface NhaCCDAO {
    public List<CuaHangNhaCC> getAllNhaCC() throws SQLException;
    public CuaHangNhaCC getNhaCCByID(int id) throws SQLException;
    public void deleteNhaCC(CuaHangNhaCC nhaCC) throws SQLException;
    public void deleteNhaCC(int id) throws SQLException;
    public void insertNhaCC(CuaHangNhaCC nhaCC) throws SQLException;
    public void updateNhaCC(CuaHangNhaCC nhaCC) throws SQLException;    
}
