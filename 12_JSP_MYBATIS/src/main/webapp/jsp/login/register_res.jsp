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
	
	//체크박스인 경우, 같은 이름으로 여러개의 값이 넘어올수 있다.
	//여러개의 값을 받아서 처리하기 위해서 getParameterValues를 이용합니다.
	String favo = "";
	//똑같은 이름으로 여러개 받을꺼야
	String[] favoArr = request.getParameterValues("favo");
	for(String f : favoArr ){
		favo += f +" ";
	}
	
%>

${param.id }<br>
${param.sex }<br>
${param.favo }<br>
${param.intro }<br>
체크박스 배열처리 : <%=favo %>
줄바꿈처리 : <%=intro %>

</body>
</html>