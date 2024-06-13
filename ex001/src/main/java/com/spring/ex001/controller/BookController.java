package com.spring.ex001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping(value = "/bookList")
	public String getBookList(CriteriaDTO cri, Model model) {
		// pageNo를 출력하세요
		System.out.println("pageNo : " + cri.getPageNo());

		// 서비스를 통해 도서목록과 PageDto객체를 반환
		model.addAttribute("map", service.getBookList(cri));
		
		return "book/bookList";
	}

	
}
