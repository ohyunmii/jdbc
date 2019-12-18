package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	boolean result = false;

	public static void main(String[] args) {
		Boolean result = update(8L, "He", "Is", "ishe@gmail.com");
		System.out.println(result);
	}
	
	
	@SuppressWarnings("finally")
	public static Boolean update(long number, String firstName, String lastName, String email) {
		Boolean result=false;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//	1. Loading JDBC Driver(Mysql)
			Class.forName("com.mysql.jdbc.Driver");
			
			//	2. Connect 
			String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//	3. Create Statement Object
			stmt = conn.createStatement();
			
			//	4. Execute SQL Statment
			String sql = "update emaillist set first_name='"+firstName+"',last_name='"+ lastName+"',email='"+email+"' where no ="+number;
			
			int count = stmt.executeUpdate(sql);
			result = (count==1);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC Driver: " + e);
		} catch(SQLException e){
			System.out.println("Error: "+ e);
		} finally {
			// remove resources 
			try {
				if(conn!=null) conn.close();
			} catch (final SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	
	}


}
