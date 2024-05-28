<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1. 클라이언트와 서버의 환경정보 읽어오기</h2>
전송방식 : <%=request.getMethod() %>
<br>클라이언트IP : <%=request.getRemoteAddr() %>
<br>요청주소 : <%=request.getRequestURL() %>
			<br><%=request.getRequestURI() %>
<br>쿼리스트링 : <%=request.getQueryString() %>
<br>파라메터 : <%=request.getParameter("id") %>
<%
// 체크박스처럼 하나의 이름으로 여러개의 값이 전달 되는경우
// getParameterValues 메서드를 이용해서 값을 가지고 올 수 있다
	String[] idArr = request.getParameterValues("id");
	out.print("<h2>아이디 목록 ==========</h2>");
	for(String id : idArr){
		out.print(id+"<br>");
	}
%>
	

</body>
</html>