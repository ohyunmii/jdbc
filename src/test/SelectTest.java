package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//	1. Loading JDBC Driver(Mysql)
			Class.forName("com.mysql.jdbc.Driver");
			
			//	2. Connect 
			String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//	3. Create Statement Object
			stmt = conn.createStatement();
			
			//	4. Execute SQL commands
			String sql = "select no, first_name, last_name, email from emaillist";
			rs = stmt.executeQuery(sql);
			
			//	5. Show Results
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				System.out.println(no + ":" + firstName +":" + lastName +":"+ email);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC driver: " + e);
		} catch(SQLException e){
			System.out.println("Error: "+ e);
		} finally {
			// remove resources 
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
