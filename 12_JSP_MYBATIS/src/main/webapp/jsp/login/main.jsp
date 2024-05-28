<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
${msg }
${param.loginErr}
<%
	//if(request.getParameter("loginErr") != null && request.getParameter("loginErr").equals("1")){
	if("1".equals(request.getParameter("loginErr"))){
		out.print("로그인실패");
	}
%>
<form action="login.jsp" method="post">
id : <input type="text" name="id" value="momo"><br>
pw : <input type="text" name="pw" value="1234"><br>
<button>로그인</button>
</form>
</body>
</html>