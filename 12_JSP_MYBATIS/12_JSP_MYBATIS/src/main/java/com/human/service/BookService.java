package com.human.service;

import com.human.dao.BookDao;
import com.human.dto.BookDTO;

public class BookService {
	BookDao dao = new BookDao();
	
	public BookDTO selectBook(String no) {
		
		// no가 null이 아니면 숫자로 변환 하여 조회
		if(no != null) {
			int no_int = Integer.parseInt(no);
			return dao.selectBook(no_int);			
		} else {
			return null;
		}
	}

}
