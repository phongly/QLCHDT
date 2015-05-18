/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pojo;

/**
 *
 * @author ly.phong
 */
public class SanPhamTrongHoaDon extends SanPham{
    private int id;
    private int hoaDonID;
    private int sanPhamID;
    private int soLuongMua;

    public SanPhamTrongHoaDon() {
        super();
    }

    public SanPhamTrongHoaDon(String ten, double donGia) {
        super(ten, donGia);
    }

    
    public SanPhamTrongHoaDon(int hoaDonID, int sanPhamID, int soLuongMua) {
        super();
        this.hoaDonID = hoaDonID;
        this.sanPhamID = sanPhamID;
        this.soLuongMua = soLuongMua;
    }

    public SanPhamTrongHoaDon(int id, int hoaDonID, int sanPhamID, int soLuongMua) {
        super();
        this.id = id;
        this.hoaDonID = hoaDonID;
        this.sanPhamID = sanPhamID;
        this.soLuongMua = soLuongMua;
    }

    public SanPhamTrongHoaDon(int hoaDonID, int soLuongMua, String ten, double donGia) {
        super(ten, donGia);
        this.hoaDonID = hoaDonID;
        this.soLuongMua = soLuongMua;
    }

    public SanPhamTrongHoaDon(int id, int hoaDonID, int soLuongMua, int sanPhamID, String ten, double donGia) {
        super(sanPhamID, ten, donGia);
        this.id = id;
        this.hoaDonID = hoaDonID;
        this.soLuongMua = soLuongMua;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(int hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public int getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
}
