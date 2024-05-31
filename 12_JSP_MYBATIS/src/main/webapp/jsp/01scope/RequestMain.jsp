<%@page import="com.human.dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Request영역</h3>
<h4>request영역에 속성값을 저장하기</h4>
<%
	// 내장객체의 영역에 속성값을 저장 해서 값을 주고 받는것
	request.setAttribute("requestString", "request영역의 문자열");
	request.setAttribute("requestObject", new BookDTO("1", "성낙현의JSP", "성낙현"));
	
%>

<%-- JSP 주석 --%>
<!-- HTML 주석  object getter메서드를 통해 값을 출력-->
<h4>속성값 읽기</h4>
${requestString} / ${requestObject.title }

<!-- include파일에서 Request영역이 공유 되는것을 확인 할 수 있다 -->
<%@include file="PageInclude.jsp" %>
<!-- forward를 통해서 연결된 페이지에서 Request 영역이 공유되는것을 확인 할 수 있다-->
<%
	// 쿼리 스트링을 이용해서 값을 넘길 수 있다!!!!!!
	// 요청정보로(화면에서) 부터 꺼내 오는 값 (request.getParamater()를 이용해서 값을 꺼내올 수 있다)
	// 내장객체의 영역에 속성을 저장해서 값을 전달 할 수 있다
	request.getRequestDispatcher("Location.jsp?param=한글").forward(request, response);
	// redirect시에는 request 영역이 공유되지 않는다
	// redirect는 웹브라우저에게 다른 페이지를 요청하라고 알려주는것이고, 
	// 웹브라우저에서 다른 페이지를 요청 합니다. 
	// 이것은 하나의 요청이 아니라 2개 요청이 생기게 되는것이죠!
	//response.sendRedirect("Location.jsp");
	// redircet를 이용할 경우, 값을 전달 
%>


</body>
</html>









