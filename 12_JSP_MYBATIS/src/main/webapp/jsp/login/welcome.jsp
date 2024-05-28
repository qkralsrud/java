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
HttpSession sessions = request.getSession();
%>

<%=sessions.getAttribute("userId") %>
id, pw를 입력하고 login.jsp로 요청을 보내봅시다!!<br>
세션에 저장된 아이디를 출력 : ${id }<br>
파라메터로 넘어온 아이디를 출력(쿼리스트링) : ${param.id }
</body>
</html>