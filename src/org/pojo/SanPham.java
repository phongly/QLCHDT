/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pojo;

/**
 *
 * @author Chan
 */
public class SanPham {
    private int sanPhamID;
    private String ten;
    private Number donGia;

    public SanPham() {
    }

    public SanPham(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }
    
    public SanPham(int sanPhamID, String ten) {
        this.sanPhamID = sanPhamID;
        this.ten = ten;
    }
   
    public SanPham(int sanPhamID, String ten, Number donGia) {
        this.sanPhamID = sanPhamID;
        this.ten = ten;
        this.donGia = donGia;
    }

    public int getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Number getDonGia() {
        return donGia;
    }

    public void setDonGia(Number donGia) {
        this.donGia = donGia;
    }    
    
}
