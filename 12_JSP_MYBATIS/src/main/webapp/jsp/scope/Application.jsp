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
	<h2>Application 영역</h2>
	<%
		application.setAttribute("book"
				, new BookDTO("2", "자바스크립트", "고경희"));

	%>
	
	${book }
	<%
		// 내장객체의 속성을 제거
		application.removeAttribute("book");
	%>
	<h2>속성제거</h2>
	${book }
	<br>
	<a href="Location.jsp">Location.jsp 바로가기</a>
</body>
</html>