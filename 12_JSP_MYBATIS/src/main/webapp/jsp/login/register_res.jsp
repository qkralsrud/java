<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String intro = "";
	if(request.getParameter("intro") != null){
		intro = request.getParameter("intro").replace("\r\n", "<br>");		
	}
%>

${param.id }<br>
${param.sex }<br>
${param.favo }<br>
${param.intro }<br>
줄바꿈처리 : <%=intro %>

</body>
</html>