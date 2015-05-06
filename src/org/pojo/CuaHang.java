package org.pojo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ly.phong
 */
public class CuaHang {
    private int cuaHangID;
    private String ten;
    private String diaChi;
    private String soDT;

    public CuaHang() {
    }

    public CuaHang(String ten) {
        this.ten = ten;
    }

    public CuaHang(String ten, String diaChi) {
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public CuaHang(String ten, String diaChi, String soDT) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public int getCuaHangID() {
        return cuaHangID;
    }

//    public void setCuaHangID(int cuaHangID) {
//        this.cuaHangID = cuaHangID;
//    }

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
    
    
}
