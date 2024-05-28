<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서정보 조회</h2>

<form action="/bookDetail" method="get">
	<input type="text" name="no" value="1">
	<button>도서조회</button>
</form>

<hr>

<h2>도서목록 조회</h2>

<a href="/bookList">도서목록 조회</a>
<hr>

<h2>도서 입력</h2>

<form action="/bookInsert" method="post">
	제목 : <input type="text" name="title"><br>
	작가 : <input type="text" name="author"><br>
	<button>도서입력</button>
</form>

<hr>

<form action="/bookDelete" method="post">

<h2>도서 삭제</h2>

<input type="text" name="no" value="58">
<button>도서삭제</button>
</form>

<hr>
<br>

<h2>도서 수정</h2>

<form action="/bookUpdate" method="post">
	번호 : <input type="text" name="no"><br>
	제목 : <input type="text" name="title"><br>
	작가 : <input type="text" name="author"><br>
	<button>도서수정</button>
</form>

</body>
</html>