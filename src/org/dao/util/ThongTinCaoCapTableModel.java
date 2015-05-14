/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.pojo.*;

/**
 *
 * @author ly.phong
 */
public class ThongTinCaoCapTableModel extends AbstractTableModel{

    private String[] columnNames =
    {
        "ID",
        "Feature",
        "Description",
        
    };
    private List<ThongTinCaoCap> thongTinCCs;
    
    public ThongTinCaoCapTableModel() {
        thongTinCCs = new ArrayList<>();
    }

    public ThongTinCaoCapTableModel(List<ThongTinCaoCap> thongTinCCs) {
        this.thongTinCCs = thongTinCCs;
    }
    
    
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public int getRowCount()
    {
        return thongTinCCs.size();
    }
    @Override
    public Class getColumnClass(int column)
    {
        switch (column)
        {
            case 2: return Number.class;
            default: return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column)
    {
        switch (column)
        {
            case 2: return true; // only the birth date is editable
            default: return false;
        }
    }
    @Override
    public Object getValueAt(int row, int column)
    {
        ThongTinCaoCap thongTin = getThongTin(row);
        switch (column)
        {
            case 0: return thongTin.getId();
            case 1: return thongTin.getTenThongTin();
            case 2: return thongTin.getMoTa();
            default: return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int column)
    {
        ThongTinCaoCap thongTin = getThongTin(row);

        switch (column)
        {
            case 0:  thongTin.setId((int)value);break;
            case 1:  thongTin.setTenThongTin((String)value); break;
            case 2:  thongTin.setMoTa((String)value); break;
        }

        fireTableCellUpdated(row, column);
    }
    public ThongTinCaoCap getThongTin(int row)
    {
        return thongTinCCs.get(row);
    }
    
    public void addThongTinCC(ThongTinCaoCap thongTin)
    {
        insertThongTin(getRowCount(), thongTin);
    }

    public void insertThongTin(int row, ThongTinCaoCap thongTin)
    {
        thongTinCCs.add(row, thongTin);
        fireTableRowsInserted(row, row);
    }

    public void removeSanPham(int row)
    {
        thongTinCCs.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
