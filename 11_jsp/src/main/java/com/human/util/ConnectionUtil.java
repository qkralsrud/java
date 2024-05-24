package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	
	static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	static final String ID = "user01";
	static final String PW = "1234";
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, ID, PW);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed()) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			// 커넥션 생성
			Connection con = ConnectionUtil.getConnection();
			
			// 쿼리를 질의하고 결과를 받아오는 객체
			Statement stmt = con.createStatement();
			
			// 쿼리 질의결과집합을 받아 옵니다
			ResultSet rs = stmt.executeQuery("select * from book");
			
			// 반복문을 이용해서 결과집합을 모두 출력
			while(rs.next()) {
				System.out.println( rs.getString(1) );
				System.out.println( rs.getString(2) );
				System.out.println( rs.getString(3) );
				System.out.println( rs.getString(4) );
				System.out.println( rs.getString(5) );
			}
			
			ConnectionUtil.close(con);
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt != null && !pstmt.isClosed()) pstmt.close();
			if(con != null && !con.isClosed()) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.close();
			if(stmt != null && !stmt.isClosed()) stmt.close();
			if(con != null && !con.isClosed()) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	public static void close(Connection con, Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
			if(con != null && !con.isClosed()) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

}
