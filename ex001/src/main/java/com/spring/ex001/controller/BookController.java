package com.spring.ex001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.ex001.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping(value = "/bookList")
	public String getBookList(Model model) {
		model.addAttribute("list",service.getBookList());
		service.getBookList();
		return "book/bookList";
	}
}
