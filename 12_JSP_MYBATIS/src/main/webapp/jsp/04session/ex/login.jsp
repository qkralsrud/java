<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
cookie : ${cookie.id.value }

<%
	
%>

	<form action="/LoginAction" method="post">
	<input type="text" name="user_id" value="momo">
	<input type="checkbox" name="chkbox" value="1">아이디 저장 <br>
	<button>전송</button>
	
	</form>
</body>
</html>