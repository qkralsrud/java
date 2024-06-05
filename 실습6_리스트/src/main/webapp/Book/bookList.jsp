<%@page import="com.human.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록 조회</title>
<script type="text/javascript">
	function go(pageNo){
		document.location='/bookList?pageNo='+pageNo;
	}
</script>
</head>
<body>
<h2>도서목록</h2>
<table border="1">
	<tr>
		<td>번호</td>
		<td width="100px">제목</td>
		<td>작가</td>
		<td>대여여부</td>
	</tr>
<c:choose>
	<c:when test="${empty map.list }">
		<tr>
			<td colspan="4">목록이 존재하지 않습니다.</td>
		</tr>
	</c:when>
	<c:otherwise>
		<c:forEach items="${map.list }" var="book">
			
			<tr>
				<td>${book.no }</td>
				<td>${book.title }</td>
				<td>${book.author }</td>
				<td>${book.rent_yn }</td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
</table>

<!-- 외부파일을 불러옵니다. -->
<%@ include file = "/common/pageNavi3.jsp" %>
</body>
</html>