<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="com.human.dto.PageDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<h3>pageNavi.jsp</h3>

<c:choose>
	<c:when test="${empty map.pageDto }">
		pageDto is null
	</c:when>
	<c:otherwise>
		<!-- 이전블럭 -->
		<c:if test="${map.pageDto.prev }">
			<a href="javascript:go(${map.pageDto.startNo-1 })">◀</a>
		</c:if>
		<!-- 페이지 번호 출력 -->
		<c:forEach begin="${map.pageDto.startNo }" 
						end="${map.pageDto.endNo }" var="pageNo">
			<a href="javascript:go(${pageNo })">${pageNo }</a>				
		</c:forEach>
		<!-- 다음블럭 -->
		<c:if test="${map.pageDto.next }">
			<a href="javascript:go(${map.pageDto.endNo+1})">▶</a>
		</c:if>
	</c:otherwise>
</c:choose>








</body>
</html>