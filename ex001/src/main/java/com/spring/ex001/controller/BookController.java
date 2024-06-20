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
	/**
	 * 상세 페이지에서 리스트 페이지를 요청할때, pageNo를 전달 하므로써 원하는 페이지를 볼 수 있다!
	 * 
	 * cri : 
	 * 	1. 페이지번호와 페이지당 게시물수	- 페이징 처리 
	 *  2. 검색어 검색필드				- 검색
	 * @param cri
	 * @param model
	 * @return
	 */
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
	//@RequestParam을 이용할 경우, 필수가 아닌경우 required = false를 넣어주어야 합니다.
	// int타입으로 받을시, 값이 입력되지 않은 경우 nullpointException이 발생 하므로 Integer로 받아주세요!
	public String detailBook(@RequestParam(value = "no", required = false) Integer no, Model model) {
		
		System.out.println(no);
		// 도서번호가 입력되지 않은경우
		if(no == null) {
			// 메세지를 출력하고 뒤로가기
			model.addAttribute("msg", "존재하지 않는 도서 입니다.");
			return "/common/msgBox";
		}
		
		// 화면수정 - 제목을 클릭하면 /detailBook을 요청
		// /book/detailBook.jsp를 반환
		// 도서정보를 조회
		// no를 받아서 출력
		// 1. bookDto조회
		// 									2. 파일정보 조회 - 리스트
		// mapper인터페이스에 메서드 추가
		// mapper xml에 쿼리 추가
		Map<String, Object> map = service.detailBook(no);
 
		model.addAttribute("map", map);
		
		return "/book/detailBook";
		
	}
	
	@GetMapping("/delBook")
	public String delBook(@RequestParam("pageNo") int pageNo
							,@RequestParam("no") int no
							, Model model) {
		// 도서 번호에 해당하는 도서의 정보를 삭제
		int res = service.delBook(no);

		if(res>0) {
			// 삭제성공
			model.addAttribute("msg", "삭제 되었습니다.");
			// 페이지정보를 유지하기 위해서 pageNo를 전달
			model.addAttribute("url", "/bookList?pageNo="+pageNo);
		} else {
			// 삭제실패
			model.addAttribute("msg", "삭제 중 예외사항이 발생 하였습니다.");
		}
		return "/common/msgBox";
	}
	
}




