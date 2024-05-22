package com.human.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.human.util.ConnectionUtil;
import com.human.vo.MemberVO;

/**
 * 사용자 등록, 수정, 삭제, 조회
 */
public class MemberDAO {
	// 멤버테이블에 데이터를 입력하고 입력 결과를 반환
	public int insertMember(MemberVO vo) {
		int res = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, sysdate, NULL)";
			// 동적쿼리를 이용하는경우
			// ?에 변수를 대입해서 쿼리를 실행
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?의 순서에 맞게 변수를 세팅
			// 문자열인 경우 setString(?순서, 입력할값)
			// 숫자인 경우 setInt(?순서, 입력할값)
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());			
			pstmt.setString(3, vo.getName());
			/*
			String admin_yn="N";
			if(vo.isAdmin()) {
				admin_yn="Y";
			}
			*/
			pstmt.setString(4, vo.getAdmin_yn());
			
			// DML 문장을 실행하고 처리결과 몇건이 처리되었는지 반환 받는다
			res = pstmt.executeUpdate();
			
			ConnectionUtil.close(con, pstmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		System.out.println( dao.login("momo", "momo123") );
		
		/*
		System.out.println(dao.checkId("momo1"));
		
		MemberVO vo = new MemberVO("id1", "pw1", "홍길동", true, "Y", null , null);
		int res = dao.insertMember(vo);
		
		System.out.println(res + "건 처리 되었어요!");
		*/
	}

	/**
	 * 아이디 중복체크
	 * @param id
	 * @return 사용불가 : false, 사용가능 : true
	 */
	public boolean checkId(String id) {
		boolean res = false;
		// 아이디가 존재하는지 쿼리를 통해 확인후 결과를 반환
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id from member where id='"+id+"'");
			if(!rs.next()) {
				res = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 사용자로부터 전달받은 id, pw를 이용하여 데이터베이스로부터 사용자를 조회
	 * 
	 * @param id
	 * @param pw
	 * @return memberVO : 로그인한 사용자의 정보
	 */
	public MemberVO login(String id, String pw) {
		MemberVO vo = null;
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from member where id=? and pw=?"; 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?의 갯수만큼 파라메터 세팅
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			// 쿼리 실행
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id, pw, rs.getString("name"), rs.getString("admin_yn")
									, rs.getString("reg_date"), rs.getString("udt_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	
	
	
	
	
	
	
	
	
	
	
}
