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
public interface SanPhamTrongHoaDonDAO {
    public List<SanPhamTrongHoaDon> getAllSanPhamTrongHoaDon() throws SQLException;
    public SanPhamTrongHoaDon getSanPhamTrongHoaDonByID(int id) throws SQLException;
    public void deleteSanPhamTrongHoaDon(SanPhamTrongHoaDon sp) throws SQLException;
    public void deleteSanPhamTrongHoaDon(int id) throws SQLException;
    public int insertSanPhamTrongHoaDon(SanPhamTrongHoaDon sp) throws SQLException;
    public void insertMultiSanPhamTrongHoaDon(List<SanPhamTrongHoaDon> SPs) throws SQLException;
    public void updateSanPhamTrongHoaDon(SanPhamTrongHoaDon sp) throws SQLException;    
}
