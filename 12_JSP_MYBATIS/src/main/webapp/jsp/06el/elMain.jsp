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
	// 페이지 영역에 속성을 저장
	pageContext.setAttribute("scopeValue", "페이지 영역");
	request.setAttribute("scopeValue", "리퀘스트 영역");
	session.setAttribute("scopeValue", "세션 영역");
	application.setAttribute("scopeValue", "어플리케이션 영역");

%>
영역이 지정되지 않은경우, 가까운 영역부터 찾아서 출력하므로 페이지영역에 저장된 값이 출력 된다!!
<br>
${scopeValue }
<br>
영역에 저장된 값이 없는경우 아무것도 출력하지 않으며 예외와 형변환에 관대하다

<h2>내장객체에 저장된 속성 읽기</h2>
<ul>
	<li>페이지영역 : ${pageScope.scopeValue }</li>
	<li>리퀘스트영역 : ${requestScope.scopeValue }</li>
	<li>세션영역 : ${sessionScope.scopeValue }</li>
	<li>어플리케이션영역 : ${applicationScope.scopeValue }</li>
</ul>




</body>
</html>