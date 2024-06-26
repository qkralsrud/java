package com.human.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/member/memberLogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자 로그인 ===");
		System.out.println(request.getParameter("id")); 
		System.out.println(request.getParameter("pw"));
		
		//id: momo, pw: 1234 이면 로그인 성공 > /member/main.jsp 이동 
		//id가 출력될 수 있도록 처리 
		if("momo".equals(request.getParameter("id"))
				&&"1234".equals(request.getParameter("pw"))) {
			request.setAttribute("id",request.getParameter("id"));
			request.getRequestDispatcher("/member/main.jsp").forward(request, response);
			
		}else { 
		//로그인 실패 > /member/login.jsp 이동
		//msg를 출력 할수있도록 처리 
			request.setAttribute("msg",request.getParameter("id"));
			request.getRequestDispatcher("/member/login.jsp").forward(request, response);
			
			
		}
		
		
		
		
		
		
		
	}

}
