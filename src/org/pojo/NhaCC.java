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
public class NhaCC {
    private int nhaCCID;
    private String ten;
    private String diaChi;
    private String soDT;

    public NhaCC() {
    }

    public NhaCC(String ten) {
        this.ten = ten;
    }

    public NhaCC(String ten, String diaChi) {
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public NhaCC(String ten, String diaChi, String soDT) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public int getNhaCCID() {
        return nhaCCID;
    }

//    public void setNhaCCID(int nhaCCID) {
//        this.nhaCCID = nhaCCID;
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
