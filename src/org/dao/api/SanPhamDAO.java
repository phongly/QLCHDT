/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.api;

import java.sql.SQLException;
import java.util.List;
import org.pojo.SanPham;
/**
 *
 * @author Chan
 */
public interface SanPhamDAO {
    public List<SanPham> getAllSanPham() throws SQLException;
    public SanPham getSanPhamByID(int id) throws SQLException;
    public void deleteSanPham(SanPham sp) throws SQLException;
    public void deleteSanPham(int id) throws SQLException;
    public void insertSanPham(SanPham sp) throws SQLException;
    public void updateSanPham(SanPham sp) throws SQLException;
}
