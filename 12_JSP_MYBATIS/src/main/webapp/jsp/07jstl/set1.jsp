
<%@page import="com.human.dto.PageDto"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.human.dto.BookDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 태그라이브러리를 이용해서 반복문과 제어문을 이용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jstl 라이브러리 추가후 이용 가능 합니다. -->
<!-- 변수 선언 
	var : 변수이름
	value : 값
-->
<c:set var="directVal" value="100"></c:set>
<c:set var="elVal" value="${directVal mod 5 }"/>
<c:set var="expVar" value="<%= new Date() %>"></c:set>
<c:set var="betweenVar">태그사이에값을 입력</c:set>

<h3>EL표현언어를 이용해서 변수를 출력</h3>
	${pageScope.directVal }<br>
	${elVal }<br>
	${expVar } <br>
	${betweenVar }

<h3>자바빈즈 생성</h3>
<c:set var="book" value='<%=new BookDTO("1", "코드로 배우는 스프링", "구멍가게코딩단") %>' scope="request"></c:set>
<ul>
	<li>${requestScope.book.no }</li>
	<li>${book.title }</li>
	<li>${book.author }</li>
</ul>

<h3>자바빈즈 생성 2 - target, property 사용</h3>
<c:set var="book2" value="<%=new BookDTO() %>"></c:set>
<c:set target="${book2 }" property="title" value="도서명" />
<c:set target="${book2 }" property="author" value="작가명" />
<ul>
	<li>${book2.no }</li>
	<li>${book2.title }</li>
	<li>${book2.author }</li>
</ul>

<h3>List 컬렉션 이용하기</h3>
<%
	List<BookDTO> list = new ArrayList<BookDTO>();
	list.add(new BookDTO("1", "코드로 배우는 스프링", "구멍가게코딩단"));
	list.add(new BookDTO("2", "성낙현의JSP", "성낙현"));
	list.add(new BookDTO("3", "혼공자", "신용권"));
%>
<c:set var="bookList" value="<%=list %>"></c:set>
<ul>
	<li>${bookList[0].title} / ${bookList[0].author}</li>
	<li>${bookList[1].title}</li>
	<li>${bookList[2].title}</li>
</ul>

<h3>Map 컬렉션 사용하기</h3>
<%
	//map을 생성하고 list를 담고, pageDto를 담아봅시다
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("list", list);
	map.put("pageDto", new PageDto(100, 5, 10));
	request.setAttribute("map", map);
%>
<c:set var="map" value="${map }"></c:set>
<ul>
	<li>${map.pageDto.prev }</li>
	<li>${map.pageDto.startNo }</li>
	<li>${map.pageDto.endNo }</li>
	<li>${map.pageDto.next }</li>
</ul>
</body>
</html>









