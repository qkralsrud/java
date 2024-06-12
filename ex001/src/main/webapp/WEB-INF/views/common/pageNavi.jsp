<%@ page import="com.spring.ex001.dto.PageDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	PageDto pageDto = new PageDto(100, 3, 10);
	request.setAttribute("pageDto", pageDto);
%>
</head>
<body>
${pageDto } <br>
startNo : ${pageDto.startNo }
endNo : ${pageDto.endNo }
prev : ${pageDto.prev }
next : ${pageDto.next }
<nav aria-label="...">
  <ul class="pagination justify-content-center">
  	<!-- 이전블럭 -->
  	
  	<c:if test="${pageDto.prev }">
  	<!-- disabled : 비활성화 - 화면에 보여주는데 누르지 못하게  -->
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    </c:if>
    
    <!-- 페이지번호 -->
    <c:forEach begin="${pageDto.startNo }" end="${pageDto.endNo }" var="i">
    	<c:choose>
    		<c:when test="${pageDto.pageNo eq i }">
	    		<!-- 현재페이지 -->
			    <li class="page-item active" aria-current="page">
			      <a class="page-link" href="#">${i }</a>
			    </li>
    		</c:when>
    		<c:otherwise>
	    		<!-- 일반 -->
	    		<li class="page-item"><a class="page-link" href="#">${i }</a></li>
    		</c:otherwise>
    	</c:choose>
    </c:forEach>
    
    
    

    <!-- 다음블럭 -->    
    <c:if test="${pageDto.next }">
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
    </c:if>
  </ul>
</nav>
</body>
</html>