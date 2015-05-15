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
public class HoaDon {
    private int id;
    private Date ngayNhap;
    private double tongTien;
    private int cuaHangID;
    private int khachHangID;
    private int nhanVienID;
    private int tinhTrang = 0; // 0=normal, 1=delete, 2=edit

    public HoaDon() {
    }

    public HoaDon(int id, Date ngayNhap, double tongTien, int cuaHangID, int khachHangID, int nhanVienID, int tinhTrang) {
        this.id = id;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.cuaHangID = cuaHangID;
        this.khachHangID = khachHangID;
        this.nhanVienID = nhanVienID;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon( Date ngayNhap, double tongTien, int cuaHangID, int khachHangID, int nhanVienID, int tinhTrang) {
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.cuaHangID = cuaHangID;
        this.khachHangID = khachHangID;
        this.nhanVienID = nhanVienID;
        this.tinhTrang = tinhTrang;
    }
    
    public HoaDon(int id, Date ngayNhap, double tongTien, int cuaHangID, int khachHangID, int nhanVienID) {
        this.id = id;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.cuaHangID = cuaHangID;
        this.khachHangID = khachHangID;
        this.nhanVienID = nhanVienID;
    }
    
    public HoaDon(Date ngayNhap, double tongTien, int cuaHangID, int khachHangID, int nhanVienID) {
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.cuaHangID = cuaHangID;
        this.khachHangID = khachHangID;
        this.nhanVienID = nhanVienID;
    }

    public HoaDon(Date ngayNhap, int cuaHangID, int khachHangID, int nhanVienID) {
        this.ngayNhap = ngayNhap;
        this.cuaHangID = cuaHangID;
        this.khachHangID = khachHangID;
        this.nhanVienID = nhanVienID;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getCuaHangID() {
        return cuaHangID;
    }

    public void setCuaHangID(int cuaHangID) {
        this.cuaHangID = cuaHangID;
    }

    public int getKhachHangID() {
        return khachHangID;
    }

    public void setKhachHangID(int khachHangID) {
        this.khachHangID = khachHangID;
    }

    public int getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(int nhanVienID) {
        this.nhanVienID = nhanVienID;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
