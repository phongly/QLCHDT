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
public class ThongTinCaoCap {
    private int id;
    private String tenThongTin;
    private String moTa;
    private int sanPhamID;

    public ThongTinCaoCap(int id, String tenThongTin, String moTa, int sanPhamID) {
        this.id = id;
        this.tenThongTin = tenThongTin;
        this.moTa = moTa;
        this.sanPhamID = sanPhamID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThongTin() {
        return tenThongTin;
    }

    public void setTenThongTin(String tenThongTin) {
        this.tenThongTin = tenThongTin;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }
    
    
}
