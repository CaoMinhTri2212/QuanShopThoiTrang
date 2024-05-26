package Model;

import java.sql.Date;

public class NhanVien {
	private String maNhanVien,tenNhanVien,mail,gioiTinh,diachi, soDienThoai;
	private Date ngaySinh;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String mail, String gioiTinh, String diachi,
			String soDienThoai, Date ngaySinh) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.mail = mail;
		this.gioiTinh = gioiTinh;
		this.diachi = diachi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
	}
	public NhanVien() {
		super();
	}
	
	
}
