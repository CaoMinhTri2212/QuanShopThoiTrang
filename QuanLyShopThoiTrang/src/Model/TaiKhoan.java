package Model;

public class TaiKhoan {
	String tentkString;
	String matkhauString;
	public String getTentkString() {
		return tentkString;
	}
	public void setTentkString(String tentkString) {
		this.tentkString = tentkString;
	}
	public String getMatkhauString() {
		return matkhauString;
	}
	public void setMatkhauString(String matkhauString) {
		this.matkhauString = matkhauString;
	}
	public TaiKhoan(String tentkString, String matkhauString) {
		super();
		this.tentkString = tentkString;
		this.matkhauString = matkhauString;
	}
	public TaiKhoan() {
		super();
	}
	

}
