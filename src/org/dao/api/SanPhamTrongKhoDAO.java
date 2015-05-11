/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.api;

import java.sql.SQLException;
import java.util.List;
import org.pojo.SanPhamTrongKho;
import org.pojo.SanPhamToDisplay;
/**
 *
 * @author ly.phong
 */
public interface SanPhamTrongKhoDAO {
    public List<SanPhamTrongKho> getAllSanPhamTrongKho() throws SQLException;
    public List<SanPhamTrongKho> getAllSanPhamTrongKhoByKhoID(int khoID) throws SQLException;
//    public List<SanPhamTrongKho> getAllSanPhamTrongKhoBySanPhamID(int spID) throws SQLException;
    public SanPhamTrongKho getSanPhamTrongKhoByID(int id) throws SQLException;
    public void deleteSanPhamTrongKho(SanPhamTrongKho sp) throws SQLException;
    public void deleteSanPhamTrongKho(int id) throws SQLException;
    public int insertSanPhamTrongKho(SanPhamTrongKho sp) throws SQLException;
    public void updateSanPhamTrongKho(SanPhamTrongKho sp) throws SQLException;
    
}
