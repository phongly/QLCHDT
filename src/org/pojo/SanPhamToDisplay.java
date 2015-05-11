/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pojo;

import java.sql.Date;

/**
 *
 * @author Chan
 */
public class SanPhamToDisplay extends SanPhamTrongKho{
    private String tenKho;
    private String nhaCC;
    public SanPhamToDisplay() {
    }

    public SanPhamToDisplay(int sanPhamID, int sanPhamTrongKhoID, int KhoID, int nhaCCID, int soLuongTon, String tenKho, String tenNhaCC, Date ngayNhap, Date ngayXuat) {
        super(sanPhamTrongKhoID, KhoID, nhaCCID, soLuongTon, ngayNhap, ngayXuat, sanPhamID);
        this.tenKho = tenKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }
    
}
