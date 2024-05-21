package com.human;

import java.util.ArrayList;
import java.util.List;

import com.human.dao.BookDAO;
import com.human.vo.BookVO;

public class Library {
	private String title = "영등포 도서관";
	
	// 도서목록
	private List<BookVO> list = new ArrayList<BookVO>();
	
	// 데이터베이스로 부터 도서정보를 조회, 입력, 수정, 삭제
	private BookDAO bookDao = new BookDAO();
	
	// 생성자를 이용하여 도서목록을 초기화
	public Library(String title) {
		if(title != null) this.title = title; 
		list = bookDao.getList();
	}
	
	// 도서 등록
	public void insertBook(BookVO vo) {
		int res = bookDao.insertBook(vo);
		
		if(res > 0) {
			System.out.println(res + "건이 등록 되었습니다.");
			// 리스트 초기화
			list = bookDao.getList();
		} else {
			System.out.println("등록실패, 관리자에게 문의 해주세요.");
		}
	}
	
	// 도서 삭제
	public void deleteBook(int no) {
		int res = bookDao.deleteBook(no);
		if(res>0) {
			System.out.println(res + "건 삭제 되었습니다.");
			list = bookDao.getList();
		} else {
			System.out.println("처리실패, 관리자에게 문의 해주세요.");
		}
	}
	
	//도서 수정
	public void updateBook(BookVO vo) {
		int res = bookDao.updateBook(vo);
		if(res>0) {
			System.out.println(res + "건 수정 되었습니다.");
			list = bookDao.getList();
		}else {
			System.out.println("처리실패, 관리자에게 문의 해주세요.");
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for(BookVO vo : list) {
			str += vo.toString() + "\n";
		}
		return str;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
