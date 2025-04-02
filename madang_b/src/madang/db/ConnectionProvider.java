package madang.db;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {
	private static String driver = "oracle.jdbc.driver.OravleDriver";
	private static String url = "jdbc:oracle:thin:@172.30.1.80:1521:XE";
	private static String user = "c##madang";
	private static String pw = "madang";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
			
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
		
		return conn;
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
	}
	public static void close(Connection conn, Statement stmt) {
		try {

			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}
	}
}
