package com.human.ex_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.util.CookieManager;

/**
 * 요청 url
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 요청방식 get
	 * form태그의 method속성에 정의된 값
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 실행");
		//로그아웃 처리 왜냐면 main에서 로그인 후의 form에 method를 따로 안정해서 
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/jsp/session/ex/main.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user_id");
		String chkbox = request.getParameter("chkbox");
		System.out.println("chkbox : " + chkbox);
		
		if("1".equals(chkbox)) {
			System.out.println("쿠키생성");
			// 쿠키생성
			Cookie cookie = new Cookie("id", userId);
			//경로 지정
			cookie.setPath("/");
			//유효기간 지정
			cookie.setMaxAge(60*60*24*7);
			
			// 응답객체에 추가
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("id", userId);
			//경로 지정
			cookie.setPath("/");
			//유효기간 지정
			cookie.setMaxAge(0);
			// 응답객체에 추가
			response.addCookie(cookie);
		}
		
		if("momo".equals(userId)) {
			//로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			//경로 찾아가기 
			response.sendRedirect("/jsp/session/ex/main.jsp");
		}else {
			//로그인 실패
			//jsp는 webapp폴더를 기준으로 경로를 작성해주면 됩니다.
			request.getRequestDispatcher("/jsp/session/ex/main.jsp").forward(request, response);
		}
		
		
		
		System.out.println("doPost 실행");
		
	}

}
