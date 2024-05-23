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
			String sql = "INSERT INTO BOOK (NO,TITLE,AUTHOR,PUBLISHER,PRICE,PUB_DATE)"
						+ " VALUES (SEQ_BOOK_NO.NEXTVAL, ?, ?, ?, ?, ?)";
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
		//System.out.println( dao.updateRentYN(1, "Y") );
		
//		BookVO vo = new BookVO(0, "타이틀1", "작가1", "중앙", "15000", "2020-10-25");
//		int res = dao.insertBook(vo);
//		System.out.println(res + "건 처리 되었습니다.");
		
	}

	public String getRentYn(int no) {
		String res = null;
		
		try {
			//Connection : DB연결
			Connection con = ConnectionUtil.getConnection();
			// Sql : 실행할 쿼리문장 작성
			String sql = "select rent_yn from book where no=?";
			//PreparedStatement : 쿼리르 실행하기 위한 객체 생성
			PreparedStatement pstmt = con.prepareStatement(sql);
			//파라메터 세팅 : 동적 쿼리 문장 완성
			pstmt.setInt(1, no);
			//쿼리 실행 : 실행후 결과집합을 반환
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int updateRentYN(int no, String rentYN, int rentNo, Connection con) {
		int res = 0;
		// rentyn컬럼을 y로 업데이트
		
		// 트랜젝션 처리를 위해 외부에서 Connection을 받아 옵니다.
		//Connection con = ConnectionUtil.getConnection();
		String sql = "update book set rent_yn=?, rent_no=? where no=?";
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rentYN);
			pstmt.setInt(2, rentNo);
			pstmt.setInt(3, no);
			
			res = pstmt.executeUpdate();

			
			/* 트랜젝션 처리를 위해 사용되는 메서드
			con.setAutoCommit(false);
			con.commit();
			con.rollback();
			*/

			//ConnectionUtil.close(con, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		return res;
	}
	
	// 쿼리에 오류를 발생 시켜서 테스트를 진행
	public int insertRent(String id, int no, int rentno, Connection con) {
		int res = 0;
		String sql = "insert into rent (rentno, no, id, rent_date) \r\n"
						+ "        values (?, ?, ?, sysdate)";
		
		//Connection con = ConnectionUtil.getConnection();
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rentno);
			pstmt.setInt(2, no);
			pstmt.setString(3, id);
			
			res = pstmt.executeUpdate();
			
			//ConnectionUtil.close(con, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 새로운 대여번호를 생성하여 반환 합니다.
	 * @return
	 */
	public int selectRentNo() {
		int rentNo = 0;
		Connection con = ConnectionUtil.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select rent_rentno.nextval from dual");
			
			if(rs.next()) {
				rentNo = rs.getInt(1);
			}
			
			ConnectionUtil.close(con, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rentNo;
	}

	public int updateReturnDate(int no, Connection con) {
		int res = 0;
		
		try {
			String sql = "UPDATE RENT SET RETURN_DATE = SYSDATE \r\n"
					+ "    WHERE RENTNO = (SELECT RENT_NO FROM BOOK WHERE NO = ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}






