package com.spring.ex001.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService service;
	
	/**
	 * 반환타입이 있는경우 
	 * WEB-INF/views/반환값.jsp
	 * @return
	 */
	@GetMapping(value = "/login")
	public String login1() {
		return "login/login";
	}
	/**
	 * 반환타입이 없는경우
	 * WEB-INF/views/요청주소.jsp
	 */
	@GetMapping(value = "/login/login")
	public void login() {
	}
	
	// 로그인 버튼이 클릭되면 실행할 메서드를 정의 하세요
	// 사용자로부터 입력받은 아이디, 비밀번호를 수집 - MemberDTO
	// id, pw 출력
	// list 페이지로 이동
	@PostMapping(value="/loginAction")
	public String loginAction(MemberDTO paramMember
								, HttpSession session
								, Model model
								, RedirectAttributes rttr) {
		
		System.out.println(paramMember.getId());
		System.out.println(paramMember.getPw());
		
		// 서비스 - 사용자로부터 입력받은 사용자의 id/pw에 일치하는 회원이 있으면 member객체를 생성하여 반환
		MemberDTO member = service.login(paramMember);
		
		if(member == null) {
			// 로그인실패 - 로그인페이지로 이동후 메세지 출력
			model.addAttribute("msg", "id/pw를 확인해주세요.");
			return "login/login";
		} else {
			// 로그인
			// request영역에 저장된 경우, redirect시에 데이터가 공유되지 않는다!!!!!
			model.addAttribute("modelId", member.getId());
			// 내부적으로 세션객체에 담아서 한번 사용하고 폐기
			rttr.addFlashAttribute("rttrId", member.getId());
			
			// 로그인성공 - 세션에 저장후 리스트로 이동
			session.setAttribute("id", member.getId());
			session.setAttribute("memberDto", member);
			return "redirect:/bookList";
		}
	}
	
	// /logout 호출되면 로그아웃 처리후 로그인페이지로 전환
	
}














