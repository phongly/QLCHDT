package org.pojo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ly.phong
 * Vì cửa hàng và nhà cung cấp có chung thuộc tính nên sẽ dùng chung class này
 */
public class CuaHangNhaCC {
    private int cuaHangID;
    private String ten;
    private String diaChi;
    private String soDT;
    private String loai;
    public CuaHangNhaCC() {
    }

    public CuaHangNhaCC(int cuaHangID) {
        this.cuaHangID = cuaHangID;
    }
   
    public CuaHangNhaCC(int cuaHangID, String ten) {
        this.cuaHangID = cuaHangID;
        this.ten = ten;
    }

    public CuaHangNhaCC(int cuaHangID, String ten, String diaChi) {
        this.cuaHangID = cuaHangID;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public CuaHangNhaCC(int cuaHangID, String ten, String diaChi, String soDT) {
        this.cuaHangID = cuaHangID;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public CuaHangNhaCC(int cuaHangID, String ten, String diaChi, String soDT, String loai) {
        this.cuaHangID = cuaHangID;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.loai = loai;
    }

    public CuaHangNhaCC(String ten, String diaChi, String soDT, String loai) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.loai = loai;
    }
    
    
    public int getCuaHangID() {
        return cuaHangID;
    }

    public void setCuaHangID(int cuaHangID) {
        this.cuaHangID = cuaHangID;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

}
