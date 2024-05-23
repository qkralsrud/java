package com.human.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.human.dao.BookDAO;
import com.human.util.ConnectionUtil;

public class BookService {
	BookDAO dao = new BookDAO();
	
	public boolean rent(int no, String id) {
		boolean res = false;
		// 도서의 상태를 확인(대여가 가능한 상태인지 확인)
		String rentYN = dao.getRentYn(no);
		// 가능한 상태라면 대여테이블에 등록
		// N: 대여가능, Y:대여중
		if(rentYN == null) {
			System.out.println("도서번호를 확인해주세요.");
		} else if(rentYN.equalsIgnoreCase("N")) {
			// 트랜젝션 처리 : 도서대여처리는 2개의 쿼리문장을 하나의 작업으로 관리 해야 합니다.
			// 커넥션객체를 생성후 파라메터로 전달 한다!!!!!! 
			// 같은 커넥션을 이용!!!!
			// book rentyn = Y
			try {
				Connection con = ConnectionUtil.getConnection();
				// 자동커밋모드인경우, 해당 연결의 모든 SQL문이 개별 트랜젝션으로 실행되므로 AutoCommit(false)을 설정
				con.setAutoCommit(false);
			
				// 1. 테이블에 rent_no컬럼을 추가
				// 2. 시퀀스를 이용하여 새로운 렌트번호를 조회후 변수에 저장
				int rentno = dao.selectRentNo();
				// 3. updateRentYN 작업시 rent_no도 입력 될수 있도록 수정
				
				int resUpdateRentYn = dao.updateRentYN(no, "Y", rentno, con);
				// rent insert (rentno, no, id, sysdate);
				int resInsertRent = dao.insertRent(id, no, rentno, con);
			
				if(resUpdateRentYn > 0 && resInsertRent > 0) {
					con.commit();
				} else {
					con.rollback();
				}
				
				ConnectionUtil.close(con);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("대여가능한 상태가 아닙니다.");
		}
		return res;
	}

	public boolean returnBook(int no) {
		Connection con = ConnectionUtil.getConnection();
		try {
			con.setAutoCommit(false);
			// 도서 대여 테이블의 반납일을 업데이트
			int resUpdateReturnDate = dao.updateReturnDate(no, con);
			// 도서번호를 입력 받아서 rent_yn, rent_no값을 업데이트
			int resUpdateRentYN = dao.updateRentYN(no, "N" , 0, con);
			
			if(resUpdateReturnDate>0 && resUpdateRentYN>0) {
				con.commit();
			} else {
				con.rollback();
			}
			ConnectionUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
