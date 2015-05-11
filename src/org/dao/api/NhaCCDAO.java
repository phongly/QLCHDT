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
public interface NhaCCDAO {
    public List<HethongCuaHangNhaCC> getAllNhaCC() throws SQLException;
    public HethongCuaHangNhaCC getNhaCCByID(int id) throws SQLException;
    public void deleteNhaCC(HethongCuaHangNhaCC nhaCC) throws SQLException;
    public void deleteNhaCC(int id) throws SQLException;
    public int insertNhaCC(HethongCuaHangNhaCC nhaCC) throws SQLException;
    public void updateNhaCC(HethongCuaHangNhaCC nhaCC) throws SQLException;    
}
