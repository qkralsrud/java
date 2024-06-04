package com.human.service;

import java.util.List;

import com.human.dao.BookDAO;
import com.human.dto.BookDTO;
import com.human.dto.CriteriaDTO;

public class BookService {

	BookDAO bookDao = new BookDAO();
	
	public List<BookDTO> getBookList(CriteriaDTO cri) {
		
		return bookDao.getBookList(cri);
	}

	public int getTotalCnt() {
		
		return bookDao.getTotalCnt();
	}

}
