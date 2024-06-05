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
	document.location = "/memberList?pageNo="+pageNo;
}
</script>
</head>
<body>
<h3>사용자 목록</h3>
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