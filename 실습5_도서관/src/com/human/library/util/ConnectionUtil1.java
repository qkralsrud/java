package com.human.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.human.library.BookVO;

public class ConnectionUtil1 {
	
	//접속정보 ( Connection 객체를 생성하기 위해서 필요한 정보)
	//ip,port,sid,id,pw
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String id = "user01";
	static String pw ="1234";
	
	public static void main(String[] args) {
		
	}
}
		
		
		
		
		
		
		

