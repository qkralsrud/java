<%@page import="com.human.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String save_check = request.getParameter("save_check");
	if("Y".equals(save_check)){
		// 쿠키를 생성하고 response객체에 담아 줍니다.
		// 쿠키의 이름 : loginId, 값 :  파라메터로 넘어온 user_id
		/*
		Cookie cookie = new Cookie("loginId", request.getParameter("user_id"));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*7);
		
		response.addCookie(cookie);
		*/
		// 공통로직을 사용하여 쿠키를 생성하고 응답객체에 추가
		CookieManager.makeCookie(response
					, "loginId"
					, request.getParameter("user_id")
					, 60*60*7);
		
		
	} else {
		// 쿠키 제거(유효기간 0으로)
		Cookie cookie = new Cookie("loginId", request.getParameter("user_id"));
		cookie.setPath("/");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
	}
	
%>




id : ${param.user_id }
<br>pw : ${param.user_pw }
<br>아이디저장 : ${param.save_check }
</body>
</html>