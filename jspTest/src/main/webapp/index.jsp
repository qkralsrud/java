<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- java코드를 작성 -->
<%
	// jsp : 기본 형식은 html형식을 하고 있고, 자바코드를 작성 할수 있다
	String str1 = "jsp";
	String str2 = "안녕하세요";
%>
<h2>처음 만들어보는 <%=str1 %></h2>

<form action="index.jsp">
	<input type="text" name="id" value="momo">
	<button>전송</button>
</form>
id : <%=request.getParameter("id") %>
</body>
</html>