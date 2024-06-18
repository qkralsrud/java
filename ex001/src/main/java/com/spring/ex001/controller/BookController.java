package com.spring.ex001.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oreilly.servlet.MultipartRequest;
import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.service.BookService;

import oracle.jdbc.proxy.annotation.Post;

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
	
	// 화면이동
	@GetMapping("/bookReg")
	public String bookReg() {
		return "/book/bookRegister";
	}
	
	// 등록처리
	@PostMapping("/bookRegAction")
	public String bookRegAction(HttpServletRequest request) {
		
		String saveDir = "c:\\upload";
		int maxSize = 1024 * 1000; //1MB
		String encoding = "UTF-8";
		
		try {
			MultipartRequest mr= new MultipartRequest(request, saveDir, maxSize, encoding);
			String fileName = mr.getFilesystemName("uploadFile");
			System.out.println(fileName);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 메세지 처리후 화면 이동
		return "/bookList";
	}
	
}