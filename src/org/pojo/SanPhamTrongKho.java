/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pojo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author ly.phong
 */
public class SanPhamTrongKho extends SanPham{
    private int sanPhamTrongKhoID;
    private int KhoID;
    private int nhaCCID;
    private int nhanVienNhapID;
    private int nhanVienXuatID;
    private int soLuongTon;
    private Date ngayNhap;
    private Date ngayXuat;
    
    
    public SanPhamTrongKho() {
        super();
    }

    public SanPhamTrongKho(String ten, double donGia) {
        super(ten, donGia);
    }
       
    public SanPhamTrongKho(int sanPhamTrongKhoID) {
        super();
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
    public SanPhamTrongKho(int sanPhamTrongKhoID, int KhoID, int sanPhamID, int soLuongTon, Date ngayNhap, Date ngayXuat, int nvNhapID, int nvXuatID) {
        super(sanPhamID);
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
        this.KhoID = KhoID;
        this.soLuongTon = soLuongTon;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
        this.nhanVienNhapID = nvNhapID;
        this.nhanVienXuatID = nvXuatID;
    }

    public SanPhamTrongKho(int sanPhamTrongKhoID, int KhoID, int nhaCCID, int soLuongTon, Date ngayNhap, Date ngayXuat, int sanPhamID) {
        super(sanPhamID);
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
        this.KhoID = KhoID;
        this.nhaCCID = nhaCCID;
        this.soLuongTon = soLuongTon;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
    }
    public SanPhamTrongKho(int sanPhamTrongKhoID, int KhoID, int nhaCCID, int soLuongTon, Date ngayNhap, Date ngayXuat, int sanPhamID, int nvNhapID, int nvXuatID) {
        super(sanPhamID);
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
        this.KhoID = KhoID;
        this.nhaCCID = nhaCCID;
        this.soLuongTon = soLuongTon;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
        this.nhanVienNhapID = nvNhapID;
        this.nhanVienXuatID = nvXuatID;
    }

    
    public int getSanPhamTrongKhoID() {
        return sanPhamTrongKhoID;
    }

    public void setSanPhamTrongKhoID(int sanPhamTrongKhoID) {
        this.sanPhamTrongKhoID = sanPhamTrongKhoID;
    }

    public int getKhoID() {
        return KhoID;
    }

    public void setKhoID(int KhoID) {
        this.KhoID = KhoID;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }   

    public int getNhaCCID() {
        return nhaCCID;
    }

    public void setNhaCCID(int nhaCCID) {
        this.nhaCCID = nhaCCID;
    }

    public int getNhanVienNhapID() {
        return nhanVienNhapID;
    }

    public void setNhanVienNhapID(int nhanVienNhapID) {
        this.nhanVienNhapID = nhanVienNhapID;
    }

    public int getNhanVienXuatID() {
        return nhanVienXuatID;
    }

    public void setNhanVienXuatID(int nhanVienXuatID) {
        this.nhanVienXuatID = nhanVienXuatID;
    }

    
}
