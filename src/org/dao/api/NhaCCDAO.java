/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.api;

import java.sql.SQLException;
import java.util.List;
import org.pojo.NhaCC;
/**
 *
 * @author ly.phong
 */
public interface NhaCCDAO {
    public List<NhaCC> getAllNhaCC() throws SQLException;
    public NhaCC getNhaCCByID(int id) throws SQLException;
    public void deleteNhaCC(NhaCC nhaCC) throws SQLException;
    public void deleteNhaCC(int id) throws SQLException;
    public void insertNhaCC(NhaCC nhaCC) throws SQLException;
    public void updateNhaCC(NhaCC nhaCC) throws SQLException;
}