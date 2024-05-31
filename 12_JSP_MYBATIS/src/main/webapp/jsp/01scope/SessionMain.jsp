<%@page import="com.human.dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>session영역에 값을 저장하기</h2>
<%
	session.setAttribute("userId", "momo");
	session.setAttribute("book"
				, new BookDTO("2", "스프링 웹 프로젝트", "구멍가게코딩단"));
%>
page < request < session,
session영역은 reqeust영역보다 더 큰 영역 이므로 request영역이 공유되는 영역은 모두 공유된다
page, include, forward
<h2>요청이 달라져도 공유된다!!</h2>
redirect, 링크, submit
<h2>만료시간이 지나면 세션이 종료되므로 새로운 세션ID를 발급 받는다</h2>
로그인 후 시간이 지나면 자동으로 로그아웃되는 현상
<hr> 
${userId }님 환영합니다.
<hr>
<a href="Location.jsp">Location.jsp로 이동</a>

</body>
</html>








