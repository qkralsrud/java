<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="com.human.dto.PageDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 
pageNavi.jsp는 공통으로 이용되는 페이지입니다.
리스트를 요청하기 위해서 함수를 이용합니다.
하단의 함수를 리스트페이지에 작성 해주세요!!
url을 요청 경로로 변경 해야 합니다.

<script type="text/javascript">
	function go(pageNo){
		document.location='url?pageNo='+pageNo;
	}
</script>
-->

<script type="text/javascript">
	function go(pageNo){
		document.location='/common/pageNavi2.jsp?pageNo='+pageNo;
	}
</script>
</head>
<body>
<hr>
<h3>pageNavi.jsp</h3>
<%
	int pageNo = 130;
	if(request.getParameter("pageNo") != null){
		pageNo = Integer.parseInt(request.getParameter("pageNo"));
	}
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("pageDto", new PageDto(130, pageNo, 5));
	request.setAttribute("map", map);

	Map<String, Object> m = (Map<String, Object>)request.getAttribute("map"); 
	PageDto pageDto = (PageDto)m.get("pageDto");
%>

<c:set var="pageDto" value="${map.pageDto }"></c:set>

<c:if test="${empty pageDto}">
	pageDto is null
</c:if>

<c:choose>
	<c:when test="${empty pageDto }">
		pageDto is null
	</c:when>
	<c:otherwise>
		<c:if test="${pageDto.prev }">
			<a href="javascript:go(${pageDto.startNo-1 })">◀</a>
		</c:if>
		<c:forEach begin="${pageDto.startNo }" end="${pageDto.endNo }" var="i">
			<a href="javascript:go(${i })">${i }</a>
		</c:forEach>
		<c:if test="${pageDto.prev }">
			<a href="javascript:go(${pageDto.endNo+1 })">▶</a>
		</c:if>
	</c:otherwise>
</c:choose>

</body>
</html>