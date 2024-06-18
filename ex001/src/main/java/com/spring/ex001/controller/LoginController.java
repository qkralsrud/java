package com.spring.ex001.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.service.MemberService;
import com.spring.ex001.util.CookieManager;

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
	public String login1(@CookieValue(name="id", required = false) String saveCookieId
							, Model model) {
		// 내장객체의 영역에 저장
		model.addAttribute("saveCookieId", saveCookieId);
		return "login/login";
	}
	
	/**
	 * 반환타입이 없는경우
	 * WEB-INF/views/요청주소.jsp
	 */
	@GetMapping(value = "/login/login")
	public void login(@CookieValue(name="id", required = false) String saveCookieId
						, Model model) {
		// 내장객체의 영역에 저장
		model.addAttribute("saveCookieId", saveCookieId);
	}
	
	// 로그인 버튼이 클릭되면 실행할 메서드를 정의 하세요
	// 사용자로부터 입력받은 아이디, 비밀번호를 수집 - MemberDTO
	// id, pw 출력
	// list 페이지로 이동
	@PostMapping(value="/loginAction")
	public String loginAction(MemberDTO paramMember
								, HttpSession session
								, Model model
								, RedirectAttributes rttr
								// 서버로 전달된 파라메터를 수집, 필수값이 아닌경우 required=false를 넣어주어야함
								// 여러개의 속성이 나열될 경우 value속성도 입력 해야 함
								, @RequestParam(value="chkSaveId", required=false) String chkSaveId
								, HttpServletResponse response) {
		
		// filter를 통해서 요청객체의 문자인코딩을 지정
		//request.setCharacterEncoding("utf-8");
		
		System.out.println("chkSaveId : " + chkSaveId);
		// 체크박스가 체크 되었다면
		if(chkSaveId != null){
			// 쿠키에 아이디를 저장
			// 쿠키를 생성후 응답객체에 추가하는 메서드
			CookieManager.makeCookie(response, "id", paramMember.getId(), 60*60*24*7);
		} else {
			CookieManager.deleteCookie(response, "id");
		}
		System.out.println(paramMember.getId());
		System.out.println(paramMember.getPw());
		
		// 서비스 - 사용자로부터 입력받은 사용자의 id/pw에 일치하는 회원이 있으면 member객체를 생성하여 반환
		MemberDTO member = service.login(paramMember);
		
		if(member == null) {
			// 로그인실패 - 로그인페이지로 이동후 메세지 출력
			// model.addAttribute("msg", "id/pw를 확인해주세요.");
			// 리다이렉트시 요청영역이 공유되지 않으므로 리다이렉트시 데이터를 유지하기 위해서 
			// 잠시 세션영역에 보관  
			rttr.addFlashAttribute("msg", "id/pw를 확인해주세요.");
			// 로그인 페이지로 리다이렉트(서블릿을 호출)
			return "redirect:/login";
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
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		// 세션만료후 로그인 페이지로 리다이렉트
		return "redirect:/login";
	}
	
	@GetMapping(value = "/signup")
	public String signup(HttpSession session) {
		return "/login/signup";
	}
	
	@GetMapping("/signupAction")
	public String signupAction(MemberDTO member, Model model) {
		
		int res = service.regMember(member);
		
		// 회원가입 처리
		if(res > 0) {
			// 회원이 성공이면
			model.addAttribute("msg", "회원가입 성공!! 로그인후 이용이 가능 합니다.");
			model.addAttribute("url", "/login");			
		} else {
			// 회원가입이 실패
			model.addAttribute("msg", "회원가입중 예외사항이 발생 하였습니다. 관리자에게 문의 하여주세요.");
		}
		// 메세지를 출력후 지정된 url로 이동(url이 없으면 뒤로가기)
		return "/common/msgBox";
	}
}