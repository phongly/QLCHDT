/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pojo;

import java.sql.Date;

/**
 *
 * @author ly.phong
 */
public class SanPhamTrongKho extends SanPham{
    private int sanPhamTrongKhoID;
    private int KhoID;
    private int soLuongTon;
    private Date ngayNhap;
    private Date ngayXuat;
    
    public SanPhamTrongKho() {
    }

    public SanPhamTrongKho(int sanPhamTrongKhoID) {
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
    }
    
    public SanPhamTrongKho(int sanPhamTrongKhoID, int KhoID, int sanPhamID) {
        super(sanPhamID);
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
        this.KhoID = KhoID;
    }

    public SanPhamTrongKho(int sanPhamTrongKhoID, int KhoID, int sanPhamID, int soLuongTon) {
        super(sanPhamID);
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
        this.KhoID = KhoID;
        this.soLuongTon = soLuongTon;
    }
       
    public SanPhamTrongKho(int sanPhamTrongKhoID, int KhoID, int sanPhamID, int soLuongTon, Date ngayNhap, Date ngayXuat) {
        super(sanPhamID);
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
        this.KhoID = KhoID;
        this.soLuongTon = soLuongTon;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
    }



}
