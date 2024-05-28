<%@page import="com.human.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.human.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서수정</h2>
자바코드를 입력하는 3가지 방법
<%! %> 	: 선언부로 메서드 선언, 전역변수 선언이 가능합니다.
<% %>	: JAVA코드를 입력, 메서드 선언 불가, 지역변수 선언 가능
<%= request.getParameter("") %>	: 하나의 값을 출력하는 용도로 사용


${msg}
<br>no : <%=request.getParameter("no") %>
<br>msg : <%=request.getAttribute("msg") %>

<%
	// 웹브라우저에 출력 하고 싶을때 사용
	out.print("<br>안녕하세요!");
	out.print(request.getParameter("no"));
	
	BookService service = new BookService();
	List<BookDTO> list = service.selectBookList();
	for(BookDTO book:list){
		out.print(book.getTitle()+"/"+book.getAuthor()+"<br>"); 
	}
	out.print(list);
%>

</body>
</html>