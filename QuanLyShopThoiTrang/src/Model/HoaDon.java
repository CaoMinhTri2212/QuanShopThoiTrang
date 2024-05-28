package Model;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class HoaDon {
	int mahd;int manv; int makh; int makm; int thanhtien;
	Date ngaylap;
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public int getMakm() {
		return makm;
	}
	public void setMakm(int makm) {
		this.makm = makm;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgaylap() {
		return ngaylap;
	}
	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}
	public HoaDon(int mahd, int manv, int makh, int makm, int thanhtien, Date ngaylap) {
		super();
		this.mahd = mahd;
		this.manv = manv;
		this.makh = makh;
		this.makm = makm;
		this.thanhtien = thanhtien;
		this.ngaylap = ngaylap;
	}
	public HoaDon() {
		super();
	}
	

}
