package com.spring.ex001.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex001.dto.BookDTO;
import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.PageDto;
import com.spring.ex001.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper mapper;
	
	@Autowired
	PageDto pageDto;
	
	public Map<String, Object> getBookList(CriteriaDTO cri){
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 리스트 조회
		List<BookDTO> list = mapper.getBookList(cri);
		// 총건수 조회
		int totalCnt = mapper.getTotalCnt();
		// pageDto세팅
		pageDto.setPageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		
		// map에 담아서 반환
		map.put("list", list);
		map.put("pageDto", pageDto);
		
		return map;
	}
}









