package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class sqlconnect {
	
	private static Connection con;
	public static Connection getCon() {
		return con;
	}
	
	public static void setCon(Connection con) {
		sqlconnect.con = con;
	}

	public sqlconnect(String connectionString) {
        try {
            con = DriverManager.getConnection(connectionString);
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

