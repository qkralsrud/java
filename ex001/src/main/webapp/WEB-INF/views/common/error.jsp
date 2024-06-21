<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<main class="text-center">
예외사항이 발생 하였습니다.
<br>관리자에게 문의해주세요.
<br>${e.message }

</main>
<%@include file="footer.jsp" %>
</body>
</html>