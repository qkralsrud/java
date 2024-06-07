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
		//document.location='/bookList?pageNo='+pageNo;
		//1.페이지 이동 함수에 파라메터를 추가 
		//'/bookList ? pageNo ='+pageNo+'&searchField='+'&searchWord=';
		//2.form을 submit
		searchForm.pageNo.value=pageNo;
		searchForm.submit();
	}
</script>

</head>
<body>
<h2>도서목록</h2>
 <form action="/bookList">
 	<select name="searchField">
 	<!-- 내가 select 에서 선택한 옵션을 그대로 유지시킨다 ${param.searchField eq 'publisher'? 'selected':'' }-->
 		<option value="title" ${param.searchField eq 'title'? 'selected':'' }>도서명</option> 
 		<option value="author" ${param.searchField eq 'author'? 'selected':'' }>작가명</option> 
 		<option value="publisher" ${param.searchField eq 'publisher'? 'selected':'' }>출판사명</option> 
 	</select>
	<input type="text" name="searchWord" value="${param.searchWord }">
	<input type="text" name="pageNo" value="${param.pageNo }">
	<button>검색</button>
	 		
 </form>

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