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
import org.pojo.SanPhamToDisplay;

/**
 *
 * @author ly.phong
 */
public class SanPhamDisplayTableModel extends AbstractTableModel{

    private String[] columnNames =
    {
        "ID",
        "Name",
        "Price",
        "In Stock",
        "Provider"
    };
    private List<SanPhamToDisplay> sanPhams;
    
    public SanPhamDisplayTableModel() {
        sanPhams = new ArrayList<>();
    }

    public SanPhamDisplayTableModel(List<SanPhamToDisplay> sanPhams) {
        this.sanPhams = sanPhams;
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
        return sanPhams.size();
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
        SanPhamToDisplay sanPham = getSanPham(row);
        switch (column)
        {
            case 0: return sanPham.getSanPhamTrongKhoID();
            case 1: return sanPham.getTen();
            case 2: return sanPham.getDonGia();
            case 3: return sanPham.getSoLuongTon();
            case 4: return sanPham.getTenNhaCC();
            default: return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int column)
    {
        SanPhamToDisplay sanPham = getSanPham(row);

        switch (column)
        {
            case 0:  sanPham.setSanPhamTrongKhoID((int)value);break;
            case 1:  sanPham.setTen((String)value); break;
            case 2:  sanPham.setDonGia((double)value); break;
            case 3:  sanPham.setSoLuongTon((int)value); break;
            case 4:  sanPham.setTenNhaCC((String)value); break;
        }

        fireTableCellUpdated(row, column);
    }
    public SanPhamToDisplay getSanPham(int row)
    {
        return sanPhams.get(row);
    }
    
    public void addSanPham(SanPhamToDisplay sanPham)
    {
        insertSanPham(getRowCount(), sanPham);
    }

    public void insertSanPham(int row, SanPhamToDisplay sanPham)
    {
        sanPhams.add(row, sanPham);
        fireTableRowsInserted(row, row);
    }

    public void removeSanPham(int row)
    {
        sanPhams.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
