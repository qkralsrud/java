package com.human.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.human.util.ConnectionUtil;
import com.human.vo.BookVO;

/**
 * 도서관련 테이블을 조작
 * book 테이블이 가지고 있는 정보를 조회, 입력, 수정, 삭제, 대여, 반납
 */
public class BookDAO {
	
	// 접근제한자 반환타입 이름(매개변수타입 매개변수이름){}
	
	/**
	 * 도서목록을 반환 합니다.
	 * @return
	 */
	public List<BookVO> getList(){
		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			
			while(rs.next()) {
				BookVO vo = new BookVO(rs.getInt("no")
										, rs.getString(2)
										, rs.getString(3)
										, rs.getString(4)
										, rs.getString(5)
										, rs.getString(6));
				list.add(vo);
			}
			
			ConnectionUtil.close(con, stmt, rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * DB에 접근하여 도서를 추가 합니다
	 * @param vo
	 * @return
	 */
	public int insertBook(BookVO vo) {
		int res = 0;
		try {
			Connection con = ConnectionUtil.getConnection();

			/*
			String sql = "INSERT INTO BOOK \r\n"
					+ "        VALUES (SEQ_BOOK_NO.NEXTVAL, '"
					+					vo.getTitle()+"', '"+vo.getAuthor()+"', '"+vo.getPublisher()+"', "
					+					Integer.parseInt(vo.getPrice())+", '"+vo.getPub_date()+"')";
			Statement stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
			*/
			String sql = "INSERT INTO BOOK VALUES (SEQ_BOOK_NO.NEXTVAL, ?, ?, ?, ?, ?)";
			// Statement와 prepareStatement의 가장 큰 차이점은 동적인 쿼리를 생성하는 부분
			// 쿼리문장을 어디서 세팅 해주는지가 다름!!!!!!!
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setString(3, vo.getPublisher());
			pstmt.setInt(4, Integer.parseInt(vo.getPrice()));
			pstmt.setString(5, vo.getPub_date());
			
			res = pstmt.executeUpdate();
			
			ConnectionUtil.close(con, pstmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int deleteBook(int no) {
		int res = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement stmt = con.createStatement();
			res = stmt.executeUpdate("delete book where no = " + no);
			ConnectionUtil.close(con, stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int updateBook(BookVO vo) {
		int res = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
						"UPDATE  BOOK \r\n"
						+ "SET     TITLE = ?, AUTHOR = ?, PUBLISHER = ?, PRICE = ?, PUB_DATE =?\r\n"
						+ "WHERE   NO = ?");
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setString(3, vo.getPublisher());
			pstmt.setInt(4, Integer.parseInt(vo.getPrice()));
			pstmt.setString(5, vo.getPub_date());
			pstmt.setInt(6, vo.getNo());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO(0, "타이틀1", "작가1", "중앙", "15000", "2020-10-25");
		int res = dao.insertBook(vo);
		System.out.println(res + "건 처리 되었습니다.");
		
	}
}






