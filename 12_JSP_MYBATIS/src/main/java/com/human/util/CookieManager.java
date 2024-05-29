package com.human.util;

import javax.servlet.http.Cookie;
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
	
	// 쿠키 값을 반환
	
	
	
}
