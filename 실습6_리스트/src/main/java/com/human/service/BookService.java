package com.human.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.human.dao.BookDAO;
import com.human.dto.BookDTO;
import com.human.dto.CriteriaDTO;
import com.human.dto.PageDto;

public class BookService {

	BookDAO bookDao = new BookDAO();
	
	/**
	 * 비지니스 로직 처리
	 * @param cri
	 * @return
	 */
	public Map<String, Object> getBookList(CriteriaDTO cri) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 1. 리스트 조회
		List<BookDTO> list = bookDao.getBookList(cri);
		// 2. 총건수 조회
		int totalCnt = bookDao.getTotalCnt();
		// 3. PageDto생성
		PageDto pageDto = new PageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		// 4. Map에 리스트, pageDto, 총건수 담아주기
		map.put("list", list);
		map.put("pageDto", pageDto);
		map.put("totalCnt", totalCnt);
		
		return map;
	}

	public int getTotalCnt() {
		
		return bookDao.getTotalCnt();
	}

}
