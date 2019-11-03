package com.revature.bankingapp.connectionUtill;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class ConnectionUtil {
		public static Connection getConnection() {

			String url = "jdbc:mysql://localhost:3306/bankingapp?useSSL=false";
			String password = "root";
			String username = "root";
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to get DB Connection" + e);
			}
			return con;
		}

		public static void close(Connection con, PreparedStatement pst, ResultSet rs) {

			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			}

			catch (Exception e) {
			}
			finally {
		}
		
		}}
