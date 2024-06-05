<%@page import="com.human.dto.PageDto"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.print.attribute.HashAttributeSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.human.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>일반적인 for문</h3>
varStatus : 루프의 현재 상태를 알려주는 변수 이름을 지정
<c:forEach begin="3" end="5" step="1" var="i" varStatus="loop">
	<p>${i }</p>
    <tr>
       <td>count : ${ loop.count }</td>
       <td>index : ${ loop.index }</td>
       <td>current : ${ loop.current }</td>
       <td>first : ${ loop.first }</td>
       <td>last : ${ loop.last }</td>
    </tr>
</c:forEach>

<h4>1에서 100까지 정수 중 홀수의 합</h4>
<c:forEach begin="1" end="100" step="2" var="j">
	<p>${j }</p>
	<c:set var="sum" value="${sum + j }"></c:set>
	<!-- 
	<c:if test="${j mod 2 ne 0 }">
		<p>${j }</p>
	</c:if>
	 -->
	<!-- ${j mod 2 eq 1 } ${j mod 2 ne 0 } -->
</c:forEach>

1~100 사이의 정수중 홀수의 합 : ${sum }


<h3>향상된 for문</h3>
<%
	String[] rgba = {"red", "green", "blue", "black"};
%>

<c:forEach items="<%=rgba %>" var="arr">
	<span style="color:${arr}">${arr }</span>
</c:forEach>

<c:forEach items="<%=rgba %>" var="arr" varStatus="loop">
<table border="1">
	<tr>
       <td>count : ${ loop.count }</td>
       <td>index : ${ loop.index }</td>
       <td>current : ${ loop.current }</td>
       <td>first : ${ loop.first }</td>
       <td>last : ${ loop.last }</td>
    </tr>
</table>
</c:forEach>

<h3>List 컬렉션 이용하기</h3>
<%
	List<BookDTO> list = new ArrayList<BookDTO>();
	list.add(new BookDTO("1", "성낙현JSP", "성낙현"));
	list.add(new BookDTO("2", "혼공자", "신용권"));
	list.add(new BookDTO("3", "스프링웹프로젝트", "구멍가게코딩단"));
	request.setAttribute("list", list);
%>

<c:forEach items="${list }" var="book" varStatus="loop">
	<c:if test="${loop.first }">
	번호 | 제목 | 작가 <br>
	</c:if>

	${book.no } | 
	${book.title } |
	${book.author }<br>

</c:forEach>

<h3>Map 컬렉션 이용하기</h3>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("list", list);
	map.put("pageDto", new PageDto(120, 7, 10));
	
	// el표현언어를 이용해서 사용할 수 있도록 영역에 저장
	request.setAttribute("map", map);
%>
${m }
${m.list }
${m.pageDto }
<c:forEach items="${map }" var="m">
	<ul>
		<li>key : ${m.key }</li>
		<li>value : ${m.value }</li>
	</ul>
</c:forEach>

<c:set var="p" value="${map.pageDto }"></c:set>

<c:choose>
	<c:when test="${ empty map.pageDto }">
		pageDto is null
	</c:when>
	<c:otherwise>
		<c:if test="${p.prev }">◀</c:if>
		<c:forEach begin="${p.startNo }" end="${p.endNo }" var="no"> ${no} </c:forEach>
		<c:if test="${p.next }">▶</c:if>
	</c:otherwise>
</c:choose>





















</body>
</html>