/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.dao.util.PostgreConnection;
import org.pojo.SanPhamToDisplay;
import org.dao.api.SanPhamToDisplayDAO;
import org.pojo.SanPhamTrongKho;

/**
 *
 * @author Chan
 */
public class SanPhamToDisplayDAOImpl implements SanPhamToDisplayDAO{
    
    private SanPhamToDisplay convert(ResultSet rs) throws SQLException {
        int sanPhamTrongKhoID = rs.getInt("id");
        int sanPhamID = rs.getInt("id_sp");
        int khoID = rs.getInt("id_kho");
        int nhaCCID = rs.getInt("nhacc_id");
        String tenSP = rs.getString("tensp");
        double gia = rs.getDouble("dongia");
        String tenKho = rs.getString("tencuahang");
        String tenNhaCC = rs.getString("tennhacungcap");
        int soLuongTon = rs.getInt("soluongton");
        Date ngayNhap = rs.getDate("ngaynhap");
        Date ngayXuat = rs.getDate("ngayxuat");
        SanPhamToDisplay sanPhamTrongKho = new SanPhamToDisplay(sanPhamID, sanPhamTrongKhoID, khoID, nhaCCID, soLuongTon, tenKho, tenNhaCC, ngayNhap, ngayXuat);
        sanPhamTrongKho.setTen(tenSP);
        sanPhamTrongKho.setDonGia(gia);
        return sanPhamTrongKho;
    }
    
    @Override
    public List<SanPhamToDisplay> getAllSanPhamToDisPlay() throws SQLException {
        Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<SanPhamToDisplay> list = new ArrayList<>();
        String sql = "SELECT sp.id AS id_sp, sp.ten AS tensp, sptk.so_luong_ton AS soluongton, sp.don_gia AS dongia,\n" +
                    "	sptk.ngay_xuat AS ngayxuat, sptk.ngay_nhap AS ngaynhap, sptk.id, sptk.nhacc_id,\n" +
                    "	nhacc.ten AS tennhacungcap, kho.ten AS tencuahang, sptk.id_kho\n" +
                    "  FROM sanpham_trong_kho AS sptk\n" +
                    "  INNER JOIN sanpham AS sp\n" +
                    "  ON sptk.id_sp = sp.id\n" +
                    "  INNER JOIN cuahang_hethong_nhacc AS kho\n" +
                    "  ON sptk.id_kho = kho.id\n" +
                    "  INNER JOIN cuahang_hethong_nhacc AS nhacc\n" +
                    "  ON sptk.nhacc_id = nhacc.id";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;        
    }

    @Override
    public List<SanPhamToDisplay> getAllSanPhamToDisPlayByLoaiCuaHang(int loai) throws SQLException {
      Statement statement = PostgreConnection.getInstance().getConnection().createStatement();
        List<SanPhamToDisplay> list = new ArrayList<>();
        String sql = " SELECT sp.id AS id_sp, sp.ten AS tensp, sptk.so_luong_ton AS soluongton, sp.don_gia AS dongia,\n" +
                        "	sptk.ngay_xuat AS ngayxuat, sptk.ngay_nhap AS ngaynhap, sptk.id, sptk.nhacc_id,\n" +
                        "	nhacc.ten AS tennhacungcap, kho.ten AS tencuahang, sptk.id_kho\n" +
                        "  FROM sanpham_trong_kho AS sptk\n" +
                        "  INNER JOIN sanpham AS sp\n" +
                        "  ON sptk.id_sp = sp.id\n" +
                        "  INNER JOIN cuahang_hethong_nhacc AS nhacc\n" +
                        "  ON sptk.nhacc_id = nhacc.id \n" +
                        "  INNER JOIN cuahang_hethong_nhacc AS kho\n" +
                        "  ON sptk.id_kho = kho.id AND kho.loai="+loai;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(convert(rs));
        }
        rs.close();
        statement.close();
        return list;
    }
}
