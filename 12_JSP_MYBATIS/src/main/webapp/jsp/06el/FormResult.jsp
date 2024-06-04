<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL로 폼값 입력 받기</h3>
<ul>
	<!-- 파라메터로 전달된값을 출력 할경우, param -->
	<li>이름 : ${param["이름"] }</li>
	<li>성별 : ${param.gender }</li>
	<li>학력 : ${param.grade }</li>
	<li>관심사항 : ${paramValues.inter[0] }
	 		${paramValues.inter[1] }
	  		${paramValues.inter[2] }
	   		${paramValues.inter[3] }
	</li>
</ul>
	
<hr>

<h2>요청 헤더정보</h2>
	userAgent : <%= request.getHeader("user-agent")%>
	<br>
	${header["user-agent"] }
	
<h2>쿠키값 출력하기</h2>
	${cookie }
	${cookie.JSESSIONID }
	${cookie.JSESSIONID.value }
	
<h2>contextPath</h2>
${pageContext.request.contextPath }
	
	




</body>
</html>