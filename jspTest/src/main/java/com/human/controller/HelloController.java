package com.human.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloController")
public class HelloController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// get방식 요청 - 조회 
	// 주소표시줄에서 주소를 치고 엔터를 누르면
	// 주소표시줄에 데이터를 담아서 이동 - 파라메터가 모두 노출됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		
		System.out.println("id :" + request.getParameter("id") );
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	// post방식 요청 - 로그인, 글등록, 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
