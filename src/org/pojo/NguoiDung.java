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
public class NguoiDung {
    private int id;
    private String ten;
    private String diaChi;
    private String soDT;
    private String matKhau;
    private int loai; // 1: nhan vien, 2: khach hang

    public NguoiDung() {
    }
  
    public NguoiDung(int id, String ten, String diaChi, String soDT, String matKhau, int loai) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.matKhau = matKhau;
        this.loai = loai;
    }

    public NguoiDung(String ten, String diaChi, String soDT, String matKhau, int loai) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.matKhau = matKhau;
        this.loai = loai;
    }

    public NguoiDung(int id, int loai) {
        this.id = id;
        this.loai = loai;
    }
        

    public NguoiDung(String ten, String diaChi, String soDT, int loai) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.loai = loai;
    }

    public NguoiDung(String ten, String diaChi, String soDT) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }
    
    
}
