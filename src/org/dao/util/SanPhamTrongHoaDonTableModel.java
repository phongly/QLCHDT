/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.pojo.SanPhamTrongHoaDon;

/**
 *
 * @author ly.phong
 */
public class SanPhamTrongHoaDonTableModel extends AbstractTableModel{

    private String[] columnNames =
    {
        "Product",
        "Price Per Unit",
        "Buy Number Units",
        "Final Price"
        
    };
    private List<SanPhamTrongHoaDon> sanPhamTrongHoaDons;
    
    public SanPhamTrongHoaDonTableModel() {
        sanPhamTrongHoaDons = new ArrayList<>();
    }

    public SanPhamTrongHoaDonTableModel(List<SanPhamTrongHoaDon> sanPhamTrongHoaDons) {
        this.sanPhamTrongHoaDons = sanPhamTrongHoaDons;
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
        return sanPhamTrongHoaDons.size();
    }
    @Override
    public Class getColumnClass(int column)
    {
        switch (column)
        {
//            case 0: return Integer.class;
            default: return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column)
    {
        switch (column)
        {
            default: return false;
        }
    }
    @Override
    public Object getValueAt(int row, int column)
    {
        SanPhamTrongHoaDon sanPhamTHD = getSPTrongHD(row);
        switch (column)
        {
            case 0: return sanPhamTHD.getTen();
            case 1: return sanPhamTHD.getDonGia();
            case 2: return sanPhamTHD.getSoLuongMua();           
            case 3: return sanPhamTHD.getThanhTien();
            default: return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int column)
    {
        SanPhamTrongHoaDon sanPhamTHD = getSPTrongHD(row);

        switch (column)
        {
            case 0:  sanPhamTHD.setTen((String)value);break;           
            case 1:  sanPhamTHD.setDonGia((double)value); break;
            case 2:  sanPhamTHD.setSoLuongMua((int)value); break;
//            case 3:  sanPhamTHD.setThanhTien();
        }

        fireTableCellUpdated(row, column);
    }
    public SanPhamTrongHoaDon getSPTrongHD(int row)
    {
        return sanPhamTrongHoaDons.get(row);
    }
    
    public void addSanPhamTHD(SanPhamTrongHoaDon sanPhamTHD)
    {
        insertSanPhamTHD(getRowCount(), sanPhamTHD);
    }

    public void insertSanPhamTHD(int row, SanPhamTrongHoaDon spTHD)
    {
        sanPhamTrongHoaDons.add(row, spTHD);
        fireTableRowsInserted(row, row);
    }

    public void removeSanPhamTHD(int row)
    {
        sanPhamTrongHoaDons.remove(row);
        fireTableRowsDeleted(row, row);
    }    
}
