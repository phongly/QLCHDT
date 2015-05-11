/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.api;
import java.sql.SQLException;
import java.util.List;
import org.pojo.SanPhamToDisplay;
//import org.pojo.SanPhamTrongKho;
/**
 *
 * @author Chan
 */
public interface SanPhamToDisplayDAO{
    public List<SanPhamToDisplay> getAllSanPhamToDisaPlay() throws SQLException;
}
