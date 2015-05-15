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
public interface HoaDonDAO {
    public List<HoaDon> getAllHoaDon() throws SQLException;
    public HoaDon getHoaDonByID(int id) throws SQLException;
    public void deleteHoaDon(HoaDon hd) throws SQLException;
    public void deleteHoaDon(int id) throws SQLException;
    public int insertHoaDon(HoaDon hd) throws SQLException;
    public void updateHoaDon(HoaDon hd) throws SQLException;
}
