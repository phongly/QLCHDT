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
public interface ThongTinCaoCapDAO {
    public List<ThongTinCaoCap> getAllThongTin() throws SQLException;
    public ThongTinCaoCap getThongTinByID(int id) throws SQLException;
    public List<ThongTinCaoCap> getAllThongTinBySanPhamID(int id) throws SQLException;
    public void deleteThongTin(ThongTinCaoCap thongTin) throws SQLException;
    public void deleteThongTin(int id) throws SQLException;
    public int insertThongTin(ThongTinCaoCap thongTin) throws SQLException;
    public void updateThongTin(ThongTinCaoCap thongTin) throws SQLException;
}
