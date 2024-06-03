package com.human.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	// 쿠키생성
	public static void makeCookie(HttpServletResponse response
										, String name, String value, int maxAge){
		// 쿠키생성
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		
		// 응답객체에 추가
		response.addCookie(cookie);
	}
	
	// 쿠키 삭제
	public static void deleteCookie(HttpServletResponse response
							, String name, String value){
		// 쿠키생성-쿠키를 제거하기 위해서 응답시간을 0으로 설정합니다.
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		
		// 응답객체에 추가
		response.addCookie(cookie);
	}
	// 쿠키 값을 반환
	public static String getCookieValue(HttpServletRequest request, String name) {
		String value= "";
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(name)) {
				return cookie.getValue();
			}
		}
		
		
		
		return value;
		
	}
		
		
		
		
	
}
