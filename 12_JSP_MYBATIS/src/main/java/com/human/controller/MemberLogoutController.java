package com.human.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutController
 */
@WebServlet("/MemberLogoutController")
public class MemberLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// session.removeAttribute("")
		// 세션을 만료시켜줍니다 - 세션아이디를 재발급 받아서 사용
		session.invalidate();
		response.sendRedirect("/jsp/04session/LoginMain.jsp");
	}

}
