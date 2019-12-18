package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.EmailListVo;

public class EmailListDao {
	public static void main(String[] args) {
		
	}
	public List<EmailListVo> findAll() {
		List<EmailListVo> voList = new ArrayList<>();
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
				
				EmailListVo vo = new EmailListVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				voList.add(vo);
				
				System.out.println(no + ". First name: " + firstName +"\t Last name: " + lastName +"\t Email:"+ email);
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
				e.printStackTrace();
			}
		}
		
		return voList;
		
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
