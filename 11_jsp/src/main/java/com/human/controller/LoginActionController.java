package com.human.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dto.MemberDTO;
import com.human.service.MemberService;

/**
 * Servlet implementation class LoginActionController
 */
@WebServlet("/member/loginAction")
public class LoginActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginActionController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드가 실행되었어요");
		//사용자의 요청정보 수집 
		System.out.println("id : " + request.getParameter("id"));
		System.out.println("pw : " + request.getParameter("pw"));
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().append("Served at : ").append(request.getContextPath());
		response.getWriter().append("<br> id : " + request.getParameter("id"));
		response.getWriter().append("<br> pw : " + request.getParameter("pw"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메서드가 실행되었어요");
		//사용자의 요청정보 수집 
		System.out.println("id : " + request.getParameter("id"));
		System.out.println("pw : " + request.getParameter("pw"));
		
		
		
		//로그인 처리 - 사용자로부터 입력받은 id pw가 일치하는 사용자가 있으면 사용자 정보를 받아온다.
		MemberService service = new MemberService();
		
		//파라메터 수집
		MemberDTO dto = new MemberDTO(request.getParameter("id"),request.getParameter("pw"),"");
		System.out.println("dto : " + dto);
		boolean res = service.login(dto);
		System.out.println("res : " + res);
		
		if(res) {
			//로그인 성공
			request.getRequestDispatcher("/loginAction.jsp").forward(request, response);
		}else {
			//로그인 실패
			request.setAttribute("msg","아이디 비번 확인 해주세요");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		//jsp화면을 전환 하는 두가지 방법
		
		//1. redirect
		//파라메터가 공유되지 않는다
		//주소표시줄의 요청주소가 변경된다.
		//response.sendRedirect("/loginAction.jsp");
		
		//2. forward
		//하나의 요청으로 파라메터가 공유된다.
		//주소표시줄의 요청주소가 변경되지 않는다.
		request.getRequestDispatcher("/loginAction.jsp").forward(request, response);
		
		
	}

}
 


















































































