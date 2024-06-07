<%@page import="com.human.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function go(pageNo){
	
	searchForm.pageNo.value=pageNo;
	searchForm.submit();
}
</script>
</head>
<body>
<h3>사용자 목록</h3>
<!-- 
	1. searchForm만들고 검색 버튼을 클릭시 파라메터 유지하기
	2. 컨트롤러에서 검색 파라메터 수집및 전달
	3. 쿼리 수정(리스트및 총건수 조회 쿼리 수정)
	4. 페이지 번호를 클릭시 폼이 전송 될 수 있도록 수정
 -->
<form action="/memberList" method="get" name="searchForm">
	<select name="searchField">
		<option value="id" ${param.searchField == 'id' ? 'selected' : '' }>아이디</option>
		<option value="name" ${param.searchField == 'name' ? 'selected' : '' }>이름</option>
	</select>
	<input type="text" name="searchWord" value="${param.searchWord }">
	<input type="hidden" name="pageNo" value="${param.pageNo }">
	<button onclick="go(1)">검색</button>
</form>
<hr>
<c:choose>
	<c:when test="${empty map.list }">
		데이터가 존재하지 않습니다.
	</c:when>
	<c:otherwise>
		<c:forEach items="${map.list }" var="member">
			${member.ID} / ${member.NAME } <br>
		</c:forEach>
	</c:otherwise>
</c:choose>

<!-- 페이지 블럭을 그려주는 페이지를 불러옵니다 -->
<%@include file="/common/pageNavi3.jsp" %>

</body>
</html>