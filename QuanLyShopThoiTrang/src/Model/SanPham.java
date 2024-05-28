package Model;

public class SanPham {
    int maSP;
    String tenSP;
    int kichCo;
    int mau;
    int theLoai;
    String anh;
    int nhaCungCap;
    int soLuong;
    int giaNhap;
    int giaBan;
    int giaBanSi;
    int giaTang;
    String moTa;
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getKichCo() {
		return kichCo;
	}
	public void setKichCo(int kichCo) {
		this.kichCo = kichCo;
	}
	public int getMau() {
		return mau;
	}
	public void setMau(int mau) {
		this.mau = mau;
	}
	public int getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(int theLoai) {
		this.theLoai = theLoai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public int getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(int nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(int giaNhap) {
		this.giaNhap = giaNhap;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public int getGiaBanSi() {
		return giaBanSi;
	}
	public void setGiaBanSi(int giaBanSi) {
		this.giaBanSi = giaBanSi;
	}
	public int getGiaTang() {
		return giaTang;
	}
	public void setGiaTang(int giaTang) {
		this.giaTang = giaTang;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public SanPham(int maSP, String tenSP, int kichCo, int mau, int theLoai, String anh, int nhaCungCap, int soLuong,
			int giaNhap, int giaBan, int giaBanSi, int giaTang, String moTa) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.kichCo = kichCo;
		this.mau = mau;
		this.theLoai = theLoai;
		this.anh = anh;
		this.nhaCungCap = nhaCungCap;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.giaBanSi = giaBanSi;
		this.giaTang = giaTang;
		this.moTa = moTa;
	}
	public SanPham() {
		super();
	}
    
	

   }