<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서 상세보기</h2>
파라메터로 넘어온 값 : ${param.no}<br>
${book}<br><%= request.getAttribute("book")%><br>
번호 : ${book.no }<br>
제목 : ${book.title }<br>
작가 : ${book.author }<br>

userId : ${userId }<br>
<br>
<!-- index.jsp라고 호출 할 경우, book/index.jsp를 찾아갑니다. -> 404오류 -->
<a href="/index.jsp">index.jsp</a>
<button onclick="history.back()">뒤로가기</button>
</body>
</html>