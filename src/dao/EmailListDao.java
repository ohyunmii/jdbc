package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import vo.EmailListVo;

public class EmailListDao {
	public static void main(String[] args) {
		
	}

	// remove static to make this an instance
	@SuppressWarnings("finally")
	public Boolean insert(EmailListVo vo) {
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
			String sql = "insert into emaillist values(null,'"+vo.getFirstName()+"','"+ vo.getLastName()+"','"+vo.getEmail()+"')";
			
			int count = stmt.executeUpdate(sql);
			result = (count==1);
			
			System.out.println("ok!");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC Driver: " + e);
		} catch(SQLException e){
			System.out.println("Error: "+ e);
		} finally {
			// remove resources 
			try {
				if(conn!=null) conn.close();
				if(stmt!=null) stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	
	}

}
