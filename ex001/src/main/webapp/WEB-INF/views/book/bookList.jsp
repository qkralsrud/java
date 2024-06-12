<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- 부트스트랩 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h2>도서목록</h2>

<table class="table table-striped">
  <thead>
  	<!-- 타이틀 -->
    <tr>
      <th scope="col">번호</th>
      <th scope="col">도서명</th>
      <th scope="col">작가명</th>
      <th scope="col">대여여부</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="book">
    <tr>
      <th scope="row">${book.no }</th>
      <td>${book.title }</td>
      <td>${book.author }</td>
      <td>${book.rent_yn_str }</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<%@ include file="/WEB-INF/views/common/pageNavi.jsp" %>

<!-- 부트스트랩 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>