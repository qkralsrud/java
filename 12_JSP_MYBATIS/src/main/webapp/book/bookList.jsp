<%@page import="com.human.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서목록</h2>
${list }
<%

	List<BookDTO> list = (List<BookDTO>)request.getAttribute("list");

	if(list != null){
		for(BookDTO book : list){
			out.print(book + "<br>");
		}
	}
%>
</body>
</html>