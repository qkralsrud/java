package com.human.service;

import com.human.dao.BookDAO;

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
			int resUpdateRentYn = dao.updateRentYN(no, "Y");
			// rent insert (rentno, no, id, sysdate);
			int resInsertRent = dao.insertRent(id, no);
			
			
		} else {
			System.out.println("대여가능한 상태가 아닙니다.");
		}
		return res;
	}
}
