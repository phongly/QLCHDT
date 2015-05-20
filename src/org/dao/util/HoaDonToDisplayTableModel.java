/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dao.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.pojo.HoaDonToDisPlay;

/**
 *
 * @author ly.phong
 */
public class HoaDonToDisplayTableModel extends AbstractTableModel{

    private String[] columnNames =
    {
        "ID",
        "Staff",
        "Customer",
        "Total",
        "Date",
        "Provider",
        "Status"
        
    };
    private List<HoaDonToDisPlay> sanPhamTrongHoaDons;
    
    public HoaDonToDisplayTableModel() {
        sanPhamTrongHoaDons = new ArrayList<>();
    }

    public HoaDonToDisplayTableModel(List<HoaDonToDisPlay> sanPhamTrongHoaDons) {
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
            case 0: return Integer.class;
            case 4: return Double.class;
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
        HoaDonToDisPlay sanPhamTHD = getSPTrongHD(row);
        switch (column)
        {
            case 0: return sanPhamTHD.getId();
            case 1: return sanPhamTHD.getNhanVien();
            case 2: return sanPhamTHD.getKhachHang();           
            case 3: return sanPhamTHD.getTongTien();
            case 4: return sanPhamTHD.getNgayNhap();
            case 5: return sanPhamTHD.getTinhTrang();
            default: return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int column)
    {
        HoaDonToDisPlay sanPhamTHD = getSPTrongHD(row);

        switch (column)
        {
            case 0:  sanPhamTHD.setId((int)value);break;           
            case 1:  sanPhamTHD.setNgayNhap((Date)value); break;
//            case 2:  sanPhamTHD.setSoLuongMua((int)value); break;
//            case 3:  sanPhamTHD.setThanhTien();
        }

        fireTableCellUpdated(row, column);
    }
    public HoaDonToDisPlay getSPTrongHD(int row)
    {
        return sanPhamTrongHoaDons.get(row);
    }
    
    public void addSanPhamTHD(HoaDonToDisPlay sanPhamTHD)
    {
        insertSanPhamTHD(getRowCount(), sanPhamTHD);
    }

    public void insertSanPhamTHD(int row, HoaDonToDisPlay spTHD)
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
