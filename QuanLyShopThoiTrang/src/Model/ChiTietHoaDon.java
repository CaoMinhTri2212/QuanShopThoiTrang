package Model;

public class ChiTietHoaDon {
    private String maHD;
    private String maSP;
    private int soLuong;
    private double giaBan;
    private double tongTien;

   
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHD, String maSP, int soLuong, double giaBan, double tongTien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tongTien = tongTien;
    }

    // Getters and setters
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    // Override toString() method for easy printing
    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maHD='" + maHD + '\'' +
                ", maSP='" + maSP + '\'' +
                ", soLuong=" + soLuong +
                ", giaBan=" + giaBan +
                ", tongTien=" + tongTien +
                '}';
    }
}

