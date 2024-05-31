<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/MemberLogoutController">
	${userId } 님 환영합니다. <button>로그아웃</button>
	<br> loginMember : ${loginMember }
</form>
</body>
</html>