package com.spring.ex001.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginIntercepter implements HandlerInterceptor{


	/**
	 * 컨트롤러를 실행하기 전에 실행
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인 체크
		HttpSession session = request.getSession();
		System.out.println("인터셉터 >>>>> login ID : " + session.getAttribute("id"));
		if(session.getAttribute("id") == null) {
			request.setAttribute("msg", "로그인후 사용 가능한 메뉴 입니다.");
			request.setAttribute("url", "/login");
			request.getRequestDispatcher("/WEB-INF/views/common/msgBox.jsp").forward(request, response);
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}