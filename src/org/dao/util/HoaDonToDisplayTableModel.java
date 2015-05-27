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
    private List<HoaDonToDisPlay> hoaDonToDisplays;
    
    public HoaDonToDisplayTableModel() {
        hoaDonToDisplays = new ArrayList<>();
    }

    public HoaDonToDisplayTableModel(List<HoaDonToDisPlay> hoaDons) {
        this.hoaDonToDisplays = hoaDons;
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
        return hoaDonToDisplays.size();
    }
    @Override
    public Class getColumnClass(int column)
    {
        switch (column)
        {
            case 0: return Integer.class;
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
        HoaDonToDisPlay hoaDon = getHD(row);
        switch (column)
        {
            case 0: return hoaDon.getId();
            case 1: return hoaDon.getNhanVien().getTen();
            case 2: return hoaDon.getKhachHang().getTen();           
            case 3: return hoaDon.getTongTien();
            case 4: return hoaDon.getNgayNhap();
            case 5: return hoaDon.getTinhTrang();
            case 6: return "cuong";
            default: return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int column)
    {
        HoaDonToDisPlay sanPhamTHD = getHD(row);

        switch (column)
        {
            case 0:  sanPhamTHD.setId((int)value);break;           
            case 1:  sanPhamTHD.setNgayNhap((Date)value); break;
//            case 2:  sanPhamTHD.setSoLuongMua((int)value); break;
//            case 3:  sanPhamTHD.setThanhTien();
        }

        fireTableCellUpdated(row, column);
    }
    public HoaDonToDisPlay getHD(int row)
    {
        return hoaDonToDisplays.get(row);
    }
    
    public void addHoaDon(HoaDonToDisPlay hoaDon)
    {
        insertHoaDon(getRowCount(), hoaDon);
    }

    public void insertHoaDon(int row, HoaDonToDisPlay spTHD)
    {
        hoaDonToDisplays.add(row, spTHD);
        fireTableRowsInserted(row, row);
    }

    public void removeHoaDon(int row)
    {
        hoaDonToDisplays.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    public List<HoaDonToDisPlay> getAllHoaDons() 
    {
        return hoaDonToDisplays;      
    }
}
