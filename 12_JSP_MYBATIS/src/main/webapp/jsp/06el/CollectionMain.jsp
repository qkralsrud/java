<%@page import="com.human.dto.PageDto"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.human.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>리스트 - 동일한 타입의 객체를 저장 할때 사용</h2>
<%
	// 목록을 구현할때 많이 사용되는 타입
	List<BookDTO> list = new ArrayList<BookDTO>();
%>
<h2>Map - 키와 값으로 객체를 저장 할때 사용</h2>
<%
	// map생성
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, String> mapString = new HashMap<String, String>();
	//Map<Integer, Object> mapInt = new HashMap<Integer, Object>();
	
	// map에 데이터를 추가
	map.put("list", list);
	map.put("pageDto", new PageDto(150, 15, 10));
	map.put("msg", "리스트를 조회");
	map.put("int", 1);
	
	// java에서 map에 저장된 값을 꺼내는 방법
	// 키로 꺼내서 형변환 해야 합니다.
	String msg = (String)map.get("msg");
	
	request.setAttribute("map", map);
	
%>
map.list : 
${map.list }
<br>map.pageDto : 
${map.pageDto }
<br>map.msg : 
${map.msg }













</body>
</html>