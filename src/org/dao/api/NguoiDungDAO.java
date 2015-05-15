/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.api;

import java.sql.SQLException;
import java.util.List;
import org.pojo.*;

/**
 *
 * @author ly.phong
 */
public interface NguoiDungDAO {
    public List<NguoiDung> getAllNguoiDung() throws SQLException;
    public NguoiDung getNguoiDungByID(int id) throws SQLException;
    public void deleteNguoiDung(NguoiDung ngDung) throws SQLException;
    public void deleteNguoiDung(int id) throws SQLException;
    public int insertNguoiDung(NguoiDung ngDung) throws SQLException;
    public void updateNguoiDung(NguoiDung ngDung) throws SQLException;    
}
