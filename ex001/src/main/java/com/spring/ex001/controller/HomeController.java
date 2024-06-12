package com.spring.ex001.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ex001.dto.BookDTO;

import lombok.Value;
import lombok.val;

/**
 * 하나의 파일에 여러개의 url매핑이 가능하다!
 * 파라메터 자동수집
 * 편리한 jsp 매핑
 */
@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	/**
	 * mvc모델
	 * 컨트롤러가 사용자의 요청을 받고 화면을 반환
	 * 
	 * 컨트롤러의 반환타입
	 * String : 경로/파일명 
	 * 			요청 url과 반환되는 페이지가 다른경우 
	 * 			로그인-> 로그인성공, 로그인실패
	 * 			글등록 -> 등록성공, 등록실패
	 * /web-inf/views/파일명.jsp
	 * 
	 * 매개변수에 객체를 지정하면 전달된 이름에 맞게 매핑해서 데이터를 자동으로 수집 해줍니다.
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value="/bookListA")
	public String test01(HttpServletRequest req, BookDTO dto, Model model) throws IOException{
		System.out.println("req.title : " + req.getParameter("title"));
		System.out.println("요청정보=============");
		System.out.println(dto.getTitle());
		System.out.println(dto.getAuthor());
		//System.out.println(dto.getAge());
		//System.out.println(dto.getList());
		
		// 내장객체의 영역에 저장
		// request.setAttribute와 같은 역할
		model.addAttribute("dto", dto);
		
		// jsp화면을 서비스
		// 경로및 파일이름을 반환 -> viewresolver에 의해서 경로및 확장자가 붙어서 파일을 연결
		
		// redirect: 를 붙여주면 redirect(요청정보를 공유하지않고, 페이지주소도 변경)
		// forward: 를 붙여주면 forward (기본값)
		return "book/bookList";
	}
	
	/**
	 * 반환 타입이 없는경우, 요청url을 이용하여 경로를 생성
	 * web-inf폴더는 직접 접근이 불가능 하므로 
	 * 
	 * 등록화면, 로그인화면등 서블릿 로직이 필요하지 않은경우 void를 반환타입으로 만들어 줄 수 있다
	 */
	@GetMapping(value="/book/bookList")
	public void test02() {
		
	}
	
	
	
	
	
}




