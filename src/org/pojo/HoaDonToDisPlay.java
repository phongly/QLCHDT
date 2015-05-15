/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pojo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author ly.phong
 */
public class HoaDonToDisPlay extends HoaDon{
    private List<SanPhamTrongHoaDon> sanPhamDuocMuas;
    private NguoiDung khachHang;
    private NguoiDung nhanVien;
    private HethongCuaHangNhaCC cuaHang;
    private String tenNhanvien;
    private String tenKhachHang;
    private String tenCuaHang;
    private double tongTien = 0;

    public HoaDonToDisPlay() {
    }

    public HoaDonToDisPlay(Date ngayNhap, int cuaHangID, int khachHangID, int nhanVienID) {
        super(ngayNhap, cuaHangID, khachHangID, nhanVienID);
        
    }
   
    public HoaDonToDisPlay(int id, Date ngayNhap, double tongTien, int cuaHangID, int khachHangID, int nhanVienID) {
        super(id, ngayNhap, tongTien, cuaHangID, khachHangID, nhanVienID);
    }

    public HoaDonToDisPlay( Date ngayNhap, double tongTien, int cuaHangID, int khachHangID, int nhanVienID) {
        super( ngayNhap, tongTien, cuaHangID, khachHangID, nhanVienID);
    }

    public HoaDonToDisPlay(Date ngayNhap, double tongTien,
            List<SanPhamTrongHoaDon> sanPhamDuocMuas, NguoiDung khachHang, NguoiDung nhanVien, HethongCuaHangNhaCC cuaHang) {
        
        super(ngayNhap, tongTien, cuaHang.getCuaHangID(), khachHang.getId(), nhanVien.getId());
        this.sanPhamDuocMuas = sanPhamDuocMuas;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.cuaHang = cuaHang;
        
        this.tenNhanvien = this.nhanVien.getTen();
        this.tenKhachHang = this.khachHang.getTen();
        this.tenCuaHang = this.cuaHang.getTen();
    }
    
    public HoaDonToDisPlay(int id, Date ngayNhap, double tongTien,
            List<SanPhamTrongHoaDon> sanPhamDuocMuas, NguoiDung khachHang, NguoiDung nhanVien, HethongCuaHangNhaCC cuaHang) {
        
        super(id, ngayNhap, tongTien, cuaHang.getCuaHangID(), khachHang.getId(), nhanVien.getId());
        this.sanPhamDuocMuas = sanPhamDuocMuas;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.cuaHang = cuaHang;
        
        this.tenNhanvien = this.nhanVien.getTen();
        this.tenKhachHang = this.khachHang.getTen();
        this.tenCuaHang = this.cuaHang.getTen();
    }
        
    @Override
    public double getTongTien() {
        if(sanPhamDuocMuas.size() > 0)
        for (SanPhamTrongHoaDon sanPhamDuocMua : sanPhamDuocMuas) {
            tongTien += sanPhamDuocMua.getDonGia();
        }
        return tongTien;
    }

    public NguoiDung getKhachHang() {
        return khachHang;
    }

    public NguoiDung getNhanVien() {
        return nhanVien;
    }
    
    
}
