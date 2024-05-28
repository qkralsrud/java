package com.human.service;

import java.util.List;

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
	
	public List<BookDTO> selectBookList(){
		return dao.selectBookList();
	}

	public int bookInsert(BookDTO book) {
		return dao.insert(book);
	}

	public int bookDelete(String no) {
		int no_int = 0;
		if(no != null) {
			try{
				no_int = Integer.parseInt(no);	
				return dao.delete(no_int);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return no_int;
	}

	public int bookUpdate(BookDTO book) {
		if(book.getNo() != 0 ) {			
			return dao.update(book);
		} else {
			return 0;
		}
	}

}
