package com.human.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.human.dto.MemberDTO;
import com.human.util.ConnectionUtil;

public class MemberDao {
	
							//MemberDTO 데이터를 주고받는 역할 
	public MemberDTO login(MemberDTO memberDTO) {
		MemberDTO dto = null;
		String sql = "select * from member where id=? and pw=?";
		Connection con = ConnectionUtil.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPw());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				dto = new MemberDTO(id, pw, name);
			}
						
			ConnectionUtil.close(con,pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dto;
		
	}
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		MemberDTO dto = new MemberDTO("momo", "1234", "");
		System.out.println(dao.login(dto));
	}
	
	
	
	
	
	
	
	
	
	
}
