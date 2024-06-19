package com.spring.ex001.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		// 출판사목록
		return "/book/bookRegister";
	}
	
	// 등록처리
	@PostMapping("/bookRegAction")
	public String bookRegAction(HttpServletRequest request) {
		
		Map<String, Object> map = service.bookReg(request);
				
		// 메세지 처리후 화면 이동
		// redirect 서블릿 호출 : 새로운 요청
		// forward인 경우 - 요청메서드가 같아야 함
		return "redirect:/bookList";
	}
	
	// 상세화면
	@GetMapping("/detailBook")
	public String detailBook(@RequestParam("no") int no, Model model) {
		System.out.println(no);
		// 화면수정 - 제목을 클릭하면 /detailBook을 요청
		// /book/detailBook.jsp를 반환
		// 도서정보를 조회
		// no를 받아서 출력
		// 1. bookDto조회
		// 									2. 파일정보 조회 - 리스트
		// mapper인터페이스에 메서드 추가
		// mapper xml에 쿼리 추가 
		return "/book/detailBook";
		
	}
	
}












