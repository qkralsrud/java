<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서등록</title>
</head>
<body>
<%@include file="../common/header.jsp" %>

<h2>도서등록</h2>
<form action="/bookRegAction" enctype="multipart/form-data" method="post">

<input type='file' name = "uploadFile" id = "uploadFile">
<br><br>

<button>전송</button>
</form>
<%@include file="../common/footer.jsp" %>

</body>
</html>