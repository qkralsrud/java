package com.spring.ex001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex001.dto.BookDTO;
import com.spring.ex001.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper mapper;
	
	public List<BookDTO> getBookList(){
		
		
		return mapper.getBookList();
	}
}
