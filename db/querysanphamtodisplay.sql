SELECT sp.id AS id_sp, sp.ten AS tensp, sptk.so_luong_ton AS soluongton, sp.don_gia AS dongia,
	sptk.ngay_xuat AS ngayxuat, sptk.ngay_nhap AS ngaynhap, sptk.id, sptk.nhacc_id,
	nhacc.ten AS tennhacungcap, kho.ten AS tencuahang, sptk.id_kho
  FROM sanpham_trong_kho AS sptk
  INNER JOIN sanpham AS sp
  ON sptk.id_sp = sp.id
  INNER JOIN cuahang_hethong_nhacc AS nhacc
  ON sptk.nhacc_id = nhacc.id
  INNER JOIN cuahang_hethong_nhacc AS kho
  ON sptk.id_kho = kho.id AND kho.id=1